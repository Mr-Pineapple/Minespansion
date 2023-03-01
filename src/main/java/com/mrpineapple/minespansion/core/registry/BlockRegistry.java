package com.mrpineapple.minespansion.core.registry;

import com.mrpineapple.minespansion.common.blocks.QuickSand;
import com.mrpineapple.minespansion.core.Minespansion;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Minespansion.MODID);

    public static final RegistryObject<Block> QUICK_SAND = register("quick_sand", ()-> new QuickSand(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(0.25F).sound(SoundType.SAND).dynamicShape()));

    public static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier) {
        return register(id, blockSupplier, block1 -> new BlockItem(block1, new Item.Properties()));
    }

    public static <T extends Block>RegistryObject<T> register(String id, Supplier<T> blockSupplier, @Nullable Function<T, BlockItem> supplier) {
        RegistryObject<T> registryObject = BLOCK_REGISTRY.register(id, blockSupplier);
        if(supplier != null) {
            ItemRegistry.ITEM_REGISTRY.register(id, () -> supplier.apply(registryObject.get()));
        }
        return registryObject;
    }
}
