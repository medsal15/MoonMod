package com.medsal15.moonmod.datagen;

import java.util.Set;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonItems;
import com.medsal15.moonmod.MoonMod;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

public class BlockSubLootTable extends BlockLootSubProvider {
    public BlockSubLootTable(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MoonMod.BLOCKS.getEntries()
                .stream()
                .map(Holder::value)
                .toList();
    }

    @Override
    protected void generate() {
        dropSelf(MoonBlocks.MOON_DUST.get());

        add(MoonBlocks.LUNARITE_ORE.get(), createOreDrop(MoonBlocks.LUNARITE_ORE.get(), MoonItems.LUNARITE_GEM.get()));
        add(MoonBlocks.DEEPSLATE_LUNARITE_ORE.get(),
                createOreDrop(MoonBlocks.DEEPSLATE_LUNARITE_ORE.get(), MoonItems.LUNARITE_GEM.get()));
        dropSelf(MoonBlocks.LUNARITE_BLOCK.get());
    }
}
