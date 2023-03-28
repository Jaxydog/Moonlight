package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.data.AxolotlEmotion;
import dev.jaxydog.moonlight.item.MLItem;
import java.util.List;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class CrystalItem extends MLItem implements Emotional {

	public CrystalItem(Settings settings, Config config) {
		super(settings, config);
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);

		tooltip.add(Text.empty());
		tooltip.add(this.getEmotionTooltip(stack));
	}

	@Override
	public ItemStack getDefaultStack() {
		var stack = super.getDefaultStack();

		Emotional.setEmotion(stack, AxolotlEmotion.NEUTRAL);

		return stack;
	}

	@Override
	public Text getName(ItemStack stack) {
		var emotion = Text.translatable(Emotional.getEmotion(stack).getTranslationKey());

		return Text.translatable(this.getTranslationKey()).append(" ").append(emotion);
	}

	@Override
	public MLItem register() {
		ColorProviderRegistry.ITEM.register(this::getColor, this);
		return super.register();
	}
}
