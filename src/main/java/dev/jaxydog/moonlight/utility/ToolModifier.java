package dev.jaxydog.moonlight.utility;

import dev.jaxydog.moonlight.data.MoonlightDataTypes.PentaFunction;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleTypes;

public enum ToolModifier {
    EXTEND_REACH_SMALL((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var blockReach = builder.type(ScaleTypes.BLOCK_REACH).build();
        var entityReach = builder.type(ScaleTypes.ENTITY_REACH).build();

        blockReach.setScale(equipped ? 1.25f : 1);
        entityReach.setScale(equipped ? 1.25f : 1);

        return true;
    }),
    EXTEND_REACH_MEDIUM((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var blockReach = builder.type(ScaleTypes.BLOCK_REACH).build();
        var entityReach = builder.type(ScaleTypes.ENTITY_REACH).build();

        blockReach.setScale(equipped ? 1.5f : 1);
        entityReach.setScale(equipped ? 1.5f : 1);

        return true;
    }),
    EXTEND_REACH_LARGE((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var blockReach = builder.type(ScaleTypes.BLOCK_REACH).build();
        var entityReach = builder.type(ScaleTypes.ENTITY_REACH).build();

        blockReach.setScale(equipped ? 1.75f : 1);
        entityReach.setScale(equipped ? 1.75f : 1);

        return true;
    }),
    SHRINK_REACH_SMALL((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var blockReach = builder.type(ScaleTypes.BLOCK_REACH).build();
        var entityReach = builder.type(ScaleTypes.ENTITY_REACH).build();

        blockReach.setScale(equipped ? 0.8f : 1);
        entityReach.setScale(equipped ? 0.8f : 1);

        return true;
    }),
    SHRINK_REACH_MEDIUM((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var blockReach = builder.type(ScaleTypes.BLOCK_REACH).build();
        var entityReach = builder.type(ScaleTypes.ENTITY_REACH).build();

        blockReach.setScale(equipped ? 0.6f : 1);
        entityReach.setScale(equipped ? 0.6f : 1);

        return true;
    }),
    SHRINK_REACH_LARGE((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var blockReach = builder.type(ScaleTypes.BLOCK_REACH).build();
        var entityReach = builder.type(ScaleTypes.ENTITY_REACH).build();

        blockReach.setScale(equipped ? 0.4f : 1);
        entityReach.setScale(equipped ? 0.4f : 1);

        return true;
    }),
    QUICK_ATTACK_SMALL((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var attackSpeed = builder.type(ScaleTypes.ATTACK_SPEED).build();

        attackSpeed.setScale(equipped ? 1.25f : 1);

        return true;
    }),
    QUICK_ATTACK_MEDIUM((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var attackSpeed = builder.type(ScaleTypes.ATTACK_SPEED).build();

        attackSpeed.setScale(equipped ? 1.5f : 1);

        return true;
    }),
    QUICK_ATTACK_LARGE((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var attackSpeed = builder.type(ScaleTypes.ATTACK_SPEED).build();

        attackSpeed.setScale(equipped ? 1.75f : 1);

        return true;
    }),
    SLOW_ATTACK_SMALL((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var attackSpeed = builder.type(ScaleTypes.ATTACK_SPEED).build();

        attackSpeed.setScale(equipped ? 0.8f : 1);

        return true;
    }),
    SLOW_ATTACK_MEDIUM((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var attackSpeed = builder.type(ScaleTypes.ATTACK_SPEED).build();

        attackSpeed.setScale(equipped ? 0.6f : 1);

        return true;
    }),
    SLOW_ATTACK_LARGE((stack, world, entity, slot, equipped) -> {
        var builder = ScaleData.Builder.create().entity(entity);
        var attackSpeed = builder.type(ScaleTypes.ATTACK_SPEED).build();

        attackSpeed.setScale(equipped ? 0.4f : 1);

        return true;
    });

    private final PentaFunction<ItemStack, World, Entity, Integer, Boolean, Boolean> TICK;

    private ToolModifier(PentaFunction<ItemStack, World, Entity, Integer, Boolean, Boolean> tick) {
        TICK = tick;
    }

    public boolean tick(ItemStack stack, World world, Entity entity, int slot, boolean equipped) {
        return TICK.apply(stack, world, entity, slot, equipped);
    }
}
