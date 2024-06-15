package com.medsal15.moonmod.datagen;

import com.medsal15.moonmod.Blocks;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockState extends BlockStateProvider {

    public BlockState(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MoonMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile dustModel = models().withExistingParent("moon_dust", "minecraft:block/sand").texture("all",
                "block/moon_dust");

        simpleBlockWithItem(Blocks.MOON_DUST.get(), dustModel);
    }

}
