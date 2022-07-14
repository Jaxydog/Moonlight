package dev.jaxydog.moonlight.item;

import java.util.List;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
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

public class MoonlightArmorItem extends ArmorItem {
	private final Config CONFIG;

	public MoonlightArmorItem(ArmorMaterial material, Config config, Settings settings, EquipmentSlot slot) {
		super(material, slot, settings.group(Config.DEFAULT_GROUP));
		this.CONFIG = config;
	}

	public static MoonlightArmorItem[] set(ArmorMaterial material, Config config, Settings settings) {
		return new MoonlightArmorItem[] {
				new MoonlightArmorItem(material, config.clone().setName(config.getName() + "_boots"), settings,
						EquipmentSlot.FEET),
				new MoonlightArmorItem(material, config.clone().setName(config.getName() + "_leggings"), settings,
						EquipmentSlot.LEGS),
				new MoonlightArmorItem(material, config.clone().setName(config.getName() + "_chestplate"), settings,
						EquipmentSlot.CHEST),
				new MoonlightArmorItem(material, config.clone().setName(config.getName() + "_helmet"), settings,
						EquipmentSlot.HEAD),
		};
	}

	public Identifier Id() {
		return Moonlight.Id(CONFIG.getName());
	}

	public MoonlightArmorItem register() {
		return Registry.register(Registry.ITEM, this.Id(), this);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return CONFIG.getGlintForced() || (CONFIG.getGlintEnabled() && super.hasGlint(stack));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if (CONFIG.getTooltipEnabled()) {
			var key = "item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip";
			tooltip.add(Text.translatable(key).formatted(Formatting.GRAY));
		}

		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (CONFIG.getUseSound() != null) {
			var pitch = (float) ((Math.random() * (Config.PITCH_RANGE * 2)) - Config.PITCH_RANGE);
			world.playSound(
					null,
					user.getBlockPos(),
					CONFIG.getUseSound(),
					SoundCategory.PLAYERS,
					Config.DEFAULT_VOLUME, 1 - pitch);
		}

		for (var effect : CONFIG.getUseEffects().clone()) {
			user.addStatusEffect(effect, null);
		}

		return super.finishUsing(stack, world, user);
	}

	public static class Material implements ArmorMaterial {
		private static final int[] __BASE_DURABILITY = new int[] { 13, 15, 16, 11 };

		private float durabilityMod = 1.0f;
		private int[] protection = new int[] { 0, 0, 0, 0 };
		private int enchantability = 0;
		private SoundEvent equipSound = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
		private Ingredient repairIngredient = Ingredient.empty();
		private String name;
		private float toughness = 0.0f;
		private float knockbackResistance = 0.0f;

		@Override
		public int getDurability(EquipmentSlot slot) {
			return Math.max((int) (__BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMod), 1);
		}

		public Material setDurabilityMod(float modifier) {
			this.durabilityMod = modifier;
			return this;
		}

		@Override
		public int getProtectionAmount(EquipmentSlot slot) {
			return this.protection[slot.getEntitySlotId()];
		}

		public Material setProtectionAmount(int head, int chest, int legs, int feet) {
			this.protection = new int[] { feet, legs, chest, head };
			return this;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		public Material setEnchantability(int enchantability) {
			this.enchantability = enchantability;
			return this;
		}

		@Override
		public SoundEvent getEquipSound() {
			return this.equipSound;
		}

		public Material setEquipSound(SoundEvent sound) {
			this.equipSound = sound;
			return this;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return this.repairIngredient;
		}

		public Material setRepairIngredient(Ingredient ingredient) {
			this.repairIngredient = ingredient;
			return this;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public Material setName(String name) {
			this.name = name;
			return this;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}

		public Material setToughness(float toughness) {
			this.toughness = toughness;
			return this;
		}

		@Override
		public float getKnockbackResistance() {
			return this.knockbackResistance;
		}

		public Material setKnockbackResistance(float resistance) {
			this.knockbackResistance = resistance;
			return this;
		}
	}
}
