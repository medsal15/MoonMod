package com.medsal15.moonmod.datagen.tags;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MoonItemTags extends ItemTagsProvider {
    public MoonItemTags(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, MoonMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull Provider pProvider) {
        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(MoonBlocks.MOON_COBBLE.asItem());
        tag(ItemTags.STONE_TOOL_MATERIALS).add(MoonBlocks.MOON_COBBLE.asItem());
    }

}
