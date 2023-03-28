package dev.jaxydog.moonlight.data;

import dev.jaxydog.moonlight.Moonlight;

public enum AxolotlEmotion {
	NEUTRAL("neutral"),
	HAPPY("happy"),
	SAD("sad"),
	ANGRY("angry");

	private final String NAME;

	private AxolotlEmotion(String name) {
		this.NAME = name;
	}

	public static AxolotlEmotion from(String name) {
		switch (name) {
			case "happy":
				return AxolotlEmotion.HAPPY;
			case "sad":
				return AxolotlEmotion.SAD;
			case "angry":
				return AxolotlEmotion.ANGRY;
		}

		return AxolotlEmotion.NEUTRAL;
	}

	public String getTranslationKey() {
		return Moonlight.id(this.getName()).toTranslationKey("emotion");
	}

	public String getName() {
		return this.NAME;
	}
}
