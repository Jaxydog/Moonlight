package dev.jaxydog.moonlight.data;

import java.util.function.BiFunction;

import net.minecraft.item.ItemStack;

public enum ComparisonType {
	NONE("", (v, i) -> 0),
	VALUE("value", (v, i) -> v.intValue()),
	PERCENTAGE("percentage", (v, i) -> (int) (i.getMaxDamage() * v));

	private final String TYPE;
	private final BiFunction<Double, ItemStack, Integer> CONVERSION;

	private ComparisonType(String type, BiFunction<Double, ItemStack, Integer> conversion) {
		this.TYPE = type;
		this.CONVERSION = conversion;
	}

	public static ComparisonType getFromString(String type) {
		switch (type) {
			case "value":
				return VALUE;
			case "percentage":
				return PERCENTAGE;
		}
		return NONE;
	}

	public String getType() {
		return this.TYPE;
	}

	public int convert(double value, ItemStack stack) {
		return this.CONVERSION.apply(value, stack);
	}
}
