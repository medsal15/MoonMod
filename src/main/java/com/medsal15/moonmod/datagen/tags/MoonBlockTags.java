package com.medsal15.moonmod.datagen.tags;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MoonBlockTags extends BlockTagsProvider {
    public static TagKey<Block> LUNARITE_ORES = BlockTags
            .create(ResourceLocation.fromNamespaceAndPath("c", "ores/lunarite"));
    public static TagKey<Block> LUNARITE_STORAGE_BLOCKS = BlockTags
            .create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/lunarite"));

    public MoonBlockTags(PackOutput output, CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MoonMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_SHOVEL).replace(false)
                .add(MoonBlocks.MOON_DUST.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).replace(false)
                .add(
                        MoonBlocks.LUNARITE_ORE.get(),
                        MoonBlocks.DEEPSLATE_LUNARITE_ORE.get(),
                        MoonBlocks.LUNARITE_BLOCK.get());

        tag(LUNARITE_ORES).add(MoonBlocks.LUNARITE_ORE.get(), MoonBlocks.DEEPSLATE_LUNARITE_ORE.get());
        tag(LUNARITE_STORAGE_BLOCKS).add(MoonBlocks.LUNARITE_BLOCK.get());

        tag(Tags.Blocks.ORES).replace(false)
                .addTag(LUNARITE_ORES);
        tag(Tags.Blocks.STORAGE_BLOCKS).replace(false)
                .addTag(LUNARITE_STORAGE_BLOCKS);
    }
}
