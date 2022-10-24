package dev.jaxydog.moonlight.item;

import dev.jaxydog.moonlight.block.MoonlightBlocks;
import dev.jaxydog.moonlight.content.MoonlightSoundEvents;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Items;
import net.minecraft.item.Item.Settings;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
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

	/** Dino nuggie item */
	public static final MoonlightItem DINO_NUGGIE = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.65f).snack().meat().build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("dino_nuggie").setTooltipEnabled(true));

	/** Dino veggie item */
	public static final MoonlightItem DINO_VEGGIE = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.65f).snack().meat().build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("dino_veggie").setTooltipEnabled(true));

	/** Cheesy dino nuggie item */
	public static final MoonlightItem CHEESY_DINO_NUGGIE = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.925f).snack().meat().build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("cheesy_dino_nuggie").setTooltipEnabled(true));

	/** Cheesy dino veggie item */
	public static final MoonlightItem CHEESY_DINO_VEGGIE = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.925f).snack().meat().build())
					.rarity(Rarity.UNCOMMON),
			new Config().setName("cheesy_dino_veggie").setTooltipEnabled(true));

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

	/** Mozzarella stick item */
	public static final MoonlightItem MOZZ_STICK = new MoonlightItem(
			new Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(4.5f).build())
					.rarity(Rarity.COMMON),
			new Config().setName("mozz_stick").setTooltipEnabled(true));

	/** Blood bottle item */
	public static final MoonlightItem BLOOD_BOTTLE = new MoonlightItem(
			new Settings().maxCount(16).rarity(Rarity.EPIC),
			new Config().setName("blood_bottle").setTooltipEnabled(true));

	public static final BouquetItem BOUQUET = new BouquetItem(
			new Settings().food(new FoodComponent.Builder().hunger(0).saturationModifier(0).alwaysEdible().build())
					.maxCount(16).rarity(Rarity.EPIC),
			new Config().setName("bouquet").setTooltipEnabled(true));

	public static final MilkBottleItem MILK_BOTTLE = new MilkBottleItem(
			new Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(3).alwaysEdible().build())
					.recipeRemainder(Items.BUCKET).maxCount(1).rarity(Rarity.EPIC),
			new Config().setName("milk_bottle").setTooltipEnabled(true));

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

	public static final MoonlightBlockItem AMETHYST_BLOCK_BLACK = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_BLACK,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_black"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_BLUE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_BLUE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_blue"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_BROWN = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_BROWN,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_brown"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_CYAN = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_CYAN,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_cyan"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_GRAY = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_GRAY,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_gray"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_GREEN = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_GREEN,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_green"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_LIGHT_BLUE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_LIGHT_BLUE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_light_blue"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_LIGHT_GRAY = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_LIGHT_GRAY,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_light_gray"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_LIME = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_LIME,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_lime"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_MAGENTA = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_MAGENTA,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_magenta"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_ORANGE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_ORANGE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_orange"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_PINK = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_PINK,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_pink"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_PURPLE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_PURPLE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_purple"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_RED = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_RED,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_red"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_WHITE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_WHITE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_white"));

	public static final MoonlightBlockItem AMETHYST_BLOCK_YELLOW = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_BLOCK_YELLOW,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_block_yellow"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_BLACK = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_BLACK,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_black"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_BLUE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_BLUE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_blue"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_BROWN = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_BROWN,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_brown"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_CYAN = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_CYAN,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_cyan"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_GRAY = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_GRAY,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_gray"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_GREEN = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_GREEN,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_green"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_LIGHT_BLUE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_LIGHT_BLUE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_light_blue"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_LIGHT_GRAY = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_LIGHT_GRAY,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_light_gray"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_LIME = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_LIME,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_lime"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_MAGENTA = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_MAGENTA,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_magenta"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_ORANGE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_ORANGE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_orange"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_PINK = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_PINK,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_pink"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_PURPLE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_PURPLE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_purple"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_RED = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_RED,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_red"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_WHITE = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_WHITE,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_white"));

	public static final MoonlightBlockItem AMETHYST_CLUSTER_YELLOW = new MoonlightBlockItem(
			MoonlightBlocks.AMETHYST_CLUSTER_YELLOW,
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("amethyst_cluster_yellow"));

	/** Glass armor set */
	public static final MoonlightArmorItem[] GLASS_ARMOR = MoonlightArmorItem.createSet(
			new MoonlightArmorItem.Material().setName("glass").setDurability(0),
			new Settings().rarity(Rarity.COMMON),
			new Config().setName("glass").setGlintEnabled(false).setTooltipEnabled(true));

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
		DINO_VEGGIE.register();
		CHEESY_DINO_NUGGIE.register();
		CHEESY_DINO_VEGGIE.register();
		GRILLED_CHEESE.register();
		MACARONI_AND_CHEESE.register();
		PASTA.register();
		MOZZ_STICK.register();
		BLOOD_BOTTLE.register();
		BOUQUET.register();
		MILK_BOTTLE.register();
		LAND_CORE.register();
		SEA_CORE.register();
		SKY_CORE.register();
		CAVE_CORE.register();
		HELL_CORE.register();
		AMETHYST_BLOCK_BLACK.register();
		AMETHYST_BLOCK_BLUE.register();
		AMETHYST_BLOCK_BROWN.register();
		AMETHYST_BLOCK_CYAN.register();
		AMETHYST_BLOCK_GRAY.register();
		AMETHYST_BLOCK_GREEN.register();
		AMETHYST_BLOCK_LIGHT_BLUE.register();
		AMETHYST_BLOCK_LIGHT_GRAY.register();
		AMETHYST_BLOCK_LIME.register();
		AMETHYST_BLOCK_MAGENTA.register();
		AMETHYST_BLOCK_ORANGE.register();
		AMETHYST_BLOCK_PINK.register();
		AMETHYST_BLOCK_PURPLE.register();
		AMETHYST_BLOCK_RED.register();
		AMETHYST_BLOCK_WHITE.register();
		AMETHYST_BLOCK_YELLOW.register();
		AMETHYST_CLUSTER_BLACK.register();
		AMETHYST_CLUSTER_BLUE.register();
		AMETHYST_CLUSTER_BROWN.register();
		AMETHYST_CLUSTER_CYAN.register();
		AMETHYST_CLUSTER_GRAY.register();
		AMETHYST_CLUSTER_GREEN.register();
		AMETHYST_CLUSTER_LIGHT_BLUE.register();
		AMETHYST_CLUSTER_LIGHT_GRAY.register();
		AMETHYST_CLUSTER_LIME.register();
		AMETHYST_CLUSTER_MAGENTA.register();
		AMETHYST_CLUSTER_ORANGE.register();
		AMETHYST_CLUSTER_PINK.register();
		AMETHYST_CLUSTER_PURPLE.register();
		AMETHYST_CLUSTER_RED.register();
		AMETHYST_CLUSTER_WHITE.register();
		AMETHYST_CLUSTER_YELLOW.register();

		register(GLASS_ARMOR);

		modifyLoot(
				Blocks.JUNGLE_LEAVES.getLootTableId(),
				LootPool.builder().rolls(BinomialLootNumberProvider.create(1, 0.0125f))
						.with(ItemEntry.builder(AVOCADO)),
				LootPool.builder().rolls(BinomialLootNumberProvider.create(3, 0.0125f))
						.with(ItemEntry.builder(BANANA)));
	}
}
