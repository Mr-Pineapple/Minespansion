package com.mrpineapple.minespansion.datagen;

import com.mrpineapple.minespansion.core.Minespansion;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MinespansionItemModelProvider extends ItemModelProvider  {
    public MinespansionItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Minespansion.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
