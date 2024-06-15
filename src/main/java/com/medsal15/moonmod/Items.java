package com.medsal15.moonmod;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {
    public static DeferredItem<BlockItem> MOON_DUST;

    public static void register(DeferredRegister.Items items) {
        MOON_DUST = items.registerSimpleBlockItem("moon_dust", Blocks.MOON_DUST);
    }
}
