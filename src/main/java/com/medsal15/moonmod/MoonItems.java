package com.medsal15.moonmod;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MoonItems {
    public static DeferredItem<BlockItem> MOON_DUST;
    public static DeferredItem<BlockItem> MOON_STONE;
    public static DeferredItem<BlockItem> MOON_COBBLE;

    public static void register(DeferredRegister.Items items) {
        MOON_DUST = items.registerSimpleBlockItem("moon_dust", MoonBlocks.MOON_DUST);
        MOON_STONE = items.registerSimpleBlockItem("moon_stone", MoonBlocks.MOON_STONE);
        MOON_COBBLE = items.registerSimpleBlockItem("moon_cobble", MoonBlocks.MOON_COBBLE);
    }
}
