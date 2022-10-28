package dev.jaxydog.moonlight.block;

import blue.endless.jankson.annotation.Nullable;
import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.block.MLBlock.Config;
import dev.jaxydog.moonlight.utility.Registerable;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.util.Identifier;

public abstract class MLDyeableBlock<B extends Registerable> implements Registerable {

	public static final String[] COLORS = new String[] { "white", "light_gray", "gray", "black", "brown",
			"red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink" };

	protected final Settings _SETTINGS;
	protected final Config _CONFIG;
	protected final B[] _BLOCKS;

	public MLDyeableBlock(Settings settings, Config config) {
		_SETTINGS = settings;
		_CONFIG = config;
		_BLOCKS = _generateBlocks();
	}

	@Nullable
	public static <B extends Registerable> String getColor(B block) {
		var path = block.getId().getPath();

		for (var color : COLORS) {
			if (path.endsWith(color)) {
				return color;
			}
		}

		return null;
	}

	protected abstract B[] _generateBlocks();

	public B[] getBlocks() {
		return _BLOCKS;
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_CONFIG.getName());
	}

	@Override
	public MLDyeableBlock<B> register() {
		for (var block : _BLOCKS) {
			block.register();
		}

		return this;
	}

}
