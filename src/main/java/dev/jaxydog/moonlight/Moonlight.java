package dev.jaxydog.moonlight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.jaxydog.moonlight.block.MoonlightBlocks;
import dev.jaxydog.moonlight.content.MoonlightSoundEvents;
import dev.jaxydog.moonlight.item.MoonlightItems;
import dev.jaxydog.moonlight.power.MoonlightConditions;
import dev.jaxydog.moonlight.power.MoonlightPowers;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

/** Main moonlight class */
public class Moonlight implements ModInitializer {
	/** Mod identifier */
	public static final String MOD_ID = "moonlight";
	/** Mod logger */
	public static final Logger LOGGER = LoggerFactory.getLogger("Moonlight");

	/** Returns an id using the given name and the moonlight mod identifier */
	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		MoonlightSoundEvents.register();
		MoonlightBlocks.register();
		MoonlightItems.register();
		MoonlightConditions.register();
		MoonlightPowers.register();

		LOGGER.info("Loaded Moonlight! Thanks for playing :)");
	}
}
