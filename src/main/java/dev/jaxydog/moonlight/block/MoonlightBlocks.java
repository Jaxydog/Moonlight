package dev.jaxydog.moonlight.block;

import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.sound.BlockSoundGroup;

/** Moonlight blocks class */
public class MoonlightBlocks {
	public static final MoonlightAmethystBlock AMETHYST_BLOCK_BLACK = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_black"),
			Settings.of(Material.AMETHYST, MapColor.BLACK).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_BLUE = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_blue"),
			Settings.of(Material.AMETHYST, MapColor.BLUE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_BROWN = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_brown"),
			Settings.of(Material.AMETHYST, MapColor.BROWN).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_CYAN = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_cyan"),
			Settings.of(Material.AMETHYST, MapColor.CYAN).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_GRAY = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_gray"),
			Settings.of(Material.AMETHYST, MapColor.GRAY).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_GREEN = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_green"),
			Settings.of(Material.AMETHYST, MapColor.GREEN).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_LIGHT_BLUE = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_light_blue"),
			Settings.of(Material.AMETHYST, MapColor.LIGHT_BLUE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_LIGHT_GRAY = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_light_gray"),
			Settings.of(Material.AMETHYST, MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_LIME = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_lime"),
			Settings.of(Material.AMETHYST, MapColor.LIME).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_MAGENTA = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_magenta"),
			Settings.of(Material.AMETHYST, MapColor.MAGENTA).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_ORANGE = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_orange"),
			Settings.of(Material.AMETHYST, MapColor.ORANGE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_PINK = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_pink"),
			Settings.of(Material.AMETHYST, MapColor.PINK).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_PURPLE = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_purple"),
			Settings.of(Material.AMETHYST, MapColor.PURPLE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_RED = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_red"),
			Settings.of(Material.AMETHYST, MapColor.RED).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_WHITE = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_white"),
			Settings.of(Material.AMETHYST, MapColor.WHITE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystBlock AMETHYST_BLOCK_YELLOW = new MoonlightAmethystBlock(
			new MoonlightBlock.Config().setName("amethyst_block_yellow"),
			Settings.of(Material.AMETHYST, MapColor.YELLOW).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.strength(1.5f).requiresTool());

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_BLACK = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_black"),
			Settings.of(Material.AMETHYST, MapColor.BLACK).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_BLUE = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_blue"),
			Settings.of(Material.AMETHYST, MapColor.BLUE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_BROWN = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_brown"),
			Settings.of(Material.AMETHYST, MapColor.BROWN).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_CYAN = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_cyan"),
			Settings.of(Material.AMETHYST, MapColor.CYAN).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_GRAY = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_gray"),
			Settings.of(Material.AMETHYST, MapColor.GRAY).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_GREEN = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_green"),
			Settings.of(Material.AMETHYST, MapColor.GREEN).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_LIGHT_BLUE = new MoonlightAmethystClusterBlock(7,
			3,
			new MoonlightBlock.Config().setName("amethyst_cluster_light_blue"),
			Settings.of(Material.AMETHYST, MapColor.LIGHT_BLUE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_LIGHT_GRAY = new MoonlightAmethystClusterBlock(7,
			3,
			new MoonlightBlock.Config().setName("amethyst_cluster_light_gray"),
			Settings.of(Material.AMETHYST, MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_LIME = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_lime"),
			Settings.of(Material.AMETHYST, MapColor.LIME).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_MAGENTA = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_magenta"),
			Settings.of(Material.AMETHYST, MapColor.MAGENTA).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_ORANGE = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_orange"),
			Settings.of(Material.AMETHYST, MapColor.ORANGE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_PINK = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_pink"),
			Settings.of(Material.AMETHYST, MapColor.PINK).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_PURPLE = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_purple"),
			Settings.of(Material.AMETHYST, MapColor.PURPLE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_RED = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_red"),
			Settings.of(Material.AMETHYST, MapColor.RED).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_WHITE = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_white"),
			Settings.of(Material.AMETHYST, MapColor.WHITE).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	public static final MoonlightAmethystClusterBlock AMETHYST_CLUSTER_YELLOW = new MoonlightAmethystClusterBlock(7, 3,
			new MoonlightBlock.Config().setName("amethyst_cluster_yellow"),
			Settings.of(Material.AMETHYST, MapColor.YELLOW).sounds(BlockSoundGroup.AMETHYST_BLOCK)
					.nonOpaque().ticksRandomly().strength(1.5f).luminance(state -> 5));

	/** Cheese block item */
	public static final MoonlightBlock CHEESE_BLOCK = new MoonlightBlock(
			new MoonlightBlock.Config()
					.setName("cheese_block"),
			Settings.of(Material.SPONGE, MapColor.YELLOW)
					.sounds(BlockSoundGroup.SLIME)
					.hardness(1));

	/** Registers all blocks */
	public static void register() {
		AMETHYST_BLOCK_BLACK.register();
		AMETHYST_BLOCK_BLUE.register();
		AMETHYST_BLOCK_BROWN.register();
		AMETHYST_BLOCK_CYAN.register();
		AMETHYST_BLOCK_GRAY.register();
		AMETHYST_BLOCK_GREEN.register();
		AMETHYST_BLOCK_LIGHT_BLUE.register();
		AMETHYST_BLOCK_LIGHT_GRAY.register();
		AMETHYST_BLOCK_LIME.register();
		AMETHYST_BLOCK_MAGENTA.register();
		AMETHYST_BLOCK_ORANGE.register();
		AMETHYST_BLOCK_PINK.register();
		AMETHYST_BLOCK_PURPLE.register();
		AMETHYST_BLOCK_RED.register();
		AMETHYST_BLOCK_WHITE.register();
		AMETHYST_BLOCK_YELLOW.register();
		AMETHYST_CLUSTER_BLACK.register();
		AMETHYST_CLUSTER_BLUE.register();
		AMETHYST_CLUSTER_BROWN.register();
		AMETHYST_CLUSTER_CYAN.register();
		AMETHYST_CLUSTER_GRAY.register();
		AMETHYST_CLUSTER_GREEN.register();
		AMETHYST_CLUSTER_LIGHT_BLUE.register();
		AMETHYST_CLUSTER_LIGHT_GRAY.register();
		AMETHYST_CLUSTER_LIME.register();
		AMETHYST_CLUSTER_MAGENTA.register();
		AMETHYST_CLUSTER_ORANGE.register();
		AMETHYST_CLUSTER_PINK.register();
		AMETHYST_CLUSTER_PURPLE.register();
		AMETHYST_CLUSTER_RED.register();
		AMETHYST_CLUSTER_WHITE.register();
		AMETHYST_CLUSTER_YELLOW.register();
		CHEESE_BLOCK.register();
	}
}
