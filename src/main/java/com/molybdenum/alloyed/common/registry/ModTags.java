package com.molybdenum.alloyed.common.registry;

import com.molybdenum.alloyed.Alloyed;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {

    public static class Items {
        // Make sure the shears are working
        public static final ITag.INamedTag<Item> STEEL_SHEARS = createForgeTag("shears");

        // Compat for other mods' ingots
        public static final ITag.INamedTag<Item> BRONZE_INGOT = createForgeTag("ingots/bronze");
        public static final ITag.INamedTag<Item> STEEL_INGOT = createForgeTag("ingots/steel");

        // Compat for other mods' sheets/plates
        public static final ITag.INamedTag<Item> BRONZE_SHEET = createForgeTag("plates/bronze");
        public static final ITag.INamedTag<Item> STEEL_SHEET = createForgeTag("plates/steel");

        // Compat for other mods' ingot blocks
        public static final ITag.INamedTag<Item> BRONZE_BLOCK = createForgeTag("storage_blocks/bronze");
        public static final ITag.INamedTag<Item> STEEL_BLOCK = createForgeTag("storage_blocks/steel");

        // Compat for other mods' knives
        public static final ITag.INamedTag<Item> STEEL_KNIFE = createForgeTag("tools/knives");

        // Compat for Farmer's Delight's knives
        public static final ITag.INamedTag<Item> STEEL_KNIFE_FD = createSpecialTag("farmersdelight","tools/knives");

        private static ITag.INamedTag<Item> createTag(String path) {
            return ItemTags.bind(Alloyed.asResource(path).toString());
        }

        private static ITag.INamedTag<Item> createForgeTag(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> createSpecialTag(String modId, String path) {
            return ItemTags.bind(new ResourceLocation(modId, path).toString());
        }
    }

    public static class Blocks {

        // Compat for other mods' ingot blocks
        public static final ITag.INamedTag<Block> BRONZE_BLOCK = createForgeTag("storage_blocks/bronze");
        public static final ITag.INamedTag<Block> STEEL_BLOCK = createForgeTag("storage_blocks/steel");

        private static ITag.INamedTag<Block> createTag(String path) {
            return BlockTags.bind(Alloyed.asResource(path).toString());
        }

        private static ITag.INamedTag<Block> createForgeTag(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }
    }

}