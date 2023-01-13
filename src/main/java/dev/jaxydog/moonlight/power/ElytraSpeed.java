package dev.jaxydog.moonlight.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.LivingEntity;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleTypes;

public class ElytraSpeed extends Power {

	private final float SPEED;

	public ElytraSpeed(PowerType<?> type, LivingEntity entity, float speed) {
		super(type, entity);
		this.SPEED = speed;
		setTicking(true);
	}

	@Override
	public void tick() {
		var data = ScaleData.Builder.create().entity(entity).type(ScaleTypes.FLIGHT).build();

		data.setScale(isActive() ? SPEED : 1);

		super.tick();
	}

	public float getSpeed() {
		return this.SPEED;
	}
}
