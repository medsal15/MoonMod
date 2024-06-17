package com.medsal15.moonmod.datagen;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class Language extends LanguageProvider {
    public Language(PackOutput output, String locale) {
        super(output, MoonMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        addBlock(MoonBlocks.MOON_DUST, "Moon Dust");

        addBlock(MoonBlocks.MOON_STONE, "Moonstone");
        addBlock(MoonBlocks.MOON_COBBLE, "Cobbled Moonstone");

        addBlock(MoonBlocks.MOON_DEEPROCK, "Deep Moonrock");
        addBlock(MoonBlocks.MOON_DEEPCOBBLE, "Cobbled Moonrock");

        add("itemGroup.medsalmoonmod", "Moon Mod");
    }

}
