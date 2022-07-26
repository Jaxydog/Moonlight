package dev.jaxydog.moonlight.data;

import java.util.function.BiFunction;

import net.minecraft.item.ItemStack;

/** Value type for comparing values */
public enum ValueType {
	/** Invalid type */
	NONE("", (v, i) -> v.intValue()),
	/** Exact value */
	NUMBER("number", (v, i) -> v.intValue()),
	/** Percent of max damage */
	PERCENT("percent", (v, i) -> (int) (i.getMaxDamage() * v));

	private final String TYPE;
	private final BiFunction<Float, ItemStack, Integer> CONVERT;

	private ValueType(String type, BiFunction<Float, ItemStack, Integer> convert) {
		TYPE = type;
		CONVERT = convert;
	}

	/** Resolves a value type from a string */
	public static ValueType from(String type) {
		switch (type) {
			case "number":
				return NUMBER;
			case "percent":
				return PERCENT;
			default:
				return NONE;
		}
	}

	/** Returns a string representation of the variant */
	public String getType() {
		return TYPE;
	}

	/** Converts a value to the proper format */
	public int convert(float value, ItemStack stack) {
		return CONVERT.apply(value, stack);
	}
}
