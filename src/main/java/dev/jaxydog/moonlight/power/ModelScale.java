package dev.jaxydog.moonlight.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.LivingEntity;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleTypes;

/** Model scale power class */
public class ModelScale extends Power {

	/** Width scale */
	private final float WIDTH;
	/** Height scale */
	private final float HEIGHT;

	public ModelScale(PowerType<?> type, LivingEntity entity, float width, float height) {
		super(type, entity);
		WIDTH = width;
		HEIGHT = height;
		setTicking(true);
	}

	@Override
	public void tick() {
		var builder = ScaleData.Builder.create().entity(entity);
		var width = builder.type(ScaleTypes.WIDTH).build();
		var height = builder.type(ScaleTypes.HEIGHT).build();

		width.setScale(isActive() ? WIDTH : 1);
		height.setScale(isActive() ? HEIGHT : 1);

		super.tick();
	}

	/** Returns the width scale */
	public float getWidth() {
		return WIDTH;
	}

	/** Returns the height scale */
	public float getHeight() {
		return HEIGHT;
	}
}
