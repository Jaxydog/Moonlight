package dev.jaxydog.moonlight.item;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.block.MLDyeableBlock;
import dev.jaxydog.moonlight.item.MLItem.Config;
import dev.jaxydog.moonlight.utility.Registerable;
import net.minecraft.block.Block;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;

public abstract class MLDyeableBlockItem<B extends Block & Registerable, I extends Registerable>
		implements Registerable {

	protected final MLDyeableBlock<B> _BLOCKS;
	protected final Settings _SETTINGS;
	protected final Config _CONFIG;
	protected final I[] _ITEMS;

	// horse

	public MLDyeableBlockItem(MLDyeableBlock<B> blocks, Settings settings, Config config) {
		_BLOCKS = blocks;
		_SETTINGS = settings;
		_CONFIG = config;
		_ITEMS = _generateItems();
	}

	protected abstract I[] _generateItems();

	public I[] getItems() {
		return _ITEMS;
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_CONFIG.getName());
	}

	@Override
	public Registerable register() {
		for (var item : _ITEMS) {
			item.register();
		}

		return this;
	}

}
