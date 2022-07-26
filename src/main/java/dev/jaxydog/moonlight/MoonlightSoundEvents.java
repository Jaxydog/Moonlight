package dev.jaxydog.moonlight;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

/** Moonlight sound event class */
public class MoonlightSoundEvents {
	/** Avocado jingle sound */
	public static final SoundEvent ITEM_AVOCADO_JINGLE = new SoundEvent(Moonlight.id("item.avocado.jingle"));
	/** Snake alert sound */
	public static final SoundEvent ORIGIN_SNAKE_ALERT = new SoundEvent(Moonlight.id("origin.snake.alert"));
	/** Snake sneak sound */
	public static final SoundEvent ORIGIN_SNAKE_SNEAK = new SoundEvent(Moonlight.id("origin.snake.sneak"));

	/** Registers a sound */
	private static void register(SoundEvent sound) {
		Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
	}

	public static void register() {
		register(ITEM_AVOCADO_JINGLE);
		register(ORIGIN_SNAKE_ALERT);
		register(ORIGIN_SNAKE_SNEAK);
	}
}