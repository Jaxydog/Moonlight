package dev.jaxydog.moonlight.item;

import java.util.List;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

/** Tool item wrapper class */
public class MoonlightToolItem extends ToolItem {
    private final Config CONFIG;

    public MoonlightToolItem(Material material, Settings settings, Config config) {
        super(material, settings);
        CONFIG = config;
    }

    /** Returns the item's identifier */
    public Identifier getId() {
        return Moonlight.id(CONFIG.getName());
    }

    /** Registers the item */
    public MoonlightToolItem register() {
        return Registry.register(Registry.ITEM, this.getId(), this);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return CONFIG.isGlintEnabled() && (CONFIG.isGlintForced() || super.hasGlint(stack));
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (CONFIG.isTooltipEnabled()) {
            var key = "item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip";
            tooltip.add(Text.translatable(key).formatted(Formatting.GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    /** Sword item wrapper class */
    public static class Sword extends SwordItem {
        private final Config CONFIG;

        protected Sword(Material material, int attackDamage, float attackSpeed, Settings settings, Config config) {
            super(material, attackDamage, attackSpeed, settings);
            CONFIG = config;
        }

        /** Returns the item's identifier */
        public Identifier getId() {
            return Moonlight.id(CONFIG.getName());
        }

        /** Registers the item */
        public Sword register() {
            return Registry.register(Registry.ITEM, this.getId(), this);
        }

        @Override
        public boolean hasGlint(ItemStack stack) {
            return CONFIG.isGlintEnabled() && (CONFIG.isGlintForced() || super.hasGlint(stack));
        }

        @Override
        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            if (CONFIG.isTooltipEnabled()) {
                var key = "item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip";
                tooltip.add(Text.translatable(key).formatted(Formatting.GRAY));
            }

            super.appendTooltip(stack, world, tooltip, context);
        }
    }

    /** Axe item wrapper class */
    public static class Axe extends AxeItem {
        private final Config CONFIG;

        protected Axe(Material material, int attackDamage, float attackSpeed, Settings settings, Config config) {
            super(material, attackDamage, attackSpeed, settings);
            CONFIG = config;
        }

        /** Returns the item's identifier */
        public Identifier getId() {
            return Moonlight.id(CONFIG.getName());
        }

        /** Registers the item */
        public Axe register() {
            return Registry.register(Registry.ITEM, this.getId(), this);
        }

        @Override
        public boolean hasGlint(ItemStack stack) {
            return CONFIG.isGlintEnabled() && (CONFIG.isGlintForced() || super.hasGlint(stack));
        }

        @Override
        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            if (CONFIG.isTooltipEnabled()) {
                var key = "item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip";
                tooltip.add(Text.translatable(key).formatted(Formatting.GRAY));
            }

            super.appendTooltip(stack, world, tooltip, context);
        }
    }

    /** Pickaxe item wrapper class */
    public static class Pickaxe extends PickaxeItem {
        private final Config CONFIG;

        protected Pickaxe(Material material, int attackDamage, float attackSpeed, Settings settings, Config config) {
            super(material, attackDamage, attackSpeed, settings);
            CONFIG = config;
        }

        /** Returns the item's identifier */
        public Identifier getId() {
            return Moonlight.id(CONFIG.getName());
        }

        /** Registers the item */
        public Pickaxe register() {
            return Registry.register(Registry.ITEM, this.getId(), this);
        }

        @Override
        public boolean hasGlint(ItemStack stack) {
            return CONFIG.isGlintEnabled() && (CONFIG.isGlintForced() || super.hasGlint(stack));
        }

        @Override
        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            if (CONFIG.isTooltipEnabled()) {
                var key = "item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip";
                tooltip.add(Text.translatable(key).formatted(Formatting.GRAY));
            }

            super.appendTooltip(stack, world, tooltip, context);
        }
    }

    /** Shovel item wrapper class */
    public static class Shovel extends ShovelItem {
        private final Config CONFIG;

        protected Shovel(Material material, int attackDamage, float attackSpeed, Settings settings, Config config) {
            super(material, attackDamage, attackSpeed, settings);
            CONFIG = config;
        }

        /** Returns the item's identifier */
        public Identifier getId() {
            return Moonlight.id(CONFIG.getName());
        }

        /** Registers the item */
        public Shovel register() {
            return Registry.register(Registry.ITEM, this.getId(), this);
        }

        @Override
        public boolean hasGlint(ItemStack stack) {
            return CONFIG.isGlintEnabled() && (CONFIG.isGlintForced() || super.hasGlint(stack));
        }

        @Override
        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            if (CONFIG.isTooltipEnabled()) {
                var key = "item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip";
                tooltip.add(Text.translatable(key).formatted(Formatting.GRAY));
            }

            super.appendTooltip(stack, world, tooltip, context);
        }
    }

