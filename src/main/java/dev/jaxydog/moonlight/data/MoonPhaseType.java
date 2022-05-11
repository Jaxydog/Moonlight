package dev.jaxydog.moonlight.data;

import java.util.function.Function;

import net.minecraft.world.World;

public enum MoonPhaseType {
	NONE("", (w) -> false),
	FULL("full", (w) -> w.getMoonPhase() == 0),
	WANING_GIBBUS("waning_gibbus", (w) -> w.getMoonPhase() == 1),
	THIRD_QUARTER("third_quarter", (w) -> w.getMoonPhase() == 2),
	WANING_CRESCENT("waning_crescent", (w) -> w.getMoonPhase() == 3),
	NEW("new", (w) -> w.getMoonPhase() == 4),
	WAXING_CRESCENT("waxing_crescent", (w) -> w.getMoonPhase() == 5),
	FIRST_QUARTER("first_quarted", (w) -> w.getMoonPhase() == 6),
	WAXING_GIBBUS("waxing_gibbus", (w) -> w.getMoonPhase() == 7);

	private final String TYPE;
	private final Function<World, Boolean> TEST;

	private MoonPhaseType(String type, Function<World, Boolean> test) {
		this.TYPE = type;
		this.TEST = test;
	}

	public static MoonPhaseType getFromString(String type) {
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

	public String getType() {
		return this.TYPE;
	}

	public boolean test(World world) {
		return this.TEST.apply(world);
	}
}
