package dev.jaxydog.moonlight.mixin;

import blue.endless.jankson.annotation.Nullable;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ArmorFeatureRenderer.class)
public interface ArmorFeatureRendererInvoker {
	@Invoker("renderArmorParts")
	public void renderArmorPartsInvoker(
		MatrixStack stack,
		VertexConsumerProvider provider,
		int light,
		ArmorItem item,
		boolean glint,
		BipedEntityModel<?> model,
		boolean secondLayer,
		float r,
		float g,
		float b,
		@Nullable String overlay
	);

	@Invoker("setVisible")
	public void setVisibleInvoker(BipedEntityModel<?> model, EquipmentSlot slot);

	@Invoker("usesInnerModel")
	public boolean usesInnerModelInvoker(EquipmentSlot slot);
}
