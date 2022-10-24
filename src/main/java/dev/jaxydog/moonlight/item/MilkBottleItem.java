package dev.jaxydog.moonlight.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class MilkBottleItem extends MoonlightItem {
	public MilkBottleItem(Settings settings, Config config) {
		super(settings, config);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user instanceof PlayerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
			((PlayerEntity) user).getInventory().insertStack(Items.GLASS_BOTTLE.getDefaultStack());
		}
		if (!world.isClient && user.getStatusEffects().size() > 0) {
			var effects = user.getStatusEffects();
			var index = (int) Math.floor(Math.random() * effects.size());
			var instance = (StatusEffectInstance) effects.toArray()[index];

			user.removeStatusEffect(instance.getEffectType());
		}

		return super.finishUsing(stack, world, user);
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}
}
