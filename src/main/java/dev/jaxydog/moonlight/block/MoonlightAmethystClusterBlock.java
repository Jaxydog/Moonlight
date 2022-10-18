package dev.jaxydog.moonlight.block;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.block.MoonlightBlock.Config;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoonlightAmethystClusterBlock extends AmethystClusterBlock {
	private final Config CONFIG;

	public MoonlightAmethystClusterBlock(int height, int xzOffset, Config config, Settings settings) {
		super(height, xzOffset, settings);
		CONFIG = config;
	}

	public Identifier id() {
		return Moonlight.id(CONFIG.getName());
	}

	public MoonlightAmethystClusterBlock register() {
		return Registry.register(Registry.BLOCK, this.id(), this);
	}
}
