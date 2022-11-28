package dev.jaxydog.moonlight.block.unique;

import dev.jaxydog.moonlight.utility.Registerable;
import net.minecraft.block.CakeBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.block.MLBlock.Config;

public class MLCakeBlock extends CakeBlock implements Registerable {

    public MLCakeBlock(Settings settings, Config config) {
        super(settings);
        _CONFIG = config;
    }

    protected final Config _CONFIG;

    @Override
    public Identifier getId() {
        return Moonlight.id(_CONFIG.getName());
    }

    @Override
    public MLCakeBlock register() {
        return Registry.register(Registry.BLOCK, getId(), this);
    }
}
