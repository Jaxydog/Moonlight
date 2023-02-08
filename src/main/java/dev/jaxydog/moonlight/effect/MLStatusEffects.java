package dev.jaxydog.moonlight.effect;

import dev.jaxydog.moonlight.effect.MLStatusEffect.Config;
import net.minecraft.entity.effect.StatusEffectCategory;

public class MLStatusEffects {

	public static final MLStatusEffect FRIEND = new MLStatusEffect(
		new Config("friend").inCategory(StatusEffectCategory.BENEFICIAL).withColor(0xEEAABB)
	);

	public static void register() {
		FRIEND.register();
	}
}
