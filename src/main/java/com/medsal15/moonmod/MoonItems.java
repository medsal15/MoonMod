package com.medsal15.moonmod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MoonItems {
    public static DeferredItem<BlockItem> MOON_DUST;

    public static DeferredItem<BlockItem> LUNARITE_ORE;
    public static DeferredItem<BlockItem> DEEPSLATE_LUNARITE_ORE;
    public static DeferredItem<BlockItem> LUNARITE_BLOCK;
    public static DeferredItem<Item> LUNARITE_GEM;

    public static void register(DeferredRegister.Items items) {
        MOON_DUST = items.registerSimpleBlockItem("moon_dust", MoonBlocks.MOON_DUST);

        LUNARITE_ORE = items.registerSimpleBlockItem("lunarite_ore", MoonBlocks.LUNARITE_ORE);
        DEEPSLATE_LUNARITE_ORE = items.registerSimpleBlockItem("deepslate_lunarite_ore",
                MoonBlocks.DEEPSLATE_LUNARITE_ORE);
        LUNARITE_BLOCK = items.registerSimpleBlockItem("lunarite_block", MoonBlocks.LUNARITE_BLOCK);
        LUNARITE_GEM = items.registerSimpleItem("lunarite", new Item.Properties());
    }

    public static void addItems(ItemDisplayParameters parameters, Output output) {
        output.accept(MOON_DUST.get());

        output.accept(LUNARITE_ORE.get());
        output.accept(DEEPSLATE_LUNARITE_ORE.get());
        output.accept(LUNARITE_GEM.get());
        output.accept(LUNARITE_BLOCK.get());
        // todo lunarite trim
        // todo lunarite tools
    }
}
