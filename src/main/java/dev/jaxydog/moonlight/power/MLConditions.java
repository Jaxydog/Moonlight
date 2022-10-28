package dev.jaxydog.moonlight.power;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.data.ValueType;
import dev.jaxydog.moonlight.data.MoonPhase;
import dev.jaxydog.moonlight.data.MLDataTypes;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.apoli.util.Comparison;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

/** Moonlight condition class */
public class MLConditions {
	/** Durability condition factory */
	public static final ConditionFactory<ItemStack> DURABILITY = new ConditionFactory<>(Moonlight.id("durability"),
			new SerializableData()
					.add("value_type", MLDataTypes.VALUE_TYPE, ValueType.PERCENT)
					.add("comparison", ApoliDataTypes.COMPARISON)
					.add("compare_to", SerializableDataTypes.FLOAT),
			(data, entity) -> {
				ValueType valueType = data.get("value_type");
				Comparison comparison = data.get("comparison");
				var compareTo = data.getFloat("compare_to");
				var damage = entity.getDamage();
				var target = valueType.convert(compareTo, entity);

				return !entity.isEmpty() && entity.isDamageable() && comparison.compare(target, damage);
			});

	/** Moon phase condition factory */
	public static final ConditionFactory<Entity> MOON_PHASE = new ConditionFactory<>(Moonlight.id("moon_phase"),
			new SerializableData().add("phase", MLDataTypes.MOON_PHASE),
			(data, entity) -> ((MoonPhase) data.get("phase")).isCurrent(entity.getWorld()));

	/** Registers a new condition factory */
	private static <T> void register(ConditionFactory<T> factory, Registry<ConditionFactory<T>> registry) {
		Registry.register(registry, factory.getSerializerId(), factory);
	}

	/** Registers all condition factories */
	public static void register() {
		register(DURABILITY, ApoliRegistries.ITEM_CONDITION);
		register(MOON_PHASE, ApoliRegistries.ENTITY_CONDITION);
	}
}
