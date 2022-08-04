package dev.jaxydog.moonlight.item;

import java.util.List;

import javax.annotation.Nullable;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.data.MoonlightDataTypes.PentaFunction;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

/** Item wrapper class */
public class MoonlightItem extends Item {
	private final Config CONFIG;

	public MoonlightItem(Settings settings, Config config) {
		super(settings.group(Config.DEFAULT_GROUP));
		CONFIG = config;
	}

	/** Returns the item's identifier */
	public Identifier getId() {
		return Moonlight.id(CONFIG.getName());
	}

	/** Registers the item */
	public MoonlightItem register() {
		return Registry.register(Registry.ITEM, this.getId(), this);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return CONFIG.isGlintEnabled() && (CONFIG.isGlintForced() || super.hasGlint(stack));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if (CONFIG.isTooltipEnabled()) {
			var key = "item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip";
			tooltip.add(Text.translatable(key).formatted(Formatting.GRAY));
		}

		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (CONFIG.getUseSound() != null) {
			var pitch = (float) (Math.random() * (Config.PITCH_RANGE * 2)) - Config.PITCH_RANGE;

			world.playSound(
					null,
					user.getBlockPos(),
					CONFIG.getUseSound(),
					SoundCategory.PLAYERS,
					Config.DEFAULT_VOLUME, pitch);
		}

		for (var status : CONFIG.getUseEffects()) {
			user.addStatusEffect(status, null);
		}

		return super.finishUsing(stack, world, user);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (CONFIG.getInventoryTick() != null) {
			var result = CONFIG.getInventoryTick().apply(stack, world, entity, slot, selected);

			if (!result) {
				return;
			}
		}

		super.inventoryTick(stack, world, entity, slot, selected);
	}

	public static class Config {
		/** Default item group */
		public static final ItemGroup DEFAULT_GROUP = FabricItemGroupBuilder.build(
				Moonlight.id("general"),
				() -> MoonlightItems.ICON.getDefaultStack());
		/** Default volume for sounds created by items */
		public static float DEFAULT_VOLUME = 0.25f;
		/** Default pitch variance for sounds created by items */
		public static float PITCH_RANGE = 0.125f;

		private String name;
		private boolean enableGlint = true;
		private boolean forceGlint = false;
		private boolean tooltip = false;
		private SoundEvent useSound;
		private StatusEffectInstance[] useEffect = {};
		@Nullable
		private PentaFunction<ItemStack, World, Entity, Integer, Boolean, Boolean> invTick;

		/** Clones the configuration */
		public Config clone() {
			var cfg = new Config();
			cfg.name = name;
			cfg.enableGlint = enableGlint;
			cfg.forceGlint = forceGlint;
			cfg.tooltip = tooltip;
			cfg.useSound = useSound;
			cfg.useEffect = useEffect;
			return cfg;
		}

		/** Returns the item's name */
		public String getName() {
			return name;
		}

		/** Sets the item's name */
		public Config setName(String name) {
			this.name = name;
			return this;
		}

		/** Returns whether enchantment glint is enabled on the item */
		public boolean isGlintEnabled() {
			return enableGlint;
		}

		/** Sets whether enchantment glint is enabled on the item */
		public Config setGlintEnabled(boolean enable) {
			this.enableGlint = enable;
			return this;
		}

		/** Returns whether enchantment glint is forced on the item */
		public boolean isGlintForced() {
			return forceGlint;
		}

		/** Sets whether enchantment glint is forced on the item */
		public Config setGlintForced(boolean force) {
			this.forceGlint = force;
			return this;
		}

		/** Returns whether the item has a custom tooltip enabled */
		public boolean isTooltipEnabled() {
			return tooltip;
		}

		/** Sets whether the item has a custom tooltip enabled */
		public Config setTooltipEnabled(boolean enabled) {
			this.tooltip = enabled;
			return this;
		}

		/** Returns the sound that plays when the item is used */
		public SoundEvent getUseSound() {
			return useSound;
		}

		/** Sets the sound that plays when the item is used */
		public Config setUseSound(SoundEvent sound) {
			this.useSound = sound;
			return this;
		}

		/** Returns the effects given when the item is used */
		public StatusEffectInstance[] getUseEffects() {
			return useEffect;
		}

		/** Sets the effects given when the item is used */
		public Config setUseEffects(StatusEffectInstance... effects) {
			this.useEffect = effects;
			return this;
		}

		/** Returns a function that runs each inventory tick */
		public @Nullable PentaFunction<ItemStack, World, Entity, Integer, Boolean, Boolean> getInventoryTick() {
			return invTick;
		}

		/** Sets a function that runs each inventory tick */
		public Config setInventoryTick(PentaFunction<ItemStack, World, Entity, Integer, Boolean, Boolean> invTick) {
			this.invTick = invTick;
			return this;
		}
	}
}
