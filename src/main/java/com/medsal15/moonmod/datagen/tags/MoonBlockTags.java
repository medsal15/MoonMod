package com.medsal15.moonmod.datagen.tags;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MoonBlockTags extends BlockTagsProvider {
    public MoonBlockTags(PackOutput output, CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MoonMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(MoonBlocks.MOON_DUST.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(MoonBlocks.MOON_STONE.get(), MoonBlocks.MOON_COBBLE.get(),
                MoonBlocks.MOON_DEEPROCK.get(), MoonBlocks.MOON_DEEPCOBBLE.get());

        tag(BlockTags.STONE_ORE_REPLACEABLES).add(MoonBlocks.MOON_STONE.get(), MoonBlocks.MOON_DEEPROCK.get());
    }
}
