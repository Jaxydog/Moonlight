package dev.jaxydog.moonlight;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class MoonlightSoundEvents {
	public static final SoundEvent ITEM_AVOCADO_JINGLE = new SoundEvent(Moonlight.Id("item.avocado.jingle"));

	private static void register(SoundEvent... sounds) {
		for (var sound : sounds) {
			Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
		}
	}

	public static void register() {
		register(ITEM_AVOCADO_JINGLE);
		Moonlight.LOGGER.info("Registered sound events");
	}
}