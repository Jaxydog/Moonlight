package dev.jaxydog.moonlight;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class MoonlightSoundEvents {
	public static final SoundEvent ITEM_AVOCADO_JINGLE = new SoundEvent(Moonlight.id("item.avocado.jingle"));
	public static final SoundEvent ORIGIN_SNAKE_ALERT = new SoundEvent(Moonlight.id("origin.snake.alert"));
	public static final SoundEvent ORIGIN_SNAKE_SNEAK = new SoundEvent(Moonlight.id("origin.snake.sneak"));

	private static void register(SoundEvent... sounds) {
		for (var sound : sounds) {
			Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
		}
	}

	public static void register() {
		register(ITEM_AVOCADO_JINGLE);
		register(ORIGIN_SNAKE_ALERT);
		register(ORIGIN_SNAKE_SNEAK);
	}
}