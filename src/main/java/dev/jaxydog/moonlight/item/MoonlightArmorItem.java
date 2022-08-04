package dev.jaxydog.moonlight.item;

import java.util.List;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

/** Armor item wrapper class */
public class MoonlightArmorItem extends ArmorItem {
	private final Config CONFIG;

	public MoonlightArmorItem(Material material, EquipmentSlot slot, Settings settings, Config config) {
		super(material, slot, settings.group(Config.DEFAULT_GROUP));
		CONFIG = config;
	}

	/** Creates an armor set */
	public static MoonlightArmorItem[] createSet(Material material, Settings settings, Config config) {
		var helmet = new MoonlightArmorItem(
				material.clone(),
				EquipmentSlot.HEAD,
				settings,
				config.clone().setName(config.getName() + "_helmet"));
		var chestplate = new MoonlightArmorItem(
				material.clone(),
				EquipmentSlot.CHEST,
				settings,
				config.clone().setName(config.getName() + "_chestplate"));
		var leggings = new MoonlightArmorItem(
				material.clone(),
				EquipmentSlot.LEGS,
				settings,
				config.clone().setName(config.getName() + "_leggings"));
		var boots = new MoonlightArmorItem(
				material.clone(),
				EquipmentSlot.FEET,
				settings,
				config.clone().setName(config.getName() + "_boots"));

		return new MoonlightArmorItem[] { helmet, chestplate, leggings, boots };
	}

	/** Returns the armor item's identifier */
	public Identifier getId() {
		return Moonlight.id(CONFIG.getName());
	}

	/** Registers the armor item */
	public MoonlightArmorItem register() {
		return Registry.register(Registry.ITEM, this.getId(), this);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return CONFIG.isGlintEnabled() && (CONFIG.isGlintForced() || super.hasGlint(stack));
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (CONFIG.getUseSound() != null) {
			var pitch = (float) (Math.random() * (Config.PITCH_RANGE * 2)) - Config.PITCH_RANGE;

			world.playSound(
					null,
					user.getBlockPos(),
					CONFIG.getUseSound(),
					SoundCategory.PLAYERS,
					Config.DEFAULT_VOLUME, pitch);
		}

		for (var status : CONFIG.getUseEffects()) {
			var effect = new StatusEffectInstance(status);
			user.addStatusEffect(effect, null);
		}

		return super.finishUsing(stack, world, user);
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		var key = stack.getItem().getTranslationKey() + ".tooltip_";
		var i = -1;

		while (CONFIG.isTooltipEnabled() && I18n.hasTranslation(key + ++i)) {
			tooltip.add(Text.translatable(key + i).formatted(Formatting.GRAY));
		}

		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (CONFIG.getInventoryTick() != null) {
			if (!CONFIG.getInventoryTick().apply(stack, world, entity, slot, selected)) {
				return;
			}
		}

		super.inventoryTick(stack, world, entity, slot, selected);
	}

	/** Armor material implementation */
	public static class Material implements ArmorMaterial {
		private static final int[] BASE_DURABILITY = new int[] { 13, 15, 16, 11 };
		private float durabilityModifier = 0.0f;
		private int[] protection = new int[] { 0, 0, 0, 0 };
		private int enchantability = 0;
		private SoundEvent equipSound = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
		private Ingredient repairIngredient = Ingredient.empty();
		private String name;
		private float toughness = 0.0f;
		private float knockbackResistance = 0.0f;

		public Material clone() {
			var mat = new Material();
			mat.durabilityModifier = durabilityModifier;
			mat.protection = protection;
			mat.enchantability = enchantability;
			mat.equipSound = equipSound;
			mat.repairIngredient = repairIngredient;
			mat.name = name;
			mat.toughness = toughness;
			mat.knockbackResistance = knockbackResistance;
			return mat;
		}

		/** Returns the material's durability for the provided slot */
		@Override
		public int getDurability(EquipmentSlot slot) {
			return Math.max(1, (int) (durabilityModifier * BASE_DURABILITY[slot.getEntitySlotId()]));
		}

		/** Sets the material's durability modifier */
		public Material setDurability(float modifier) {
			this.durabilityModifier = modifier;
			return this;
		}

		/** Returns the material's protection amount for the provided slot */
		@Override
		public int getProtectionAmount(EquipmentSlot slot) {
			return protection[slot.getEntitySlotId()];
		}

		/** Sets the material's protection values */
		public Material setProtectionAmount(int head, int chest, int legs, int feet) {
			this.protection = new int[] { feet, legs, chest, head };
			return this;
		}

		/** Returns the material's enchantability */
		@Override
		public int getEnchantability() {
			return enchantability;
		}

		/** Sets the material's enchantability value */
		public Material setEnchantability(int enchantability) {
			this.enchantability = enchantability;
			return this;
		}

		/** Returns the material's equip sound */
		@Override
		public SoundEvent getEquipSound() {
			return equipSound;
		}

		/** Sets the material's equip sound */
		public Material setEquipSound(SoundEvent sound) {
			this.equipSound = sound;
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

		/** Returns the material's name */
		@Override
		public String getName() {
			return name;
		}

		/** Sets the material's name */
		public Material setName(String name) {
			this.name = name;
			return this;
		}

		/** Returns the material's toughness */
		@Override
		public float getToughness() {
			return toughness;
		}

		/** Sets the material's toughness value */
		public Material setToughness(float toughness) {
			this.toughness = toughness;
			return this;
		}

		/** Returns the material's knockback resistance */
		@Override
		public float getKnockbackResistance() {
			return knockbackResistance;
		}

		/** Sets the material's knockback resistance */
		public Material setKnockbackResistance(float resistance) {
			this.knockbackResistance = resistance;
			return this;
		}
	}
}
