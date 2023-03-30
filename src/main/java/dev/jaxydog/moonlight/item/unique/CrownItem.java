package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.data.AxolotlEmotion;
import dev.jaxydog.moonlight.item.MLArmorItem;
import dev.jaxydog.moonlight.item.MLItem.Config;
import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class CrownItem extends MLArmorItem implements Emotional {

	public CrownItem(Material material, EquipmentSlot slot, Settings settings, Config config) {
		super(material, slot, settings, config);
	}

	public int getLayers() {
		return 5;
	}

	@Override
	public int getColor(ItemStack stack, int index) {
		if (index == 0) return 0xFFFFFF;

		if (Emotional.getEmotion(stack) != AxolotlEmotion.NEUTRAL) {
			return Emotional.super.getColor(stack, index);
		}

		switch (index) {
			case 1:
				return ANGRY_COLOR;
			case 2:
				return HAPPY_COLOR;
			case 3:
				return SAD_COLOR;
			default:
				return NEUTRAL_COLOR;
		}
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
}
