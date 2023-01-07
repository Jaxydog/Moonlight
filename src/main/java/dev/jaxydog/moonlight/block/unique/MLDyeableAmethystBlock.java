package dev.jaxydog.moonlight.block.unique;

import dev.jaxydog.moonlight.block.MLBlock.Config;
import dev.jaxydog.moonlight.block.MLDyeableBlock;
import net.minecraft.block.AbstractBlock.Settings;

public class MLDyeableAmethystBlock extends MLDyeableBlock<MLAmethystBlock> {

	public MLDyeableAmethystBlock(Settings settings, Config config) {
		super(settings, config);
	}

	@Override
	protected MLAmethystBlock[] _generateBlocks() {
		var blocks = new MLAmethystBlock[MLDyeableBlock.COLORS.length];

		for (var i = 0; i < MLDyeableBlock.COLORS.length; i += 1) {
			var color = MLDyeableBlock.COLORS[i];
			var block = new MLAmethystBlock(_SETTINGS, _CONFIG.clone(_CONFIG.getName() + "_" + color));

			blocks[i] = block;
		}

		return blocks;
	}
}
