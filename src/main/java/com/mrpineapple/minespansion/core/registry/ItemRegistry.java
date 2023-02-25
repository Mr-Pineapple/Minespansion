package com.mrpineapple.minespansion.core.registry;

import com.mrpineapple.minespansion.core.Minespansion;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Minespansion.MODID);

}
