package com.medsal15.moonmod;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MoonBlocks {
    public static DeferredBlock<BlockFalling> MOON_DUST;

    public static DeferredBlock<Block> MOON_STONE;
    public static DeferredBlock<Block> MOON_COBBLE;

    public static DeferredBlock<RotatedPillarBlock> MOON_DEEPROCK;
    public static DeferredBlock<Block> MOON_DEEPCOBBLE;

    public static void register(DeferredRegister.Blocks blocks) {
        // #region Moon Dust
        MOON_DUST = blocks.register("moon_dust", () -> new BlockFalling(BlockBehaviour.Properties.of()
                .destroyTime(0.5f)
                .explosionResistance(0.5f)
                .sound(SoundType.SAND)
                .mapColor(DyeColor.LIGHT_GRAY)));

        // todo moon duststone & variants
        // #endregion Moon Dust

        // #region Moon Stone
        MOON_STONE = blocks.register("moon_stone",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
        MOON_COBBLE = blocks.register("moon_cobble",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).mapColor(DyeColor.WHITE)));
        // todo moonstone variants (bricks, smooth, button, plate, stairs)

        MOON_DEEPROCK = blocks.register("moon_deeprock",
                () -> new RotatedPillarBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).mapColor(DyeColor.LIGHT_GRAY)));
        MOON_DEEPCOBBLE = blocks.register("moon_deepcobble", () -> new Block(
                BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).mapColor(DyeColor.LIGHT_GRAY)));
        // todo deep moonrock variants (bricks, smooth, button, plate, stairs)
        // #enregion Moon Stone
    }
}
