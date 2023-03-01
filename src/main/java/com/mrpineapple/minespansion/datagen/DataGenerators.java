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

        generator.addProvider(false, new MinespansionRecipeProvider(packOutput));
        generator.addProvider(false, MinespansionLootTableProvider.create(packOutput));
        generator.addProvider(false, new MinespansionBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(false, new MinespansionItemModelProvider(packOutput, existingFileHelper));

    }
}
