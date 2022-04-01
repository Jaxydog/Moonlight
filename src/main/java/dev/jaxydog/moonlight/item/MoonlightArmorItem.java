package dev.jaxydog.moonlight.item;

import java.util.List;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MoonlightArmorItem extends ArmorItem {
	private final Config CONFIG;

	public MoonlightArmorItem(Config config, Material material, EquipmentSlot slot, Settings settings) {
		super(material.setName(config.getName()), slot, settings.group(Config.DEFAULT_GROUP));
		this.CONFIG = config;
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
			var text = new TranslatableText("item." + Moonlight.MOD_ID + "." + CONFIG.getName() + ".tooltip");
			tooltip.add(text.formatted(Formatting.GRAY));
		}

		super.appendTooltip(stack, world, tooltip, context);
	}

	public static class Material implements ArmorMaterial {
		private String name;
		private int[] durability;
		private int[] protection;
		private int enchantability;
		private float toughness;
		private SoundEvent sound;
		private Ingredient ingredient;

		public Material clone() {
			return new Material()
					.setName(this.name)
					.setDurability(this.durability)
					.setProtectionAmount(this.protection)
					.setEnchantability(this.enchantability)
					.setToughness(this.toughness)
					.setEquipSound(this.sound)
					.setRepairIngredient(this.ingredient);
		}

		public Material setDurability(int... value) {
			this.durability = value;
			return this;
		}

		@Override
		public int getDurability(EquipmentSlot slot) {
			return durability[slot.getEntitySlotId()];
		}

		public Material setProtectionAmount(int... value) {
			this.protection = value;
			return this;
		}

		@Override
		public int getProtectionAmount(EquipmentSlot slot) {
			return protection[slot.getEntitySlotId()];
		}

		public Material setEnchantability(int value) {
			this.enchantability = value;
			return this;
		}

		@Override
		public int getEnchantability() {
			return enchantability;
		}

		public Material setEquipSound(SoundEvent value) {
			this.sound = value;
			return this;
		}

		@Override
		public SoundEvent getEquipSound() {
			return sound;
		}

		public Material setRepairIngredient(Item... value) {
			this.ingredient = Ingredient.ofItems(value);
			return this;
		}

		public Material setRepairIngredient(Ingredient value) {
			this.ingredient = value;
			return this;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return ingredient;
		}

		public Material setName(String value) {
			this.name = value;
			return this;
		}

		@Override
		public String getName() {
			return name;
		}

		public Material setToughness(float value) {
			this.toughness = value;
			return this;
		}

		@Override
		public float getToughness() {
			return toughness;
		}

		@Override
		public float getKnockbackResistance() {
			return 0;
		}
	}
}
