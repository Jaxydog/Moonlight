package dev.jaxydog.moonlight.block;

import dev.jaxydog.moonlight.Moonlight;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.sound.BlockSoundGroup;

public class MoonlightBlocks {
	public static final MoonlightBlock CHEESE_BLOCK = new MoonlightBlock(
			new MoonlightBlock.Config()
					.setName("cheese_block"),
			Settings.of(Material.SPONGE, MapColor.YELLOW)
					.sounds(BlockSoundGroup.SLIME)
					.hardness(1));

	public static void register() {
		CHEESE_BLOCK.register();
		Moonlight.LOGGER.info("Registered blocks");
	}
}
