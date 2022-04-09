package dev.jaxydog.moonlight.item;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.block.MoonlightBlocks;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Rarity;

public class MoonlightItems {
	public static final MoonlightItem AVOCADO = new MoonlightItem(
			new Config()
					.setName("avocado")
					.setTooltipEnabled(true),
			new Settings()
					.food(new FoodComponent.Builder()
							.hunger(2)
							.saturationModifier(2)
							.snack()
							.build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightItem BANANA = new MoonlightItem(
			new Config()
					.setName("banana")
					.setTooltipEnabled(true),
			new Settings()
					.food(new FoodComponent.Builder()
							.hunger(2)
							.saturationModifier(1.5f)
							.snack()
							.alwaysEdible()
							.build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightItem CHEESE = new MoonlightItem(
			new Config()
					.setName("cheese")
					.setTooltipEnabled(true),
			new Settings()
					.food(new FoodComponent.Builder()
							.hunger(2)
							.saturationModifier(2f)
							.build())
					.rarity(Rarity.UNCOMMON));

	public static final MoonlightBlockItem CHEESE_BLOCK = new MoonlightBlockItem(
			new Config()
					.setName("cheese_block")
					.setTooltipEnabled(true),
			MoonlightBlocks.CHEESE_BLOCK,
			new Settings()
					.rarity(Rarity.UNCOMMON));

	public static void register() {
		AVOCADO.register();
		BANANA.register();
		CHEESE.register();
		CHEESE_BLOCK.register();
		Moonlight.LOGGER.info("Registered items");
	}
}
