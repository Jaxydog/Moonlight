package dev.jaxydog.moonlight.power;

import dev.jaxydog.moonlight.Moonlight;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.util.registry.Registry;

public class MoonlightPowers {
	public static final PowerFactory<Power> MODEL_SCALE = new PowerFactory<>(
			Moonlight.Id("model_scale"),
			new SerializableData()
					.add("width", SerializableDataTypes.FLOAT)
					.add("height", SerializableDataTypes.FLOAT)
					.add("scale_reach", SerializableDataTypes.BOOLEAN, false),
			data -> (type, entity) -> new ModelScale(
					type,
					entity,
					data.getFloat("width"),
					data.getFloat("height"),
					data.getBoolean("scale_reach")))
			.allowCondition();

	private static void register(PowerFactory<?>... powers) {
		for (var power : powers) {
			Registry.register(ApoliRegistries.POWER_FACTORY, power.getSerializerId(), power);
		}
	}

	public static void register() {
		register(MODEL_SCALE);
		Moonlight.LOGGER.info("Registered powers");
	}
}
