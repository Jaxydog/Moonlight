package dev.jaxydog.moonlight.item.unique;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MLItem.Config;
import dev.jaxydog.moonlight.utility.Registerable;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ScytheItem extends SwordItem implements Registerable {

	protected static final Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> TILLING_ACTIONS = Maps.newHashMap(
		ImmutableMap.of(
			Blocks.GRASS_BLOCK,
			Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState())),
			Blocks.DIRT_PATH,
			Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState())),
			Blocks.DIRT,
			Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState())),
			Blocks.COARSE_DIRT,
			Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.DIRT.getDefaultState())),
			Blocks.ROOTED_DIRT,
			Pair.of(c -> true, HoeItem.createTillAndDropAction(Blocks.DIRT.getDefaultState(), Items.HANGING_ROOTS))
		)
	);

	protected final Config _CONFIG;

	public ScytheItem(Settings settings, Config config) {
		super(ToolMaterials.DIAMOND, 5, 0f, settings.group(Config.DEFAULT_GROUP));
		_CONFIG = config;
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_CONFIG.getName());
	}

	@Override
	public Registerable register() {
		var modifier = _CONFIG.getLootModifier();
		Identifier tableId;

		if (modifier != null && ((tableId = modifier.getTableId()) != null)) {
			LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
				if (!source.isBuiltin() || !id.equals(tableId)) {
					return;
				}

				builder.pool(
					LootPool
						.builder()
						.rolls(BinomialLootNumberProvider.create(modifier.getRolls(), modifier.getChance()))
						.with(ItemEntry.builder(this))
				);
			});
		}

		return Registry.register(Registry.ITEM, getId(), this);
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		var key = stack.getItem().getTranslationKey() + ".tooltip_";
		var i = 0;

		while (_CONFIG.isTooltipEnabled() && I18n.hasTranslation(key + i)) {
			tooltip.add(Text.translatable(key + i).formatted(Formatting.GRAY));
			i += 1;
		}

		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		var sound = _CONFIG.getUseSound();

		if (sound != null) {
			var change = (float) (Math.random() * (Config.PITCH_VARIANCE * 2)) - Config.PITCH_VARIANCE;
			var pitch = 1.0f - change;

			world.playSoundFromEntity(null, user, sound, SoundCategory.PLAYERS, Config.DEFAULT_VOLUME, pitch);
		}

		return super.finishUsing(stack, world, user);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return _CONFIG.isGlintEnabled() && (_CONFIG.isGlintForced() || super.hasGlint(stack));
	}

	@Override
	public boolean isSuitableFor(BlockState state) {
		int i = this.getMaterial().getMiningLevel();

		if (i < MiningLevels.DIAMOND && state.isIn(BlockTags.NEEDS_DIAMOND_TOOL)) {
			return super.isSuitableFor(state);
		}
		if (i < MiningLevels.IRON && state.isIn(BlockTags.NEEDS_IRON_TOOL)) {
			return super.isSuitableFor(state);
		}
		if (i < MiningLevels.STONE && state.isIn(BlockTags.NEEDS_STONE_TOOL)) {
			return super.isSuitableFor(state);
		}

		return state.isIn(BlockTags.HOE_MINEABLE) || super.isSuitableFor(state);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0, false, true), attacker);

		return super.postHit(stack, target, attacker);
	}

	@Override
	public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
		if (!world.isClient && state.getHardness(world, pos) != 0.0f) {
			stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
		}

		return true;
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		BlockPos pos;
		World world = context.getWorld();
		var pair = TILLING_ACTIONS.get(world.getBlockState(pos = context.getBlockPos()).getBlock());

		if (pair == null) {
			return ActionResult.PASS;
		}

		var predicate = pair.getFirst();
		var consumer = pair.getSecond();

		if (predicate.test(context)) {
			var player = context.getPlayer();

			world.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0f, 1.0f);

			if (!world.isClient) {
				consumer.accept(context);

				if (player != null) {
					context.getStack().damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
				}
			}

			return ActionResult.success(world.isClient);
		}

		return ActionResult.PASS;
	}
}
