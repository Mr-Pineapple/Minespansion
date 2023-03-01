package com.mrpineapple.minespansion.core;

import com.mrpineapple.minespansion.core.registry.BlockRegistry;
import com.mrpineapple.minespansion.core.registry.ItemRegistry;
import com.mrpineapple.minespansion.datagen.DataGenerators;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Minespansion.MODID)
public class Minespansion {
    public static final String MODID = "minespansion";

    public Minespansion() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(DataGenerators::gatherData);
        ItemRegistry.ITEM_REGISTRY.register(eventBus);
        BlockRegistry.BLOCK_REGISTRY.register(eventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

}
