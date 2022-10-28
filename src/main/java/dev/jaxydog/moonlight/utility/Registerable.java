package dev.jaxydog.moonlight.utility;

import net.minecraft.util.Identifier;

public interface Registerable {
	public Identifier getId();

	public Registerable register();
}
