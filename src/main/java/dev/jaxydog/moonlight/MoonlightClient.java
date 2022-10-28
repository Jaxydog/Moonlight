package dev.jaxydog.moonlight;

import dev.jaxydog.moonlight.block.MLBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MoonlightClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		for (var block : MLBlocks.AMETHYST_CLUSTER.getBlocks()) {
			BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
		}
	}
}
