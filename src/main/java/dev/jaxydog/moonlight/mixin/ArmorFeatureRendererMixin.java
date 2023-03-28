package dev.jaxydog.moonlight.mixin;

import dev.jaxydog.moonlight.item.unique.CrownItem;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorFeatureRenderer.class)
public class ArmorFeatureRendererMixin {

	@SuppressWarnings("unchecked")
	@Inject(method = "renderArmor", at = @At("HEAD"), cancellable = true)
	private <T extends LivingEntity, A extends BipedEntityModel<T>> void renderArmorInject(
		MatrixStack matrices,
		VertexConsumerProvider vertex,
		T entity,
		EquipmentSlot slot,
		int light,
		A model,
		CallbackInfo info
	) {
		var stack = ((LivingEntity) entity).getEquippedStack(slot);
		var item = stack.getItem();

		if (!(item instanceof CrownItem)) return;

		var armor = (CrownItem) item;

		if (armor.getSlotType() != slot) return;

		var self = (ArmorFeatureRenderer<T, ?, A>) (Object) this;
		var invoker = (ArmorFeatureRendererInvoker) self;

		((BipedEntityModel<T>) self.getContextModel()).setAttributes(model);
		invoker.setVisibleInvoker(model, slot);

		var layers = armor.getLayers();
		var glint = stack.hasGlint();
		var inner = invoker.usesInnerModelInvoker(slot);

		for (var index = 0; index < layers; index++) {
			var color = armor.getColor(stack, index);
			var r = (float) (color >> 16 & 0xFF) / 255.0f;
			var g = (float) (color >> 8 & 0xFF) / 255.0f;
			var b = (float) (color & 0xFF) / 255.0f;
			var i = "" + index;

			invoker.renderArmorPartsInvoker(matrices, vertex, light, armor, glint, model, inner, r, g, b, i);
		}

		info.cancel();
	}
}
