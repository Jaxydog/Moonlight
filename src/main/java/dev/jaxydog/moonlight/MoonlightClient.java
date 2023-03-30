package dev.jaxydog.moonlight;

import dev.jaxydog.moonlight.block.MLBlocks;
import dev.jaxydog.moonlight.item.MLItems;
import dev.jaxydog.moonlight.item.unique.CrownItem;
import dev.jaxydog.moonlight.item.unique.CrystalItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;

public class MoonlightClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		for (var block : MLBlocks.AMETHYST_CLUSTER.getBlocks()) {
			BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
		}
		ColorProviderRegistry.ITEM.register((s, i) -> ((CrownItem) s.getItem()).getColor(s, i), MLItems.CROWN);
		ColorProviderRegistry.ITEM.register((s, i) -> ((CrystalItem) s.getItem()).getColor(s, i), MLItems.CRYSTAL);
	}
}
