package com.molybdenum.alloyed.data.registry;

import com.molybdenum.alloyed.Alloyed;
import com.molybdenum.alloyed.common.loot.SteelShearsModifier;
import com.molybdenum.alloyed.common.registry.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ModLootModifiers extends GlobalLootModifierProvider {

    public ModLootModifiers(DataGenerator gen) {
        super(gen, Alloyed.MOD_ID);
    }

    public static void register(DataGenerator generator) {
        generator.addProvider(new ModLootModifiers(generator));
    }

    @Override
    protected void start() {
        for (AllModifiers modifier : AllModifiers.values()) {
            add(
                    modifier.getSerializedName(),
                    modifier.serializer,
                    new SteelShearsModifier(new LootItemCondition[] {
                            MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModItems.STEEL_SHEARS.get())).build(),
                           LootItemBlockStatePropertyCondition.hasBlockStateProperties(modifier.getBlock()).build()
                    }, modifier.getBlock().asItem())
                    );
        }
    }

    public enum AllModifiers implements StringRepresentable {
        ACACIA_LEAVES          (Blocks.ACACIA_LEAVES),
        BIRCH_LEAVES           (Blocks.BIRCH_LEAVES),
        COBWEB                 (Blocks.COBWEB),
        DARK_OAK_LEAVES        (Blocks.DARK_OAK_LEAVES),
        DEAD_BUSH              (Blocks.DEAD_BUSH),
        FERN                   (Blocks.FERN),
        JUNGLE_LEAVES          (Blocks.JUNGLE_LEAVES),
        LARGE_FERN             (Blocks.LARGE_FERN),
        NETHER_SPROUTS         (Blocks.NETHER_SPROUTS),
        OAK_LEAVES             (Blocks.OAK_LEAVES),
        SEAGRASS               (Blocks.SEAGRASS),
        SPRUCE_LEAVES          (Blocks.SPRUCE_LEAVES),
        TALL_GRASS             (Blocks.TALL_GRASS),
        TALL_SEAGRASS          (Blocks.TALL_SEAGRASS),
        TWISTING_VINES         (Blocks.TWISTING_VINES),
        VINE                   (Blocks.VINE),
        WEEPING_VINES          (Blocks.WEEPING_VINES),
        AZALEA_LEAVES          (Blocks.AZALEA_LEAVES),
        FLOWERING_AZALEA_LEAVES(Blocks.FLOWERING_AZALEA_LEAVES),
        GLOW_LICHEN            (Blocks.GLOW_LICHEN);

        private final String location;
        private final Block block;
        private final GlobalLootModifierSerializer<SteelShearsModifier> serializer;

        AllModifiers(Block block) {
            this.location = Objects.requireNonNull(block.getRegistryName()).getPath() + "_shears";
            this.block = block;
            this.serializer = new SteelShearsModifier.Serializer().setRegistryName(Alloyed.asResource(this.location));
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.location;
        }

        public Block getBlock() {
            return this.block;
        }

        public GlobalLootModifierSerializer<SteelShearsModifier> getSerializer() { return this.serializer; }
    }
}
