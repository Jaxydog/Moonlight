package dev.jaxydog.moonlight.block;

import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.sound.BlockSoundGroup;

/** Moonlight blocks class */
public class MoonlightBlocks {
	/** Cheese block item */
	public static final MoonlightBlock CHEESE_BLOCK = new MoonlightBlock(
			new MoonlightBlock.Config()
					.setName("cheese_block"),
			Settings.of(Material.SPONGE, MapColor.YELLOW)
					.sounds(BlockSoundGroup.SLIME)
					.hardness(1));

	/** Registers all blocks */
	public static void register() {
		CHEESE_BLOCK.register();
	}
}
