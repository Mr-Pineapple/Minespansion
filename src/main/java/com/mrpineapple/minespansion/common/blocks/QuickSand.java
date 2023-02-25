package com.mrpineapple.minespansion.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class QuickSand extends FallingBlock {
    public QuickSand(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        entity.makeStuckInBlock(state, new Vec3(0.25D, (double)0.05F, 0.25D));
        entity.hurt(DamageSource.IN_WALL, 2f);
    }
}
