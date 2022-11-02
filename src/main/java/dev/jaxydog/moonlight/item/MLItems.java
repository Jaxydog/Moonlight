package dev.jaxydog.moonlight.item;

import dev.jaxydog.moonlight.block.MLBlocks;
import dev.jaxydog.moonlight.content.MLSoundEvents;
import dev.jaxydog.moonlight.item.MLArmorItem.Material;
import dev.jaxydog.moonlight.item.MLItem.Config;
import dev.jaxydog.moonlight.item.MLItem.LootModifier;
import dev.jaxydog.moonlight.item.unique.BouquetItem;
import dev.jaxydog.moonlight.item.unique.ButterMilkItem;
import dev.jaxydog.moonlight.item.unique.MLDyeableAmethystBlockItem;
import dev.jaxydog.moonlight.item.unique.MLDyeableAmethystClusterBlockItem;
import dev.jaxydog.moonlight.item.unique.MilkBottleItem;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Items;
import net.minecraft.item.Item.Settings;
import net.minecraft.loot.LootTables;
import net.minecraft.util.Rarity;

public class MLItems {

	public static final MLItem ICON = new MLItem(
			new Settings().maxCount(1).rarity(Rarity.RARE),
			new Config("icon").withTooltip());

	public static final MLItem GOOBY_ESSENCE = new MLItem(
			new Settings().rarity(Rarity.RARE),
			new Config("gooby_essence").withTooltip());

	public static final MLDyeableAmethystBlockItem AMETHYST_BLOCK = new MLDyeableAmethystBlockItem(
			MLBlocks.AMETHYST_BLOCK,
			new Settings().rarity(Rarity.COMMON),
			new Config("amethyst_block"));

	public static final MLDyeableAmethystClusterBlockItem AMETHYST_CLUSTER = new MLDyeableAmethystClusterBlockItem(
			MLBlocks.AMETHYST_CLUSTER,
			new Settings().rarity(Rarity.COMMON),
			new Config("amethyst_cluster"));

	public static final MLItem AMONGUS = new MLItem(
			new Settings().maxCount(1).rarity(Rarity.RARE),
			new Config("amongus").withTooltip().lootModifier(new LootModifier().chance(0.225f).rolls(1)
					.table(LootTables.SIMPLE_DUNGEON_CHEST)));

