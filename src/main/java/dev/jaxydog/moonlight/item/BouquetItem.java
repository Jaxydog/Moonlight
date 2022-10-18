package dev.jaxydog.moonlight.item;

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

public class BouquetItem extends MoonlightItem {
	public BouquetItem(Settings settings, Config config) {
		super(settings, config);
	}

	public static boolean useOnFertilizable(ItemStack stack, World world, BlockPos pos) {
		Fertilizable fertilizable;
		var state = world.getBlockState(pos);

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
			user.heal(4);
		}

		return super.finishUsing(stack, world, user);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		var world = context.getWorld();
		var pos = context.getBlockPos();

		if (BouquetItem.useOnFertilizable(context.getStack(), world, context.getBlockPos())) {
			if (!world.isClient) {
				world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, pos, 0);
			}
			return ActionResult.success(world.isClient);
		}

		var state = world.getBlockState(pos);
		var side = pos.offset(context.getSide());
		var solid = state.isSideSolidFullSquare(world, side, context.getSide());

		if (solid && BoneMealItem.useOnGround(context.getStack(), world, side, context.getSide())) {
			if (!world.isClient) {
				world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, side, 0);
			}
			return ActionResult.success(world.isClient);
		}

		return super.useOnBlock(context);
	}
}
