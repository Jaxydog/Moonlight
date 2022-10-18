package dev.jaxydog.moonlight.block;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.block.MoonlightBlock.Config;
import net.minecraft.block.AmethystBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoonlightAmethystBlock extends AmethystBlock {
	private final Config CONFIG;

	public MoonlightAmethystBlock(Config config, Settings settings) {
		super(settings);
		this.CONFIG = config;
	}

	public Identifier id() {
		return Moonlight.id(CONFIG.getName());
	}

	public MoonlightAmethystBlock register() {
		return Registry.register(Registry.BLOCK, this.id(), this);
	}
}
