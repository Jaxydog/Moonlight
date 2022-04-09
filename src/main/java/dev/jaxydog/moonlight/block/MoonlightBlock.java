package dev.jaxydog.moonlight.block;

import dev.jaxydog.moonlight.Moonlight;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoonlightBlock extends Block {
	private final Config CONFIG;

	public MoonlightBlock(Config config, Settings settings) {
		super(settings);
		this.CONFIG = config;
	}

	public Identifier Id() {
		return Moonlight.Id(CONFIG.getName());
	}

	public MoonlightBlock register() {
		return Registry.register(Registry.BLOCK, this.Id(), this);
	}

	public static class Config {
		private String name;

		public Config setName(String value) {
			this.name = value;
			return this;
		}

		public String getName() {
			return this.name;
		}
	}
}
