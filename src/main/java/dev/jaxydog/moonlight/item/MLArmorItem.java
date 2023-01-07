package dev.jaxydog.moonlight.item;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MLItem.Config;
import dev.jaxydog.moonlight.utility.Registerable;
import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
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

public class MLArmorItem extends ArmorItem implements Registerable {

	protected final Config _CONFIG;

	public MLArmorItem(Material material, EquipmentSlot slot, Settings settings, Config config) {
		super(material, slot, settings.group(Config.DEFAULT_GROUP));
		_CONFIG = config;
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_CONFIG.getName());
	}

	@Override
	public MLArmorItem register() {
		return Registry.register(Registry.ITEM, getId(), this);
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		var key = stack.getItem().getTranslationKey() + ".tooltip_";
		var i = 0;

		while (_CONFIG.isTooltipEnabled() && I18n.hasTranslation(key + i)) {
			tooltip.add(Text.translatable(key + i).formatted(Formatting.GRAY));
			i += 1;
		}

		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		var sound = _CONFIG.getUseSound();

		if (sound != null) {
			var change = (float) (Math.random() * (Config.PITCH_VARIANCE * 2)) - Config.PITCH_VARIANCE;
			var pitch = 1.0f - change;

			world.playSoundFromEntity(null, user, sound, SoundCategory.PLAYERS, Config.DEFAULT_VOLUME, pitch);
		}

		return super.finishUsing(stack, world, user);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return _CONFIG.isGlintEnabled() && (_CONFIG.isGlintForced() || super.hasGlint(stack));
	}

	public static class Material implements ArmorMaterial {

		private static final int[] __BASE_DURABILITY = new int[] { 13, 15, 16, 11 };

		private final String __NAME;
		private int[] __protection = new int[] { 0, 0, 0, 0 };
		private int __enchantability = 0;
		private float __durability = 0.0f;
		private float __toughness = 0.0f;
		private float __knockbackResist = 0.0f;
		private SoundEvent __equipSound = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
		private Ingredient __repairIngredient = Ingredient.empty();

		public Material(String name) {
			__NAME = name;
		}

		@Override
		public String getName() {
			return __NAME;
		}

		@Override
		public int getProtectionAmount(EquipmentSlot slot) {
			return __protection[slot.getEntitySlotId()];
		}

		@Override
		public int getEnchantability() {
			return __enchantability;
		}

		@Override
		public int getDurability(EquipmentSlot slot) {
			return Math.max(1, (int) (__durability * __BASE_DURABILITY[slot.getEntitySlotId()]));
		}

		@Override
		public float getToughness() {
			return __toughness;
		}

		@Override
		public float getKnockbackResistance() {
			return __knockbackResist;
		}

		@Override
		public SoundEvent getEquipSound() {
			return __equipSound;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return __repairIngredient;
		}

		public Material protection(int head, int chest, int legs, int feet) {
			__protection = new int[] { feet, legs, chest, head };
			return this;
		}

		public Material enchantability(int enchantability) {
			__enchantability = enchantability;
			return this;
		}

		public Material durability(float modifier) {
			__durability = modifier;
			return this;
		}

		public Material toughness(float toughness) {
			__toughness = toughness;
			return this;
		}

		public Material knockbackResistance(float resistance) {
			__knockbackResist = resistance;
			return this;
		}

		public Material equipSound(SoundEvent sound) {
			__equipSound = sound;
			return this;
		}

		public Material repairIngredient(Ingredient ingredient) {
			__repairIngredient = ingredient;
			return this;
		}

		public Material clone() {
			return clone(getName());
		}

		public Material clone(String name) {
			var m = new Material(name);

			m.__durability = __durability;
			m.__enchantability = __enchantability;
			m.__equipSound = __equipSound;
			m.__knockbackResist = __knockbackResist;
			m.__protection = __protection;
			m.__repairIngredient = __repairIngredient;
			m.__toughness = __toughness;

			return m;
		}
	}
}
