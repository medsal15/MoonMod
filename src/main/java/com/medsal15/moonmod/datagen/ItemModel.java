package com.medsal15.moonmod.datagen;

import com.medsal15.moonmod.MoonItems;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModel extends ItemModelProvider {
    public ItemModel(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoonMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(MoonItems.LUNARITE_GEM.asItem());
    }
}
