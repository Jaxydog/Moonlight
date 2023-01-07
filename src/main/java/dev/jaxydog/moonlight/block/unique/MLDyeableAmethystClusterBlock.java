package dev.jaxydog.moonlight.block.unique;

import dev.jaxydog.moonlight.block.MLBlock.Config;
import dev.jaxydog.moonlight.block.MLDyeableBlock;
import net.minecraft.block.AbstractBlock.Settings;

public class MLDyeableAmethystClusterBlock extends MLDyeableBlock<MLAmethystClusterBlock> {

	public MLDyeableAmethystClusterBlock(Settings settings, Config config) {
		super(settings, config);
	}

	@Override
	protected MLAmethystClusterBlock[] _generateBlocks() {
		var blocks = new MLAmethystClusterBlock[MLDyeableBlock.COLORS.length];

		for (var i = 0; i < MLDyeableBlock.COLORS.length; i += 1) {
			var color = MLDyeableBlock.COLORS[i];
			var block = new MLAmethystClusterBlock(_SETTINGS, _CONFIG.clone(_CONFIG.getName() + "_" + color));

			blocks[i] = block;
		}

		return blocks;
	}
}
