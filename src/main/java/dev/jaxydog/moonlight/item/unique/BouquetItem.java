package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.item.MLItem;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

public class BouquetItem extends MLItem {

	public static final float HEAL_AMOUNT = 4.0f;

	public BouquetItem(Settings settings, Config config) {
		super(settings, config);
	}

	public static boolean useOnFertilizable(ItemStack stack, World world, BlockPos pos) {
		var state = world.getBlockState(pos);
		Fertilizable fertilizable;

		if (state.getBlock() instanceof Fertilizable) {
			fertilizable = (Fertilizable) state.getBlock();

			if (fertilizable.isFertilizable(world, pos, state, world.isClient)) {
				if (world instanceof ServerWorld) {
					if (fertilizable.canGrow(world, world.random, pos, state)) {
						fertilizable.grow((ServerWorld) world, world.random, pos, state);
						fertilizable.grow((ServerWorld) world, world.random, pos, state);
					}

					stack.decrement(1);
				}

				return true;
			}
		}

		return false;
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user.isAlive()) {
			user.heal(HEAL_AMOUNT);
		}

		return super.finishUsing(stack, world, user);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		var world = context.getWorld();
		var pos = context.getBlockPos();
		var stack = context.getStack();

		if (BouquetItem.useOnFertilizable(stack, world, pos)) {
			if (!world.isClient) {
				world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, pos, 0);
			}

			return ActionResult.success(world.isClient);
		}

		var side = context.getSide();
		var state = world.getBlockState(pos);
		var offset = pos.offset(side);
		var solid = state.isSideSolidFullSquare(world, offset, side);

		if (solid && BoneMealItem.useOnGround(stack, world, offset, side)) {
			if (world.isClient) {
				world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, offset, 0);
			}

			return ActionResult.success(world.isClient);
		}

		return super.useOnBlock(context);
	}
}
