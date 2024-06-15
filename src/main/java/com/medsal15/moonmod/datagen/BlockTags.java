package com.medsal15.moonmod.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

import com.medsal15.moonmod.Blocks;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MoonMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull Provider pProvider) {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL).add(Blocks.MOON_DUST.get());
    }
}
