package dev.jaxydog.moonlight.data;

import java.util.function.BiFunction;

import dev.jaxydog.moonlight.Moonlight;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public enum AxisType {
	NONE("", (v, r) -> false),
	X("x", (v, r) -> !r ? v.x > 0 : v.x < 0),
	Y("y", (v, r) -> !r ? v.y > 0 : v.y < 0),
	Z("z", (v, r) -> !r ? v.z > 0 : v.z < 0);

	private final String TYPE;
	private final BiFunction<Vec3d, Boolean, Boolean> TEST;

	private AxisType(String type, BiFunction<Vec3d, Boolean, Boolean> test) {
		this.TYPE = type;
		this.TEST = test;
	}

	public static AxisType getFromString(String type) {
		switch (type) {
			case "x":
				return X;
			case "y":
				return Y;
			case "z":
				return Z;
		}
		return NONE;
	}

	public String getType() {
		return this.TYPE;
	}

	public boolean test(Entity entity, boolean reverse) {
		Moonlight.LOGGER.info(entity.getMovementDirection().toString());
		return this.TEST.apply(entity.getVelocity(), reverse);
	}
}
