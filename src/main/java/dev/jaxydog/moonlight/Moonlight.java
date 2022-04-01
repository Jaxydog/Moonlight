package dev.jaxydog.moonlight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.jaxydog.moonlight.item.MoonlightArmorItems;
import dev.jaxydog.moonlight.item.MoonlightItems;
import dev.jaxydog.moonlight.power.MoonlightConditions;
import dev.jaxydog.moonlight.power.MoonlightPowers;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Moonlight implements ModInitializer {
	public static final String MOD_ID = "moonlight";
	public static final Logger LOGGER = LoggerFactory.getLogger("Moonlight");

	public static Identifier Id(String name) {
		return new Identifier(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		MoonlightSoundEvents.register();
		MoonlightItems.register();
		MoonlightArmorItems.register();
		MoonlightConditions.register();
		MoonlightPowers.register();
		LOGGER.info("Loaded mod! Thanks for playing :)");
	}
}
