package com.medsal15.moonmod.datagen.tags;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonItems;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MoonItemTags extends ItemTagsProvider {
    public static TagKey<Item> LUNARITE_ORES = ItemTags
            .create(ResourceLocation.fromNamespaceAndPath("c", "ores/lunarite"));
    public static TagKey<Item> LUNARITE_STORAGE_BLOCKS = ItemTags
            .create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/lunarite"));
    public static TagKey<Item> LUNARITE_GEMS = ItemTags
            .create(ResourceLocation.fromNamespaceAndPath("c", "gems/lunarite"));

    public MoonItemTags(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, MoonMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull Provider pProvider) {
        tag(ItemTags.BEACON_PAYMENT_ITEMS).replace(false)
                .add(MoonItems.LUNARITE_GEM.get());

        tag(LUNARITE_ORES).add(MoonBlocks.LUNARITE_ORE.asItem(), MoonBlocks.DEEPSLATE_LUNARITE_ORE.asItem());
        tag(LUNARITE_STORAGE_BLOCKS).add(MoonBlocks.LUNARITE_BLOCK.asItem());
        tag(LUNARITE_GEMS).add(MoonItems.LUNARITE_GEM.asItem());

        tag(Tags.Items.ORES).replace(false).addTag(LUNARITE_ORES);
        tag(Tags.Items.STORAGE_BLOCKS).replace(false).addTag(LUNARITE_STORAGE_BLOCKS);
        tag(Tags.Items.GEMS).replace(false).addTag(LUNARITE_GEMS);
    }

}
