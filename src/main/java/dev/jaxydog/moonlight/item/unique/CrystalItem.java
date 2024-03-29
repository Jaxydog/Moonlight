package dev.jaxydog.moonlight.item.unique;

import dev.jaxydog.moonlight.data.AxolotlEmotion;
import dev.jaxydog.moonlight.item.MLItem;
import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class CrystalItem extends MLItem implements Emotional {

	public static final DamageSource BOTTLE_UP = new DamageSource("axolotlBottleUp")
		.setBypassesArmor()
		.setBypassesProtection()
		.setUnblockable()
		.setUsesMagic();
	public static final String CRAFT_COMMAND = "function moonlight:icarus/crystal";

	public CrystalItem(Settings settings, Config config) {
		super(settings, config);
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);

		tooltip.add(Text.empty());
		tooltip.add(this.getEmotionTooltip(stack));
	}

	@Override
	public ItemStack getDefaultStack() {
		var stack = super.getDefaultStack();

		Emotional.setEmotion(stack, AxolotlEmotion.NEUTRAL);

		return stack;
	}

	@Override
	public Text getName(ItemStack stack) {
		var emotion = Text.translatable(Emotional.getEmotion(stack).getTranslationKey());

		return Text.translatable(this.getTranslationKey()).append(" ").append(emotion);
	}

	@Override
	public void onCraft(ItemStack stack, World world, PlayerEntity player) {
		var server = player.world.getServer();

		if (server != null) {
			var source = player.getCommandSource().withSilent();

			server.getCommandManager().executeWithPrefix(source, CRAFT_COMMAND);
		}

		// for some reason this method takes *hearts*, not actual hp,
		// so we divide by 4 to get half of the player's health

		player.damage(BOTTLE_UP, player.getMaxHealth() / 4.0f);

		super.onCraft(stack, world, player);
	}
}
