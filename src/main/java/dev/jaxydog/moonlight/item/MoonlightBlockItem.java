package dev.jaxydog.moonlight.item;

import java.util.List;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

/** Block item wrapper class */
public class MoonlightBlockItem extends BlockItem {
	private final Config CONFIG;

	public MoonlightBlockItem(Block block, Settings settings, Config config) {
		super(block, settings);
		CONFIG = config;
	}

	/** Returns the block item's identifier */
	public Identifier getId() {
		return Moonlight.id(CONFIG.getName());
	}

	/** Registers the block item */
	public MoonlightBlockItem register() {
		return Registry.register(Registry.ITEM, this.getId(), this);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return CONFIG.isGlintEnabled() && (CONFIG.isGlintForced() || super.hasGlint(stack));
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
}
