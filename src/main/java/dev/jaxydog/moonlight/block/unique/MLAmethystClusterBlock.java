package dev.jaxydog.moonlight.block.unique;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.block.MLBlock.Config;
import dev.jaxydog.moonlight.utility.Registerable;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MLAmethystClusterBlock extends AmethystClusterBlock implements Registerable {

	protected final Config _CONFIG;

	public MLAmethystClusterBlock(Settings settings, Config config) {
		super(7, 3, settings);
		_CONFIG = config;
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_CONFIG.getName());
	}

	@Override
	public MLAmethystClusterBlock register() {
		return Registry.register(Registry.BLOCK, getId(), this);
	}
}
