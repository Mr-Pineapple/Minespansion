package com.mrpineapple.minespansion.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class QuickSand extends FallingBlock {
    private static final VoxelShape FALLING_COLLISION_SHAPE = Shapes.box(0.0D, 0.0D, 0.0D, 1.0D, (double)0.9F, 1.0D);
    public QuickSand(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean skipRendering(BlockState state1, BlockState state2, Direction direction) {
        return state2.is(this) ? true : super.skipRendering(state1, state2, direction);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState p_60578_, BlockGetter p_60579_, BlockPos p_60580_) {
        return Shapes.empty();
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        entity.makeStuckInBlock(state, new Vec3((double)0.9F, 1.0D, (double)0.9F));
        entity.hurt(DamageSource.IN_WALL, 1.5f);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if(context instanceof EntityCollisionContext entityCollisionContext) {
            Entity entity = entityCollisionContext.getEntity();
            if(entity != null) {
                if(entity.fallDistance > 2.5F) {
                    return FALLING_COLLISION_SHAPE;
                }

                boolean flag = entity instanceof FallingBlockEntity;
                if(flag && context.isAbove(Shapes.block(), pos, false) && !context.isDescending()) {
                    return super.getCollisionShape(state, getter, pos, context);
                }
            }
        }
        return Shapes.empty();
    }

    public VoxelShape getVisualShape(BlockState p_154276_, BlockGetter p_154277_, BlockPos p_154278_, CollisionContext p_154279_) {
        return Shapes.empty();
    }



}
