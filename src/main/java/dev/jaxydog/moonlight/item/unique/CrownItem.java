package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.data.AxolotlEmotion;
import dev.jaxydog.moonlight.item.MLArmorItem;
import dev.jaxydog.moonlight.item.MLItem.Config;
import java.util.List;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class CrownItem extends MLArmorItem {

	public static final String EMOTION_KEY = "Emotion";
	public static final String CONTAINS_KEY = Moonlight.id("crown_contains").toTranslationKey("tooltip");
	public static final int ANGRY_COLOR = 0xF04040;
	public static final int HAPPY_COLOR = 0xF0E040;
	public static final int SAD_COLOR = 0x3040F0;

	public CrownItem(Material material, EquipmentSlot slot, Settings settings, Config config) {
		super(material, slot, settings, config);
	}

	public static AxolotlEmotion getEmotion(ItemStack stack) {
		var compound = stack.getNbt();

		if (compound == null) return AxolotlEmotion.NEUTRAL;

		var emotion = compound.getString(EMOTION_KEY);

		return AxolotlEmotion.from(emotion);
	}

	public static void setEmotion(ItemStack stack, AxolotlEmotion emotion) {
		stack.getOrCreateNbt().putString(EMOTION_KEY, emotion.getName());
	}

	public int getLayers() {
		return 5;
	}

	public int getColor(ItemStack stack, int index) {
		if (index == 0) return 0xFFFFFF;

		switch (CrownItem.getEmotion(stack)) {
			case ANGRY:
				return ANGRY_COLOR;
			case HAPPY:
				return HAPPY_COLOR;
			case SAD:
				return SAD_COLOR;
			default:
				switch (index) {
					case 1:
						return ANGRY_COLOR;
					case 2:
						return HAPPY_COLOR;
					case 3:
						return SAD_COLOR;
					default:
						return 0x808080;
				}
		}
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);

		var emotion = CrownItem.getEmotion(stack);
		var text = Text.translatable(emotion.getTranslationKey());

		switch (emotion) {
			case ANGRY:
				text = text.formatted(Formatting.RED);
				break;
			case HAPPY:
				text = text.formatted(Formatting.YELLOW);
				break;
			case NEUTRAL:
				text = text.formatted(Formatting.GRAY);
				break;
			case SAD:
				text = text.formatted(Formatting.BLUE);
				break;
		}

		tooltip.add(Text.empty());
		tooltip.add(Text.translatable(CONTAINS_KEY).append(" ").append(text));
	}

	@Override
	public ItemStack getDefaultStack() {
		var stack = super.getDefaultStack();

		CrownItem.setEmotion(stack, AxolotlEmotion.NEUTRAL);

		return stack;
	}

	@Override
	public MLArmorItem register() {
		ColorProviderRegistry.ITEM.register(this::getColor, this);
		return super.register();
	}
}
