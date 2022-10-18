package dev.jaxydog.moonlight;

import dev.jaxydog.moonlight.block.MoonlightBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MoonlightClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_BLACK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_BLUE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_BROWN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_CYAN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_GRAY, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_GREEN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_LIGHT_BLUE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_LIGHT_GRAY, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_LIME, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_MAGENTA, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_ORANGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_PINK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_PURPLE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_RED, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_WHITE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MoonlightBlocks.AMETHYST_CLUSTER_YELLOW, RenderLayer.getCutout());
	}
}
