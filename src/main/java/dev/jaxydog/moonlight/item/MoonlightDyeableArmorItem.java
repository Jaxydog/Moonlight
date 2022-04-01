package dev.jaxydog.moonlight.item;

import java.util.List;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MoonlightArmorItem.Material;
import dev.jaxydog.moonlight.item.MoonlightItem.Config;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MoonlightDyeableArmorItem extends DyeableArmorItem {
	private final Config CONFIG;

	public MoonlightDyeableArmorItem(Config config, Material material, EquipmentSlot slot, Settings settings) {
		super(material.setName(config.getName()), slot, settings.group(Config.DEFAULT_GROUP));
		this.CONFIG = config;
	}

	public Identifier Id() {
		return Moonlight.Id(CONFIG.getName());
	}

	public MoonlightDyeableArmorItem register() {
		ColorProviderRegistry.ITEM.register((stack, index) -> index == 0 ? this.getColor(stack) : 0xffffff, this);
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
}
