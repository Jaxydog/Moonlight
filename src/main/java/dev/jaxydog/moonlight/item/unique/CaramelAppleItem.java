package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.item.MLItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class CaramelAppleItem extends MLItem {

	public CaramelAppleItem(Settings settings, Config config) {
		super(settings, config);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user instanceof PlayerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
			((PlayerEntity) user).getInventory().insertStack(Items.STICK.getDefaultStack());
		}

		return super.finishUsing(stack, world, user);
	}
}
