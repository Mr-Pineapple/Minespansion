package com.mrpineapple.minespansion.datagen;

import com.mrpineapple.minespansion.core.Minespansion;
import com.mrpineapple.minespansion.core.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class MinespansionBlockStateProvider extends BlockStateProvider {
    public MinespansionBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Minespansion.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockRegistry.QUICK_SAND);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
