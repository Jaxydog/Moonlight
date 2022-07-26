package dev.jaxydog.moonlight.data;

import java.util.function.Function;

import net.minecraft.world.World;

public enum MoonPhaseType {
	/** Invalid phase */
	NONE("", (w) -> false),
	/** Full moon */
	FULL("full", (w) -> w.getMoonPhase() == 0),
	/** Waning gibbus */
	WANING_GIBBUS("waning_gibbus", (w) -> w.getMoonPhase() == 1),
	/** Third quarter */
	THIRD_QUARTER("third_quarter", (w) -> w.getMoonPhase() == 2),
	/** Waning crescent */
	WANING_CRESCENT("waning_crescent", (w) -> w.getMoonPhase() == 3),
	/** New moon */
	NEW("new", (w) -> w.getMoonPhase() == 4),
	/** Waxing crescent */
	WAXING_CRESCENT("waxing_crescent", (w) -> w.getMoonPhase() == 5),
	/** First quarter */
	FIRST_QUARTER("first_quarted", (w) -> w.getMoonPhase() == 6),
	/** Waxing gibbus */
	WAXING_GIBBUS("waxing_gibbus", (w) -> w.getMoonPhase() == 7);

	private final String TYPE;
	private final Function<World, Boolean> TEST;

	private MoonPhaseType(String type, Function<World, Boolean> test) {
		this.TYPE = type;
		this.TEST = test;
	}

	/** Resolves a moon phase from a string */
	public static MoonPhaseType from(String type) {
		switch (type) {
			case "full":
				return FULL;
			case "waning_gibbus":
				return WANING_GIBBUS;
			case "third_quarter":
				return THIRD_QUARTER;
			case "waning_crescent":
				return WANING_CRESCENT;
			case "new":
				return NEW;
			case "waxing_crescent":
				return WAXING_CRESCENT;
			case "first_quarter":
				return FIRST_QUARTER;
			case "waxing_gibbus":
				return WAXING_GIBBUS;
		}
		return NONE;
	}

	/** Returns a string representation of the variant */
	public String getType() {
		return this.TYPE;
	}

	/** Tests whether the current moon phase is the variant's type */
	public boolean test(World world) {
		return this.TEST.apply(world);
	}
}
