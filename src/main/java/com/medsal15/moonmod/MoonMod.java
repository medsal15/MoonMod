package com.medsal15.moonmod;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(MoonMod.MODID)
public final class MoonMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "medsalmoonmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under
    // the "moonmod" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under
    // the "moonmod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be
    // registered under the "moonmod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a creative tab with the id "examplemod:example_tab" for the example
    // item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS
            .register("moonmod", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.medsalmoonmod"))
                    .icon(() -> MoonItems.MOON_DUST.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(MoonItems.MOON_DUST.get());
                    }).build());

    public MoonMod(IEventBus modEventBus, ModContainer modContainer) {
        // todo init config here

        // Register the Deferred Register to the mod event bus so blocks get registered
        MoonBlocks.register(BLOCKS);
        BLOCKS.register(modEventBus);

        // Register the Deferred Register to the mod event bus so items get registered
        MoonItems.register(ITEMS);
        ITEMS.register(modEventBus);

        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (MoonMod)
        // to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in
        // this class, like onServerStarting() below.
        // NeoForge.EVENT_BUS.register(MoonMod);

        // todo register config here
    }
}
