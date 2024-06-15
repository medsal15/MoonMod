package com.medsal15.moonmod.datagen;

import com.medsal15.moonmod.Blocks;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class Language extends LanguageProvider {
    public Language(PackOutput output, String locale) {
        super(output, MoonMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        addBlock(Blocks.MOON_DUST, "Moon Dust");

        add("itemGroup.medsalmoonmod", "Moon Mod");
    }

}
