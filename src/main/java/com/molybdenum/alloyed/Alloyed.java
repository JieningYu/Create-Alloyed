package com.molybdenum.alloyed;

import com.molybdenum.alloyed.client.registry.ModSounds;
import com.molybdenum.alloyed.common.registry.ModBlocks;
import com.molybdenum.alloyed.common.registry.ModCompatBlocks;
import com.molybdenum.alloyed.common.registry.ModCompatItems;
import com.molybdenum.alloyed.common.registry.ModItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Alloyed implements ModInitializer {

    public static final String MOD_ID = "alloyed";
    public static final Logger LOGGER = LogManager.getLogger();

    // Compat
    public static boolean isFarmersDelightLoaded = false;
    public static boolean isCreateDecoLoaded = false;

    private static final NonNullSupplier<CreateRegistrate> REGISTRATE = CreateRegistrate.lazy(MOD_ID);

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static CreateRegistrate getRegistrate() {
        return REGISTRATE.get();
    }

    @Override
    public void onInitialize() {
        isFarmersDelightLoaded = FabricLoader.getInstance().isModLoaded("farmersdelight");
        isCreateDecoLoaded = FabricLoader.getInstance().isModLoaded("createdeco");

        ModItems.register();
        ModBlocks.register();
        ModCompatItems.register();
        ModCompatBlocks.register();
        ModSounds.register(eventBus);
    }
}
