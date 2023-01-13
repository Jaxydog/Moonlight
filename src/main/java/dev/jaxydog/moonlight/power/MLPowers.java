package dev.jaxydog.moonlight.power;

import dev.jaxydog.moonlight.Moonlight;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.util.registry.Registry;

/** Moonlight power class */
public class MLPowers {

	/** Model scale power */
	public static final PowerFactory<Power> MODEL_SCALE = new PowerFactory<>(
		Moonlight.id("model_scale"),
		new SerializableData()
			.add("width", SerializableDataTypes.FLOAT, 1.0f)
			.add("height", SerializableDataTypes.FLOAT, 1.0f),
		data -> (type, entity) -> new ModelScale(type, entity, data.getFloat("width"), data.getFloat("height"))
	)
		.allowCondition();

	public static final PowerFactory<Power> ELYTRA_SPEED = new PowerFactory<>(
		Moonlight.id("elytra_speed"),
		new SerializableData().add("speed", SerializableDataTypes.FLOAT, 1.0f),
		data -> (type, entity) -> new ElytraSpeed(type, entity, data.getFloat("speed"))
	)
		.allowCondition();

	/** Registers a new power factory */
	private static void register(PowerFactory<?> power) {
		Registry.register(ApoliRegistries.POWER_FACTORY, power.getSerializerId(), power);
	}

	/** Registers all power factories */
	public static void register() {
		register(ELYTRA_SPEED);
		register(MODEL_SCALE);
	}
}
