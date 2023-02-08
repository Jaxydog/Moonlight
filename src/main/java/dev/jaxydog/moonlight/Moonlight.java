package dev.jaxydog.moonlight;

import dev.jaxydog.moonlight.block.MLBlocks;
import dev.jaxydog.moonlight.content.MLSoundEvents;
import dev.jaxydog.moonlight.effect.MLStatusEffects;
import dev.jaxydog.moonlight.item.MLItems;
import dev.jaxydog.moonlight.power.MLConditions;
import dev.jaxydog.moonlight.power.MLPowers;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		MLSoundEvents.register();
		MLStatusEffects.register();
		MLBlocks.register();
		MLItems.register();
		MLConditions.register();
		MLPowers.register();

		LOGGER.info("Loaded Moonlight! Thanks for playing :)");
	}
}
