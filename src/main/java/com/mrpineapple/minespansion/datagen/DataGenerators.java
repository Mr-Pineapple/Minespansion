package com.mrpineapple.minespansion.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

public class DataGenerators {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new MinespansionRecipeProvider(packOutput));
        generator.addProvider(true, MinespansionLootTableProvider.create(packOutput));
        generator.addProvider(true, new MinespansionBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new MinespansionItemModelProvider(packOutput, existingFileHelper));

    }
}
