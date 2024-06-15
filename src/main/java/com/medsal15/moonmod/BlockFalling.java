package com.medsal15.moonmod;

import com.mojang.serialization.MapCodec;

import net.minecraft.world.level.block.FallingBlock;

public class BlockFalling extends FallingBlock {
    public static final MapCodec<BlockFalling> CODEC = simpleCodec(BlockFalling::new);

    public BlockFalling(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }
}
