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
                models().withExistingParent("moon_dust", "minecraft:block/sand").texture("all",
                        "block/moon_dust"));
        simpleBlockWithItem(MoonBlocks.MOON_STONE.get(),
                models().withExistingParent("moon_stone", "minecraft:block/stone").texture("all",
                        "block/moon_stone"));
        simpleBlockWithItem(MoonBlocks.MOON_COBBLE.get(),
                models().withExistingParent("moon_cobble", "minecraft:block/cobblestone").texture("all",
                        "block/moon_cobble"));
    }

}
