package com.medsal15.moonmod.datagen;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockState extends BlockStateProvider {

    public BlockState(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MoonMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(MoonBlocks.MOON_DUST.get(),
                models().withExistingParent("moon_dust", "minecraft:block/sand")
                        .texture("all", "block/moon_dust"));
        simpleBlockWithItem(MoonBlocks.LUNARITE_ORE.get(),
                models().withExistingParent("lunarite_ore", "minecraft:block/coal_ore")
                        .texture("all", "block/lunarite_ore"));
        simpleBlockWithItem(MoonBlocks.DEEPSLATE_LUNARITE_ORE.get(),
                models().withExistingParent("deepslate_lunarite_ore", "minecraft:block/deepslate_coal_ore")
                        .texture("all", "block/deepslate_lunarite_ore"));
        simpleBlockWithItem(MoonBlocks.LUNARITE_BLOCK.get(),
                models().withExistingParent("lunarite_block", "minecraft:block/coal_block")
                        .texture("all", "block/lunarite_block"));
    }
}