    /** Hoe item wrapper class */
    public static class Hoe extends HoeItem {
        private final Config CONFIG;

        protected Hoe(Material material, int attackDamage, float attackSpeed, Settings settings, Config config) {
            super(material, attackDamage, attackSpeed, settings);
            CONFIG = config;
        }

        /** Returns the item's identifier */
        public Identifier getId() {
            return Moonlight.id(CONFIG.getName());
        }

        /** Registers the item */
        public Hoe register() {
            return Registry.register(Registry.ITEM, this.getId(), this);
        }

        @Override
        public boolean hasGlint(ItemStack stack) {
            return CONFIG.isGlintEnabled() && (CONFIG.isGlintForced() || super.hasGlint(stack));
        }

        @Override
        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            if (CONFIG.isTooltipEnabled()) {
                var key = "item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip";
                tooltip.add(Text.translatable(key).formatted(Formatting.GRAY));
            }

            super.appendTooltip(stack, world, tooltip, context);
        }
    }

    /** Tool material implementation */
    public static class Material implements ToolMaterial {
        private int durability = 1;
        private float miningSpeed = 0.0f;
        private float attackDamage = 0.0f;
        private int miningLevel = 0;
        private int enchantability = 0;
        private Ingredient repairIngredient = Ingredient.empty();

        /** Returns the material's durability */
        @Override
        public int getDurability() {
            return durability;
        }

        /** Sets the material's durability value */
        public Material setDurability(int durability) {
            this.durability = durability;
            return this;
        }

        /** Returns the material's mining speed multiplier */
        @Override
        public float getMiningSpeedMultiplier() {
            return miningSpeed;
        }

        /** Sets the material's mining speed multiplier */
        public Material setMiningSpeedMultiplier(float speed) {
            this.miningSpeed = speed;
            return this;
        }

        /** Returns the material's attack damage */
        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        /** Sets the material's attack damage */
        public Material setAttackDamage(float damage) {
            this.attackDamage = damage;
            return this;
        }

        /** Returns the material's mining level */
        @Override
        public int getMiningLevel() {
            return miningLevel;
        }

        /** Sets the material's mining level */
        public Material setMiningLevel(int level) {
            this.miningLevel = level;
            return this;
        }

        /** Returns the material's enchantability */
        @Override
        public int getEnchantability() {
            return enchantability;
        }

        /** Sets the material's enchantability */
        public Material setEnchantability(int enchantability) {
            this.enchantability = enchantability;
            return this;
        }

        /** Returns the material's repair ingredient */
        @Override
        public Ingredient getRepairIngredient() {
            return repairIngredient;
        }

        /** Sets the material's repair ingredient to the provided ingredient */
        public Material setRepairIngredient(Ingredient ingredient) {
            this.repairIngredient = ingredient;
            return this;
        }

        /** Sets the material's repair ingredient from the provided items */
        public Material setRepairIngredient(ItemConvertible... items) {
            this.repairIngredient = Ingredient.ofItems(items);
            return this;
        }

        /** Sets the material's repair ingredient from the provided item stacks */
        public Material setRepairIngredient(ItemStack... items) {
            this.repairIngredient = Ingredient.ofStacks(items);
            return this;
        }
    }
}
