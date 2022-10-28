package dev.jaxydog.moonlight.item;

import java.util.List;

import javax.annotation.Nullable;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.utility.Registerable;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MLItem extends Item implements Registerable {

	protected final Config _CONFIG;

	public MLItem(Settings settings, Config config) {
		super(settings.group(Config.DEFAULT_GROUP));
		_CONFIG = config;
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_CONFIG.getName());
	}

	@Override
	public MLItem register() {
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

	public static class Config {

		public static final float DEFAULT_VOLUME = 0.25f;
		public static final float PITCH_VARIANCE = 0.125f;
		public static final ItemGroup DEFAULT_GROUP = FabricItemGroupBuilder.build(Moonlight.id("general"),
				() -> MLItems.ICON.getDefaultStack());

		private final String __NAME;
		private boolean __enableGlint = true;
		private boolean __forceGlint = false;
		private boolean __hasTooltip = false;
		@Nullable
		private SoundEvent __useSound = null;
		@Nullable
		private LootModifier __loot = null;

		public Config(String name) {
			__NAME = name;
		}

		public String getName() {
			return __NAME;
		}

		public boolean isGlintEnabled() {
			return __enableGlint;
		}

		public boolean isGlintForced() {
			return __forceGlint;
		}

		public boolean isTooltipEnabled() {
			return __hasTooltip;
		}

		@Nullable
		public SoundEvent getUseSound() {
			return __useSound;
		}

		@Nullable
		public LootModifier getLootModifier() {
			return __loot;
		}

		public Config disableGlint() {
			__enableGlint = false;
			__forceGlint = false;
			return this;
		}

		public Config forceGlint() {
			__enableGlint = true;
			__forceGlint = true;
			return this;
		}

		public Config withTooltip() {
			__hasTooltip = true;
			return this;
		}

		public Config useSound(SoundEvent sound) {
			__useSound = sound;
			return this;
		}

		public Config lootModifier(LootModifier loot) {
			__loot = loot;
			return this;
		}

		public Config clone() {
			return clone(getName());
		}

		public Config clone(String name) {
			var c = new Config(name);

			c.__enableGlint = __enableGlint;
			c.__forceGlint = __forceGlint;
			c.__hasTooltip = __hasTooltip;
			c.__useSound = __useSound;

			return c;
		}

	}

	public static class LootModifier {

		@Nullable
		private Identifier __id = null;
		private int __rolls = 0;
		private float __chance = 0.0f;

		@Nullable
		public Identifier getTableId() {
			return __id;
		}

		public int getRolls() {
			return __rolls;
		}

		public float getChance() {
			return __chance;
		}

		public LootModifier table(Identifier id) {
			__id = id;
			return this;
		}

		public LootModifier rolls(int rolls) {
			__rolls = rolls;
			return this;
		}

		public LootModifier chance(float chance) {
			__chance = chance;
			return this;
		}

		public LootModifier clone() {
			var d = new LootModifier();

			d.__chance = __chance;
			d.__id = __id;
			d.__rolls = __rolls;

			return d;
		}

	}

}
