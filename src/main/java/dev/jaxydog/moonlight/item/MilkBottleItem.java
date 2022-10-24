package dev.jaxydog.moonlight.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class MilkBottleItem extends MoonlightItem {
	public MilkBottleItem(Settings settings, Config config) {
		super(settings, config);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user instanceof PlayerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
			stack.decrement(1);
		}
		if (!world.isClient && user.getStatusEffects().size() > 0) {
			var effects = user.getStatusEffects();
			var index = (int) Math.floor(Math.random() * effects.size());
			var instance = (StatusEffectInstance) effects.toArray()[index];

			user.removeStatusEffect(instance.getEffectType());
		}
		if (stack.isEmpty()) {
			return new ItemStack(Items.GLASS_BOTTLE);
		}

		return super.finishUsing(stack, world, user);
	}
}
