package dev.jaxydog.moonlight.data;

import io.github.apace100.calio.SerializationHelper;
import io.github.apace100.calio.data.SerializableDataType;

public class MLDataTypes {
	/** Interface for function with 3 args */
	@FunctionalInterface
	public static interface TriFunction<A, B, C, R> {
		public R apply(A a, B b, C c);
	}

	/** Interface for function with 4 args */
	@FunctionalInterface
	public static interface TetraFunction<A, B, C, D, R> {
		public R apply(A a, B b, C c, D d);
	}

	/** Interface for function with 5 args */
	@FunctionalInterface
	public static interface PentaFunction<A, B, C, D, E, R> {
		public R apply(A a, B b, C c, D d, E e);
	}

	/** Interface for function with 6 args */
	@FunctionalInterface
	public static interface HexaFunction<A, B, C, D, E, F, R> {
		public R apply(A a, B b, C c, D d, E e, F f);
	}

	/** Value type data type */
	public static final SerializableDataType<ValueType> VALUE_TYPE = SerializableDataType.enumValue(ValueType.class,
			SerializationHelper.buildEnumMap(ValueType.class, ValueType::getType));

	/** Moon phase data type */
	public static final SerializableDataType<MoonPhase> MOON_PHASE = SerializableDataType.enumValue(MoonPhase.class,
			SerializationHelper.buildEnumMap(MoonPhase.class, MoonPhase::getType));
}
