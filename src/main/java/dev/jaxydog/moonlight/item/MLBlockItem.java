package dev.jaxydog.moonlight.item;

import java.util.List;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MLItem.Config;
import dev.jaxydog.moonlight.utility.Registerable;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MLBlockItem extends BlockItem implements Registerable {

	protected final Config _CONFIG;

	public MLBlockItem(Block block, Settings settings, Config config) {
		super(block, settings.group(Config.DEFAULT_GROUP));
		_CONFIG = config;
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_CONFIG.getName());
	}

	@Override
	public MLBlockItem register() {
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

}
