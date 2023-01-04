package dev.jaxydog.moonlight.item.unique;

import java.util.List;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MLItem.Config;
import dev.jaxydog.moonlight.utility.Registerable;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ScytheItem extends HoeItem implements Registerable {

	protected final Config _CONFIG;

	public ScytheItem(Settings settings, Config config) {
		super(ToolMaterials.DIAMOND, 5, 0f, settings);

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

				builder.pool(LootPool.builder()
						.rolls(BinomialLootNumberProvider.create(modifier.getRolls(), modifier.getChance()))
						.with(ItemEntry.builder(this)));
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
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0, false, true), attacker);

		return super.postHit(stack, target, attacker);
	}

}
