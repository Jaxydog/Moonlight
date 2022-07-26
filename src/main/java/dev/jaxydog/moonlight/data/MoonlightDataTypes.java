package dev.jaxydog.moonlight.data;

import io.github.apace100.calio.SerializationHelper;
import io.github.apace100.calio.data.SerializableDataType;

public class MoonlightDataTypes {
	/** Value type data type */
	public static final SerializableDataType<ValueType> VALUE_TYPE = SerializableDataType.enumValue(
			ValueType.class,
			SerializationHelper.buildEnumMap(ValueType.class, ValueType::getType));

	/** Moon phase data type */
	public static final SerializableDataType<MoonPhaseType> MOON_PHASE = SerializableDataType.enumValue(
			MoonPhaseType.class,
			SerializationHelper.buildEnumMap(MoonPhaseType.class, MoonPhaseType::getType));
}
