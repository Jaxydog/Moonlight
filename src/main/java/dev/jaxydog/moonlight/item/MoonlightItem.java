package dev.jaxydog.moonlight.item;

import java.util.List;
import dev.jaxydog.moonlight.Moonlight;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MoonlightItem extends Item {
	private final Config CONFIG;

	public MoonlightItem(Config config, Settings settings) {
		super(settings.group(Config.DEFAULT_GROUP));
		this.CONFIG = config;
	}

	public Identifier Id() {
		return Moonlight.Id(CONFIG.getName());
	}

	public MoonlightItem register() {
		return Registry.register(Registry.ITEM, this.Id(), this);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return CONFIG.getGlintForced() || (CONFIG.getGlintEnabled() && super.hasGlint(stack));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if (CONFIG.getTooltipEnabled()) {
			var key = "item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip";
			tooltip.add(Text.translatable(key).formatted(Formatting.GRAY));
		}

		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (CONFIG.getUseSound() != null) {
			var pitch = (float) ((Math.random() * (Config.PITCH_RANGE * 2)) - Config.PITCH_RANGE);
			world.playSound(
					null,
					user.getBlockPos(),
					CONFIG.getUseSound(),
					SoundCategory.PLAYERS,
					Config.DEFAULT_VOLUME, 1 - pitch);
		}

		for (var effect : CONFIG.getUseEffects().clone()) {
			user.addStatusEffect(effect, null);
		}

		return super.finishUsing(stack, world, user);
	}

	public static class Config {
		public static final float DEFAULT_VOLUME = 0.25f;
		public static final float PITCH_RANGE = 0.25f;
		public static final ItemGroup DEFAULT_GROUP = FabricItemGroupBuilder.build(
				Moonlight.Id("main"),
				() -> Items.END_STONE.getDefaultStack());

		private String name;
		private boolean enableGlint = true;
		private boolean forceGlint = false;
		private boolean tooltip = false;
		private SoundEvent sound;
		private StatusEffectInstance[] effects = {};

		public Config clone() {
			return new Config()
					.setName(this.name)
					.setGlintEnabled(this.enableGlint)
					.setGlintForced(this.forceGlint)
					.setTooltipEnabled(this.tooltip)
					.setUseSound(this.sound)
					.setUseEffects(this.effects);
		}

		public String getName() {
			return this.name;
		}

		public Config setName(String value) {
			this.name = value;
			return this;
		}

		public boolean getGlintEnabled() {
			return this.enableGlint;
		}

		public Config setGlintEnabled(boolean value) {
			this.enableGlint = value;
			return this;
		}

		public boolean getGlintForced() {
			return this.forceGlint;
		}

		public Config setGlintForced(boolean value) {
			this.forceGlint = value;
			return this;
		}

		public boolean getTooltipEnabled() {
			return this.tooltip;
		}

		public Config setTooltipEnabled(boolean value) {
			this.tooltip = value;
			return this;
		}

		public SoundEvent getUseSound() {
			return this.sound;
		}

		public Config setUseSound(SoundEvent value) {
			this.sound = value;
			return this;
		}

		public StatusEffectInstance[] getUseEffects() {
			return this.effects;
		}

		public Config setUseEffects(StatusEffectInstance[] value) {
			this.effects = value;
			return this;
		}
	}
}