	public static final MLItem AVOCADO = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(1.25f).build())
					.rarity(Rarity.UNCOMMON),
			new Config("avocado").lootModifier(new LootModifier().chance(0.0125f).rolls(1)
					.table(Blocks.JUNGLE_LEAVES.getLootTableId())).useSound(MLSoundEvents.ITEM_AVOCADO_JINGLE)
					.withTooltip());

	public static final MLItem BANANA = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1.25f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("banana").lootModifier(new LootModifier().chance(0.0125f).rolls(3)
					.table(Blocks.JUNGLE_LEAVES.getLootTableId())).withTooltip());

	public static final MLItem BANANA_BREAD = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1.25f).build())
					.rarity(Rarity.UNCOMMON),
			new Config("banana_bread").withTooltip());

	public static final MLItem BIRCH_NUT = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(1.5f).snack().build())
					.rarity(Rarity.COMMON),
			new Config("birch_nut").lootModifier(new LootModifier().chance(0.15f).rolls(2)
					.table(Blocks.BIRCH_LEAVES.getLootTableId())).withTooltip());

	public static final MLItem BLOOD_BOTTLE = new MLItem(
			new Settings().maxCount(16).rarity(Rarity.EPIC),
			new Config("blood_bottle").withTooltip());

	public static final BouquetItem BOUQUET = new BouquetItem(
			new Settings().food(new FoodComponent.Builder().alwaysEdible().hunger(0).saturationModifier(0).build())
					.maxCount(16).rarity(Rarity.EPIC),
			new Config("bouquet").withTooltip());

	public static final ButterMilkItem BUTTERMILK = new ButterMilkItem(
			new Settings().food(new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(0.25f).build())
					.maxCount(1).rarity(Rarity.EPIC),
			new Config("buttermilk").withTooltip());

	public static final MLItem CHEESE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(1.25f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("cheese").withTooltip());

	public static final MLItem CHEESE_AND_CRACKERS = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1.25f).build())
					.rarity(Rarity.UNCOMMON),
			new Config("cheese_and_crackers").withTooltip());

	public static final MLBlockItem CHEESE_BLOCK = new MLBlockItem(
			MLBlocks.CHEESE_BLOCK,
			new Settings().rarity(Rarity.UNCOMMON),
			new Config("cheese_block").withTooltip());

	public static final MLItem CHEESE_STEAK = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(10).meat().saturationModifier(0.625f).build())
					.rarity(Rarity.UNCOMMON),
			new Config("cheese_steak").withTooltip());

	public static final MLItem CHEESY_BAKED_POTATO = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.875f).build())
					.rarity(Rarity.UNCOMMON),
			new Config("cheesy_baked_potato").withTooltip());

	public static final MLItem CHEESY_DINO_NUGGIE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(8).meat().saturationModifier(0.925f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("cheesy_dino_nuggie").withTooltip());

	public static final MLItem CHEESY_DINO_VEGGIE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.925f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("cheesy_dino_veggie").withTooltip());

	public static final MLItem CHEESY_GOOBY_NUGGIE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(9).meat().saturationModifier(0.925f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("cheesy_gooby_nuggie").withTooltip());

	public static final MLItem CHEESY_GOOBY_VEGGIE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.925f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("cheesy_gooby_veggie").withTooltip());

	public static final MLItem COOKED_BIRCH_NUT = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1.5f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("cooked_birch_nut").withTooltip());

	public static final MLItem CRACKER = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.75f).snack().build())
					.rarity(Rarity.COMMON),
			new Config("cracker").withTooltip());

	public static final MLItem DINO_NUGGIE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(7).meat().saturationModifier(0.65f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("dino_nuggie").withTooltip());

	public static final MLItem DINO_VEGGIE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.65f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("dino_veggie").withTooltip());

	public static final MLItem GOOBY_NUGGIE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(8).meat().saturationModifier(0.65f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("gooby_nuggie").withTooltip());

	public static final MLItem GOOBY_VEGGIE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.65f).snack().build())
					.rarity(Rarity.UNCOMMON),
			new Config("gooby_veggie").withTooltip());

	public static final MLItem GRILLED_CHEESE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.75f).build())
					.rarity(Rarity.UNCOMMON),
			new Config("grilled_cheese").withTooltip());

	public static final MLItem MACARONI_AND_CHEESE = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(1.125f).build())
					.rarity(Rarity.UNCOMMON),
			new Config("macaroni_and_cheese").withTooltip());

	public static final MilkBottleItem MILK_BOTTLE = new MilkBottleItem(
			new Settings().food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(1.5f).build())
					.maxCount(16).rarity(Rarity.EPIC).recipeRemainder(Items.BUCKET),
			new Config("milk_bottle").withTooltip());

	public static final MLItem MOZZARELLA_STICK = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1.5f).build())
					.rarity(Rarity.UNCOMMON),
			new Config("mozzarella_stick").withTooltip());

	public static final MLItem PASTA = new MLItem(
			new Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).snack().build())
					.rarity(Rarity.COMMON),
			new Config("pasta").withTooltip());

	public static final MLItem CAVE_CORE = new MLItem(
			new Settings().fireproof().maxCount(1).rarity(Rarity.RARE),
			new Config("cave_core").withTooltip());

	public static final MLItem HELL_CORE = new MLItem(
			new Settings().fireproof().maxCount(1).rarity(Rarity.RARE),
			new Config("hell_core").withTooltip());

	public static final MLItem LAND_CORE = new MLItem(
			new Settings().fireproof().maxCount(1).rarity(Rarity.RARE),
			new Config("land_core").withTooltip());

	public static final MLItem SEA_CORE = new MLItem(
			new Settings().fireproof().maxCount(1).rarity(Rarity.RARE),
			new Config("sea_core").withTooltip());

	public static final MLItem SKY_CORE = new MLItem(
			new Settings().fireproof().maxCount(1).rarity(Rarity.RARE),
			new Config("sky_core").withTooltip());

	public static final MLArmorSet GLASS_ARMOR = new MLArmorSet(
			new Material("glass").durability(0.0f),
			new Settings().rarity(Rarity.RARE),
			new Config("glass").disableGlint().withTooltip());

	public static void register() {
		ICON.register();
		GOOBY_ESSENCE.register();
		AMETHYST_BLOCK.register();
		AMETHYST_CLUSTER.register();
		AMONGUS.register();
		AVOCADO.register();
		BANANA.register();
		BANANA_BREAD.register();
		BIRCH_NUT.register();
		BLOOD_BOTTLE.register();
		BOUQUET.register();
		BUTTERMILK.register();
		CHEESE.register();
		CHEESE_AND_CRACKERS.register();
		CHEESE_BLOCK.register();
		CHEESE_STEAK.register();
		CHEESY_BAKED_POTATO.register();
		CHEESY_DINO_NUGGIE.register();
		CHEESY_DINO_VEGGIE.register();
		CHEESY_GOOBY_NUGGIE.register();
		CHEESY_GOOBY_VEGGIE.register();
		COOKED_BIRCH_NUT.register();
		CRACKER.register();
		DINO_NUGGIE.register();
		DINO_VEGGIE.register();
		GOOBY_NUGGIE.register();
		GOOBY_VEGGIE.register();
		GRILLED_CHEESE.register();
		MACARONI_AND_CHEESE.register();
		MILK_BOTTLE.register();
		MOZZARELLA_STICK.register();
		PASTA.register();
		CAVE_CORE.register();
		HELL_CORE.register();
		LAND_CORE.register();
		SEA_CORE.register();
		SKY_CORE.register();
		GLASS_ARMOR.register();
	}

}
