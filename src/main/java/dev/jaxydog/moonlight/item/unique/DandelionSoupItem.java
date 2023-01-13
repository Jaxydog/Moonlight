package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.item.MLItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class DandelionSoupItem extends MLItem {

	public DandelionSoupItem(Settings settings, Config config) {
		super(settings, config);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user instanceof PlayerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
			((PlayerEntity) user).getInventory().insertStack(Items.BOWL.getDefaultStack());
		}

		user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0));

		return super.finishUsing(stack, world, user);
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.EAT;
	}
}
