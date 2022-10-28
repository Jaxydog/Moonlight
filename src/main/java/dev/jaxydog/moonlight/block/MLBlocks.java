package dev.jaxydog.moonlight.block;

import dev.jaxydog.moonlight.block.MLBlock.Config;
import dev.jaxydog.moonlight.block.unique.MLDyeableAmethystBlock;
import dev.jaxydog.moonlight.block.unique.MLDyeableAmethystClusterBlock;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.sound.BlockSoundGroup;

public class MLBlocks {

	public static final MLDyeableAmethystBlock AMETHYST_BLOCK = new MLDyeableAmethystBlock(
			Settings.of(Material.AMETHYST).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(1.5f),
			new Config("amethyst_block"));

	public static final MLDyeableAmethystClusterBlock AMETHYST_CLUSTER = new MLDyeableAmethystClusterBlock(
			Settings.of(Material.AMETHYST).luminance(state -> 5).nonOpaque().sounds(BlockSoundGroup.AMETHYST_CLUSTER)
					.strength(1.5f).ticksRandomly(),
			new Config("amethyst_cluster"));

	public static final MLBlock CHEESE_BLOCK = new MLBlock(
			Settings.of(Material.SPONGE).hardness(1.0f).sounds(BlockSoundGroup.SLIME),
			new Config("cheese_block"));

	public static void register() {
		AMETHYST_BLOCK.register();
		AMETHYST_CLUSTER.register();
		CHEESE_BLOCK.register();
	}

}
