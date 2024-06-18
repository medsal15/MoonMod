package com.medsal15.moonmod.datagen;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonItems;
import com.medsal15.moonmod.MoonMod;
import com.medsal15.moonmod.datagen.tags.MoonItemTags;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class Language extends LanguageProvider {
    public Language(PackOutput output, String locale) {
        super(output, MoonMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        addBlock(MoonBlocks.MOON_DUST, "Moon Dust");

        addBlock(MoonBlocks.LUNARITE_ORE, "Lunarite Ore");
        addBlock(MoonBlocks.DEEPSLATE_LUNARITE_ORE, "Deepslate Lunarite Ore");
        addBlock(MoonBlocks.LUNARITE_BLOCK, "Lunarite Block");

        addItem(MoonItems.LUNARITE_GEM, "Lunarite");

        addTag(() -> MoonItemTags.LUNARITE_GEMS, "Lunarite Gems");
        addTag(() -> MoonItemTags.LUNARITE_ORES, "Lunarite Ores");
        addTag(() -> MoonItemTags.LUNARITE_STORAGE_BLOCKS, "Lunarite Storage Blocks");

        add("itemGroup.medsalmoonmod", "Moon Mod");
    }

}
