package dev.jaxydog.moonlight.mixin;

import java.util.UUID;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import dev.jaxydog.moonlight.item.MLArmorItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item.Settings;

@Mixin(ArmorItem.class)
public class ArmorItemMixin {
	@Shadow
	@Final
	private static UUID[] MODIFIERS;
	@Shadow
	@Final
	@Mutable
	private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	@Shadow
	@Final
	private float knockbackResistance;

	@Inject(method = "<init>", at = @At(value = "RETURN"))
	private void constructor(ArmorMaterial material, EquipmentSlot slot, Settings settings, CallbackInfo info) {
		if (material instanceof MLArmorItem.Material) {
			var uuid = MODIFIERS[slot.getEntitySlotId()];
			ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

			this.attributeModifiers.forEach(builder::put);

			var modifier = new EntityAttributeModifier(
					uuid,
					"Armor knockback resistance",
					this.knockbackResistance,
					Operation.ADDITION);

			builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, modifier);
			this.attributeModifiers = builder.build();
		}
	}
}
