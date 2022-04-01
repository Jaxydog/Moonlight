package dev.jaxydog.moonlight.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.LivingEntity;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleTypes;

public class ModelScale extends Power {
	private final float WIDTH;
	private final float HEIGHT;
	private final float REACH;
	private final boolean SCALE_REACH;

	public ModelScale(PowerType<?> type, LivingEntity entity, float width, float height, boolean scaleReach) {
		super(type, entity);
		this.WIDTH = width;
		this.HEIGHT = height;
		this.REACH = (float) Math.sqrt((width + height) / 2);
		this.SCALE_REACH = scaleReach;
		setTicking(true);
	}

	private void update(ScaleData data, float target) {
		if (data.getScale() != target) {
			data.setScale(target);
		}
	}

	private void updateAll() {
		var base = ScaleData.Builder.create().entity(entity);

		update(base.type(ScaleTypes.WIDTH).build(), isActive() ? this.WIDTH : 1);
		update(base.type(ScaleTypes.HEIGHT).build(), isActive() ? this.HEIGHT : 1);

		if (this.SCALE_REACH) {
			update(base.type(ScaleTypes.REACH).build(), isActive() ? this.REACH : 1);
		}
	}

	public float getWidth() {
		return this.WIDTH;
	}

	public float getHeight() {
		return this.HEIGHT;
	}

	public float getReach() {
		return this.REACH;
	}

	public boolean isReachScaled() {
		return this.SCALE_REACH;
	}

	@Override
	public void tick() {
		super.tick();
		updateAll();
	}
}
