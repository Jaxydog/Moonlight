package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.data.AxolotlEmotion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public interface Emotional {
	public static final String EMOTION_KEY = "Emotion";
	public static final String CONTAINS_KEY = Moonlight.id("crown_contains").toTranslationKey("tooltip");

	public static final int ANGRY_COLOR = 0xF04040;
	public static final int HAPPY_COLOR = 0xF0E040;
	public static final int SAD_COLOR = 0x3040F0;
	public static final int NEUTRAL_COLOR = 0x808080;

	public static AxolotlEmotion getEmotion(ItemStack stack) {
		var compound = stack.getNbt();

		if (compound == null) return AxolotlEmotion.NEUTRAL;

		var emotion = compound.getString(EMOTION_KEY);

		return AxolotlEmotion.from(emotion);
	}

	public static void setEmotion(ItemStack stack, AxolotlEmotion emotion) {
		stack.getOrCreateNbt().putString(EMOTION_KEY, emotion.getName());
	}

	public default int getColor(ItemStack stack, int index) {
		switch (Emotional.getEmotion(stack)) {
			case ANGRY:
				return ANGRY_COLOR;
			case HAPPY:
				return HAPPY_COLOR;
			case NEUTRAL:
				return NEUTRAL_COLOR;
			case SAD:
				return SAD_COLOR;
			default:
				return 0xFFFFFF;
		}
	}

	public default Text getEmotionTooltip(ItemStack stack) {
		var emotion = Emotional.getEmotion(stack);
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

		return Text.translatable(CONTAINS_KEY).append(" ").append(text);
	}
}
