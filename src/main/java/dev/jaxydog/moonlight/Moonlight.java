package dev.jaxydog.moonlight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Moonlight implements ModInitializer {
	public static final String MOD_ID = "moonlight";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier Id(String name) {
		return new Identifier(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Loading mod... Thanks for playing!");
	}
}
