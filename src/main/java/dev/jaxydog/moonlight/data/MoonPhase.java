package dev.jaxydog.moonlight.data;

import net.minecraft.world.World;

public enum MoonPhase {
	/** Invalid phase */
	NONE("", -1),
	/** Full moon */
	FULL("full", 0),
	/** Waning gibbus */
	WANING_GIBBUS("waning_gibbus", 1),
	/** Third quarter */
	THIRD_QUARTER("third_quarter", 2),
	/** Waning crescent */
	WANING_CRESCENT("waning_crescent", 3),
	/** New moon */
	NEW("new", 4),
	/** Waxing crescent */
	WAXING_CRESCENT("waxing_crescent", 5),
	/** First quarter */
	FIRST_QUARTER("first_quarter", 6),
	/** Waxing gibbus */
	WAXING_GIBBUS("waxing_gibbus", 7);

	private final String TYPE;
	private final int PHASE_ID;

	private MoonPhase(String type, int phaseId) {
		TYPE = type;
		PHASE_ID = phaseId;
	}

	/** Resolves a moon phase from a string */
	public static MoonPhase from(String type) {
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
			default:
				return NONE;
		}
	}

	/** Returns a string representation of the variant */
	public String getType() {
		return TYPE;
	}

	public int getPhaseId() {
		return PHASE_ID;
	}

	/** Tests whether the current moon phase is the variant's type */
	public boolean isCurrent(World world) {
		return world.getMoonPhase() == PHASE_ID;
	}
}
