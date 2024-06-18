package com.medsal15.moonmod;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MoonBlocks {
    public static DeferredBlock<BlockFalling> MOON_DUST;

    public static void register(DeferredRegister.Blocks blocks) {
        // #region Moon Dust
        MOON_DUST = blocks.register("moon_dust", () -> new BlockFalling(BlockBehaviour.Properties.of()
                .destroyTime(0.5f)
                .explosionResistance(0.5f)
                .sound(SoundType.SAND)
                .mapColor(DyeColor.LIGHT_GRAY)));

        // todo moon duststone & variants
        // #endregion Moon Dust
    }
}
