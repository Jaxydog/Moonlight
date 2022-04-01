package dev.jaxydog.moonlight.item;

import java.util.List;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MoonlightMusicDiscItem extends MusicDiscItem {
	private final Config CONFIG;

	public MoonlightMusicDiscItem(Config config, int output, SoundEvent sound, Settings settings) {
		super(output, sound, settings.group(Config.DEFAULT_GROUP));
		this.CONFIG = config;
	}

	public Identifier Id() {
		return Moonlight.Id(CONFIG.getName());
	}

	public MoonlightMusicDiscItem register() {
		return Registry.register(Registry.ITEM, this.Id(), this);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return CONFIG.getGlintForced() || (CONFIG.getGlintEnabled() && super.hasGlint(stack));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if (CONFIG.getTooltipEnabled()) {
			var text = new TranslatableText("item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip");
			tooltip.add(text.formatted(Formatting.GRAY));
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

		return super.finishUsing(stack, world, user);
	}
}
