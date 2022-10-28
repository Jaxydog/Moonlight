package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.block.MLDyeableBlock;
import dev.jaxydog.moonlight.block.unique.MLAmethystClusterBlock;
import dev.jaxydog.moonlight.item.MLBlockItem;
import dev.jaxydog.moonlight.item.MLDyeableBlockItem;
import dev.jaxydog.moonlight.item.MLItem.Config;
import net.minecraft.item.Item.Settings;

public class MLDyeableAmethystClusterBlockItem extends MLDyeableBlockItem<MLAmethystClusterBlock, MLBlockItem> {

	public MLDyeableAmethystClusterBlockItem(MLDyeableBlock<MLAmethystClusterBlock> blocks, Settings settings,
			Config config) {
		super(blocks, settings, config);
	}

	@Override
	protected MLBlockItem[] _generateItems() {
		var blocks = _BLOCKS.getBlocks();
		var items = new MLBlockItem[blocks.length];

		for (var i = 0; i < blocks.length; i += 1) {
			var block = blocks[i];
			var color = MLDyeableBlock.getColor(block);

			if (color != null) {
				var item = new MLBlockItem(block, _SETTINGS, _CONFIG.clone(_CONFIG.getName() + "_" + color));
				items[i] = item;
			} else {
				items[i] = null;
			}
		}

		return items;
	}

}
