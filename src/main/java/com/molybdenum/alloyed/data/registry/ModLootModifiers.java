package com.molybdenum.alloyed.data.registry;

import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;

public class ModLootModifiers {
    public static void register(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(id.getPath().endsWith("_leaves")){

            }
        });
    }

    public static void tryBuildLootTable(ResourceLocation id, FabricLootTableBuilder table, Block block){
        LootPool pool = LootPool.lootPool()
                .setRolls()
    }
}