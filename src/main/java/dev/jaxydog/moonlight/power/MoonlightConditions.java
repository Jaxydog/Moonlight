package dev.jaxydog.moonlight.power;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.data.AxisType;
import dev.jaxydog.moonlight.data.ComparisonType;
import dev.jaxydog.moonlight.data.MoonPhaseType;
import dev.jaxydog.moonlight.data.MoonlightDataTypes;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.apoli.util.Comparison;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

public class MoonlightConditions {
	public static final ConditionFactory<ItemStack> ITEM_DURABILITY = new ConditionFactory<>(
			Moonlight.Id("durability"),
			new SerializableData()
					.add("comparison", ApoliDataTypes.COMPARISON)
					.add("compare_to", SerializableDataTypes.DOUBLE)
					.add("compare_type", MoonlightDataTypes.COMPARISON_VALUE_TYPE, ComparisonType.PERCENTAGE),
			(data, entity) -> {
				Comparison comparison = data.get("comparison");
				double compare_to = data.get("compare_to");
				ComparisonType type = data.get("compare_type");
				return !entity.isEmpty() && comparison.compare(type.convert(compare_to, entity), entity.getDamage());
			});
	public static final ConditionFactory<Entity> VELOCITY = new ConditionFactory<>(
			Moonlight.Id("velocity"),
			new SerializableData()
					.add("axis", MoonlightDataTypes.AXIS_TYPE)
					.add("reverse", SerializableDataTypes.BOOLEAN, false),
			(data, entity) -> {
				AxisType axis = data.get("axis");
				boolean reverse = data.getBoolean("reverse");
				return axis.test(entity, reverse);
			});
	public static final ConditionFactory<Entity> MOON_PHASE = new ConditionFactory<>(
			Moonlight.Id("moon_phase"),
			new SerializableData()
					.add("phase", MoonlightDataTypes.MOON_PHASE),
			(data, entity) -> {
				MoonPhaseType phase = data.get("phase");
				return phase.test(entity.getWorld());
			});

	private static <T> void register(Registry<ConditionFactory<T>> registry, ConditionFactory<T> condition) {
		Registry.register(registry, condition.getSerializerId(), condition);
	}

	public static void register() {
		register(ApoliRegistries.ITEM_CONDITION, ITEM_DURABILITY);
		register(ApoliRegistries.ENTITY_CONDITION, VELOCITY);
		register(ApoliRegistries.ENTITY_CONDITION, MOON_PHASE);
		Moonlight.LOGGER.info("Registered conditions");
	}
}
