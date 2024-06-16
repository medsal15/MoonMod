package com.medsal15.moonmod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.medsal15.moonmod.datagen.BlockState;
import com.medsal15.moonmod.datagen.BlockSubLootTable;
import com.medsal15.moonmod.datagen.tags.MoonBlockTags;
import com.medsal15.moonmod.datagen.tags.MoonItemTags;
import com.medsal15.moonmod.datagen.ItemModel;
import com.medsal15.moonmod.datagen.Language;
import com.medsal15.moonmod.datagen.MoonRecipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = MoonMod.MODID)
public class DatagenHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        MoonBlockTags blockTags = new MoonBlockTags(output, lookupProvider, existingFileHelper);

        // Client-side
        generator.addProvider(event.includeClient(), new BlockState(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModel(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new Language(output, "en_us"));

        // Tags
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(),
                new MoonItemTags(output, lookupProvider, blockTags.contentsGetter(), existingFileHelper));

        // Loot
        generator.addProvider(event.includeServer(),
                new LootTableProvider(output, Collections.emptySet(), List
                        .of(new LootTableProvider.SubProviderEntry(
                                BlockSubLootTable::new, LootContextParamSets.BLOCK)),
                        lookupProvider));

        // Recipes
        generator.addProvider(event.includeServer(), new MoonRecipes(output, lookupProvider));
    }
}
