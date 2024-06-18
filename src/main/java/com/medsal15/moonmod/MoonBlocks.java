package com.medsal15.moonmod;

import com.medsal15.moonmod.blocks.BlockFalling;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MoonBlocks {
    public static DeferredBlock<BlockFalling> MOON_DUST;

    public static DeferredBlock<Block> LUNARITE_ORE;
    public static DeferredBlock<Block> DEEPSLATE_LUNARITE_ORE;
    public static DeferredBlock<Block> LUNARITE_BLOCK;

    public static void register(DeferredRegister.Blocks blocks) {
        // #region Moon Dust
        MOON_DUST = blocks.register("moon_dust", () -> new BlockFalling(BlockBehaviour.Properties.of()
                .destroyTime(0.5f)
                .explosionResistance(0.5f)
                .sound(SoundType.SAND)
                .mapColor(DyeColor.LIGHT_GRAY)));

        // todo moon duststone & variants
        // #endregion Moon Dust

        // #region Lunarite
        LUNARITE_ORE = blocks.register("lunarite_ore",
                () -> new DropExperienceBlock(UniformInt.of(1, 3),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE).mapColor(DyeColor.YELLOW)));
        DEEPSLATE_LUNARITE_ORE = blocks.register("deepslate_lunarite_ore",
                () -> new DropExperienceBlock(UniformInt.of(1, 3),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COAL_ORE).mapColor(DyeColor.YELLOW)));
        LUNARITE_BLOCK = blocks.register("lunarite_block",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)
                        .mapColor(DyeColor.YELLOW)));
        // todo decorative variants
        // #endregion Lunarite
    }
}
