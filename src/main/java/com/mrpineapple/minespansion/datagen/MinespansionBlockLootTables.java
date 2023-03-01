package com.mrpineapple.minespansion.datagen;

import com.mrpineapple.minespansion.core.registry.BlockRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class MinespansionBlockLootTables extends BlockLootSubProvider {
    public MinespansionBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(BlockRegistry.QUICK_SAND.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCK_REGISTRY.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
