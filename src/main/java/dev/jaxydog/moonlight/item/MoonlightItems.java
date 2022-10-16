package dev.jaxydog.moonlight.item;

import dev.jaxydog.moonlight.block.MoonlightBlocks;
import dev.jaxydog.moonlight.content.MoonlightSoundEvents;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import dev.jaxydog.moonlight.utility.ToolModifier;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Items;
import net.minecraft.item.Item.Settings;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

/** Moonlight item class */
public class MoonlightItems {
	/** Icon item */
	public static final MoonlightItem ICON = new MoonlightItem(new Settings().maxCount(1).rarity(Rarity.RARE),
			new Config().setName("icon"));

	/** Avocado item */
	public static final MoonlightItem AVOCADO = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("avocado").setTooltipEnabled(true)
					.setUseSound(MoonlightSoundEvents.ITEM_AVOCADO_JINGLE));

	/** Banana item */
	public static final MoonlightItem BANANA = new MoonlightItem(
			new Settings()
					.food(new FoodComponent.Builder().hunger(2).saturationModifier(1f).snack().alwaysEdible().build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("banana").setTooltipEnabled(true));

	/** Banana bread item */
	public static final MoonlightItem BANANA_BREAD = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("banana_bread").setTooltipEnabled(true));

	/** Cheese item */
	public static final MoonlightItem CHEESE = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(1f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("cheese").setTooltipEnabled(true));

	/** Cheese and crackers item */
	public static final MoonlightItem CHEESE_AND_CRACKERS = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("cheese_and_crackers").setTooltipEnabled(true));

	/** Cheese block item */
	public static final MoonlightBlockItem CHEESE_BLOCK = new MoonlightBlockItem(
			MoonlightBlocks.CHEESE_BLOCK,
			new Settings().rarity(Rarity.UNCOMMON),
			new Config().setName("cheese_block").setTooltipEnabled(true));

	/** Cheese steak item */
	public static final MoonlightItem CHEESE_STEAK = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(10).saturationModifier(0.625f).meat().build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("cheese_steak").setTooltipEnabled(true));

	/** Cheesy baked potato item */
	public static final MoonlightItem CHEESY_BAKED_POTATO = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.875f).build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("cheesy_baked_potato").setTooltipEnabled(true));

	/** Cracker item */
	public static final MoonlightItem CRACKER = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.75f).snack().build())
					.rarity(Rarity.COMMON),
			new Config().setName("cracker").setTooltipEnabled(true));

	/** Dino nuggy item */
	public static final MoonlightItem DINO_NUGGIE = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.65f).snack().meat().build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("dino_nuggie").setTooltipEnabled(true));

	/** Grilled cheese item */
	public static final MoonlightItem GRILLED_CHEESE = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.75f).build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("grilled_cheese").setTooltipEnabled(true));

	/** Macaroni and cheese item */
	public static final MoonlightItem MACARONI_AND_CHEESE = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(1f).build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("macaroni_and_cheese").setTooltipEnabled(true));

	/** Pasta item */
	public static final MoonlightItem PASTA = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).snack().build())
					.rarity(Rarity.COMMON),
			new Config().setName("pasta").setTooltipEnabled(true));

	/** Blood bottle item */
	public static final MoonlightItem BLOOD_BOTTLE = new MoonlightItem(
			new Settings().maxCount(16).rarity(Rarity.EPIC),
			new Config().setName("blood_bottle").setTooltipEnabled(true));

	/** Land core item */
	public static final MoonlightItem LAND_CORE = new MoonlightItem(
			new Settings().maxCount(1).fireproof().rarity(Rarity.RARE),
			new Config().setName("land_core").setTooltipEnabled(true));

	/** Sea core item */
	public static final MoonlightItem SEA_CORE = new MoonlightItem(
			new Settings().maxCount(1).fireproof().rarity(Rarity.RARE),
			new Config().setName("sea_core").setTooltipEnabled(true));

	/** Sky core item */
	public static final MoonlightItem SKY_CORE = new MoonlightItem(
			new Settings().maxCount(1).fireproof().rarity(Rarity.RARE),
			new Config().setName("sky_core").setTooltipEnabled(true));

	/** Cave core item */
	public static final MoonlightItem CAVE_CORE = new MoonlightItem(
			new Settings().maxCount(1).fireproof().rarity(Rarity.RARE),
			new Config().setName("cave_core").setTooltipEnabled(true));

	/** Hell core item */
	public static final MoonlightItem HELL_CORE = new MoonlightItem(
			new Settings().maxCount(1).fireproof().rarity(Rarity.RARE),
			new Config().setName("hell_core").setTooltipEnabled(true));

	/** Hell sword item */
	public static final MoonlightToolItem.Sword HELL_SWORD = new MoonlightToolItem.Sword(
			new MoonlightToolItem.Material().setAttackDamage(4).setDurability(2560), 4, -3f,
			new Settings().fireproof().maxCount(1).rarity(Rarity.EPIC),
			new Config().setName("hell_sword").setInventoryTick((stack, world, entity, slot, equipped) -> {
				ToolModifier.SHRINK_REACH_SMALL.tick(stack, world, entity, slot, equipped);
				return true;
			}));

	/** Hell hammer item */
	public static final MoonlightToolItem.Sword HELL_HAMMER = new MoonlightToolItem.Sword(
			new MoonlightToolItem.Material().setAttackDamage(5.5f).setDurability(2560), 5, -3.6f,
			new Settings().fireproof().maxCount(1).rarity(Rarity.EPIC),
			new Config().setName("hell_hammer").setInventoryTick((stack, world, entity, slot, equipped) -> {
				ToolModifier.SHRINK_REACH_MEDIUM.tick(stack, world, entity, slot, equipped);
				return true;
			}));

	/** Glass armor set */
	public static final MoonlightArmorItem[] GLASS_ARMOR = MoonlightArmorItem.createSet(
			new MoonlightArmorItem.Material().setName("glass").setDurability(0),
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("glass").setGlintEnabled(false).setTooltipEnabled(true));

	/** Hell armor set */
	public static final MoonlightArmorItem[] HELL_ARMOR = MoonlightArmorItem.createSet(
			new MoonlightArmorItem.Material().setName("hell").setDurability(45).setEnchantability(10)
					.setEquipSound(SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE).setToughness(3.25f)
					.setKnockbackResistance(0.125f).setProtectionAmount(4, 9, 7, 4)
					.setRepairIngredient(Items.NETHERITE_INGOT),
			new Settings().rarity(Rarity.EPIC).fireproof(),
			new Config().setName("hell").setTooltipEnabled(true));

	/** Modifies an existing built-in loot table */
	private static void modifyLoot(Identifier tableId, LootPool.Builder... builders) {
		LootTableEvents.MODIFY.register((res, loot, id, table, src) -> {
			if (!src.isBuiltin()) {
				return;
			}

			if (id.equals(tableId)) {
				for (var builder : builders) {
					table.pool(builder);
				}
			}
		});
	}

	/** Registers an armor set */
	private static void register(MoonlightArmorItem... items) {
		for (var item : items) {
			item.register();
		}
	}

	/** Registers all items */
	public static void register() {
		ICON.register();
		AVOCADO.register();
		BANANA.register();
		BANANA_BREAD.register();
		CHEESE.register();
		CHEESE_AND_CRACKERS.register();
		CHEESE_BLOCK.register();
		CHEESE_STEAK.register();
		CHEESY_BAKED_POTATO.register();
		CRACKER.register();
		DINO_NUGGIE.register();
		GRILLED_CHEESE.register();
		MACARONI_AND_CHEESE.register();
		PASTA.register();
		BLOOD_BOTTLE.register();
		LAND_CORE.register();
		SEA_CORE.register();
		SKY_CORE.register();
		CAVE_CORE.register();
		HELL_CORE.register();
		HELL_SWORD.register();
		HELL_HAMMER.register();

		register(GLASS_ARMOR);
		register(HELL_ARMOR);

		modifyLoot(
				Blocks.JUNGLE_LEAVES.getLootTableId(),
				LootPool.builder().rolls(BinomialLootNumberProvider.create(1, 0.0125f))
						.with(ItemEntry.builder(AVOCADO)),
				LootPool.builder().rolls(BinomialLootNumberProvider.create(3, 0.0125f))
						.with(ItemEntry.builder(BANANA)));
	}
}
