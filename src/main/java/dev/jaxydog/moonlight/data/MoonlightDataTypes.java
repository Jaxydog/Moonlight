package dev.jaxydog.moonlight.data;

import io.github.apace100.calio.SerializationHelper;
import io.github.apace100.calio.data.SerializableDataType;

public class MoonlightDataTypes {
	public static final SerializableDataType<ComparisonType> COMPARISON_VALUE_TYPE = SerializableDataType.enumValue(
			ComparisonType.class,
			SerializationHelper.buildEnumMap(ComparisonType.class, ComparisonType::getType));
	public static final SerializableDataType<AxisType> AXIS_TYPE = SerializableDataType.enumValue(
			AxisType.class,
			SerializationHelper.buildEnumMap(AxisType.class, AxisType::getType));
}
