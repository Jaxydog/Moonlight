package dev.jaxydog.moonlight.power;

import dev.jaxydog.moonlight.Moonlight;
import io.github.apace100.apoli.power.factory.action.ActionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

public class MoonlightActions {
	public static final ActionFactory<Pair<Entity, Entity>> STEAL_ITEM = new ActionFactory<>(
			Moonlight.Id("steal_item"),
			new SerializableData()
					.add("equipment_slot", SerializableDataTypes.EQUIPMENT_SLOT),
			(data, entities) -> {
				if (!((entities.getRight() instanceof LivingEntity) && (entities.getLeft() instanceof LivingEntity))) {
					return;
				}

				EquipmentSlot slot = data.get("equipment_slot");
				LivingEntity target = (LivingEntity) entities.getRight();
				ItemStack stack = target.getEquippedStack(slot).copy();
				ItemEntity ground = target.dropStack(stack);

				target.getEquippedStack(slot).setCount(0);

				if (ground != null) {
					LivingEntity actor = (LivingEntity) entities.getLeft();
					ground.teleport(actor.getX(), actor.getY(), actor.getZ());
				}
			});

	private static <T> void register(Registry<ActionFactory<T>> registry, ActionFactory<T> action) {
		Registry.register(registry, action.getSerializerId(), action);
	}

	public static void register() {
		register(ApoliRegistries.BIENTITY_ACTION, STEAL_ITEM);
		Moonlight.LOGGER.info("Registered actions");
	}
}
