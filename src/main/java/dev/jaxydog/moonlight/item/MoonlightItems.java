package dev.jaxydog.moonlight.item;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.block.MoonlightBlocks;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item.Settings;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Rarity;

public class MoonlightItems {
	public static final MoonlightItem AVOCADO = new MoonlightItem(
			new Config().setName("avocado").setTooltipEnabled(true),
			new Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1f).snack().build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightItem BANANA = new MoonlightItem(new Config().setName("banana").setTooltipEnabled(true),
			new Settings()
					.food(new FoodComponent.Builder().hunger(2).saturationModifier(1f).snack().alwaysEdible().build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightItem CHEESE = new MoonlightItem(
			new Config().setName("cheese").setTooltipEnabled(true),
			new Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(1f).build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightItem CHEESE_AND_CRACKERS = new MoonlightItem(
			new Config().setName("cheese_and_crackers").setTooltipEnabled(true),
			new Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightBlockItem CHEESE_BLOCK = new MoonlightBlockItem(
			new Config().setName("cheese_block").setTooltipEnabled(true), MoonlightBlocks.CHEESE_BLOCK,
			new Settings().rarity(Rarity.UNCOMMON));

	public static final MoonlightItem CHEESE_STEAK = new MoonlightItem(
			new Config().setName("cheese_steak").setTooltipEnabled(true),
			new Settings().food(new FoodComponent.Builder().hunger(14).saturationModifier(1f).build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightItem CHEESY_BAKED_POTATO = new MoonlightItem(
			new Config().setName("cheesy_baked_potato").setTooltipEnabled(true),
			new Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(1f).build())
					.rarity(Rarity.COMMON));

	public static final MoonlightItem CRACKER = new MoonlightItem(
			new Config().setName("cracker").setTooltipEnabled(true),
			new Settings().maxCount(16).food(new FoodComponent.Builder().hunger(1).saturationModifier(1f).build())
					.rarity(Rarity.COMMON));

	public static final MoonlightItem GRILLED_CHEESE = new MoonlightItem(
			new Config().setName("grilled_cheese").setTooltipEnabled(true),
			new Settings().food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightItem MACARONI_AND_CHEESE = new MoonlightItem(
			new Config().setName("macaroni_and_cheese").setTooltipEnabled(true),
			new Settings().food(new FoodComponent.Builder().hunger(10).saturationModifier(1f).build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightItem PASTA = new MoonlightItem(
			new Config().setName("pasta").setTooltipEnabled(true),
			new Settings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(1f).build())
					.rarity(Rarity.COMMON));

	public static void register() {
		AVOCADO.register();
		BANANA.register();
		CHEESE.register();
		CHEESE_AND_CRACKERS.register();
		CHEESE_BLOCK.register();
		CHEESE_STEAK.register();
		CHEESY_BAKED_POTATO.register();
		CRACKER.register();
		GRILLED_CHEESE.register();
		MACARONI_AND_CHEESE.register();
		PASTA.register();
		Moonlight.LOGGER.info("Registered items");

		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
			if (!id.equals(Blocks.JUNGLE_LEAVES.getLootTableId())) {
				return;
			}

			FabricLootPoolBuilder avocado = FabricLootPoolBuilder.builder()
					.rolls(ConstantLootNumberProvider.create(0.05f))
					.with(ItemEntry.builder(AVOCADO));

			FabricLootPoolBuilder banana = FabricLootPoolBuilder.builder()
					.rolls(ConstantLootNumberProvider.create(0.0125f))
					.with(ItemEntry.builder(BANANA));

			table.pool(avocado).pool(banana);
		});
		Moonlight.LOGGER.info("Registered loot tables");
	}
}
