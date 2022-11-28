package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.item.MLItem;
import net.minecraft.util.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;

public class ButterMilkItem extends MLItem {

    public ButterMilkItem(Settings settings, Config config) {
        super(settings, config);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
            ((PlayerEntity) user).getInventory().insertStack(Items.BUCKET.getDefaultStack());
        }

        return super.finishUsing(stack, world, user);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

}