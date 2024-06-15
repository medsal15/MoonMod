package com.medsal15.moonmod;

import java.util.Collections;
import java.util.List;

import com.medsal15.moonmod.datagen.BlockState;
import com.medsal15.moonmod.datagen.BlockSubLootTable;
import com.medsal15.moonmod.datagen.BlockTags;
import com.medsal15.moonmod.datagen.ItemModel;
import com.medsal15.moonmod.datagen.Language;

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

        generator.addProvider(event.includeClient(), new BlockState(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModel(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new Language(output, "en_us"));
        generator.addProvider(event.includeServer(),
                new BlockTags(output, event.getLookupProvider(), existingFileHelper));
        // todo ask why it gives an error on the discord
        generator.addProvider(event.includeServer(),
                new LootTableProvider(output, Collections.emptySet(), List
                        .of(new LootTableProvider.SubProviderEntry(
                                BlockSubLootTable::new, LootContextParamSets.EMPTY)),
                        event.getLookupProvider()));

    }
}
