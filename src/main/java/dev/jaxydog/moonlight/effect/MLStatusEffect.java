package dev.jaxydog.moonlight.effect;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.utility.Registerable;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MLStatusEffect extends StatusEffect implements Registerable {

	protected final Config _CONFIG;

	public MLStatusEffect(Config config) {
		super(config.getCategory(), config.getColor());
		_CONFIG = config;
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_CONFIG.getName());
	}

	@Override
	public Registerable register() {
		return Registry.register(Registry.STATUS_EFFECT, getId(), this);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return _CONFIG.getPredicate().test(duration, amplifier);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		_CONFIG.getEffect().accept(entity, amplifier);
	}

	public static class Config {

		private final String __NAME;
		private StatusEffectCategory __category = StatusEffectCategory.NEUTRAL;
		private int __color = 0xFFFFFF;
		private BiPredicate<Integer, Integer> __predicate = (duration, amplifier) -> true;
		private BiConsumer<LivingEntity, Integer> __effect = (entity, amplifier) -> {};

		public Config(String name) {
			this.__NAME = name;
		}

		public String getName() {
			return __NAME;
		}

		public StatusEffectCategory getCategory() {
			return __category;
		}

		public int getColor() {
			return __color;
		}

		public BiPredicate<Integer, Integer> getPredicate() {
			return this.__predicate;
		}

		public BiConsumer<LivingEntity, Integer> getEffect() {
			return this.__effect;
		}

		public Config inCategory(StatusEffectCategory category) {
			this.__category = category;
			return this;
		}

		public Config withColor(int color) {
			this.__color = color;
			return this;
		}
	}
}
