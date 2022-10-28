package dev.jaxydog.moonlight.block;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.utility.Registerable;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MLBlock extends Block implements Registerable {

	protected final Config _CONFIG;

	public MLBlock(Settings settings, Config config) {
		super(settings);
		_CONFIG = config;
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_CONFIG.getName());
	}

	@Override
	public MLBlock register() {
		return Registry.register(Registry.BLOCK, getId(), this);
	}

	public static class Config {

		private final String __name;

		public Config(String name) {
			__name = name;
		}

		public String getName() {
			return __name;
		}

		public Config clone() {
			return clone(getName());
		}

		public Config clone(String name) {
			var c = new Config(name);

			return c;
		}

	}

}
