package sweetskylia.a_christmas_tale.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.CandleBlock;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import sweetskylia.a_christmas_tale.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CANDY_BLOCK)
                .add(ModBlocks.STELLAR_HEART_ORE)
                .add(ModBlocks.STELLAR_BLOCK)
                .add(ModBlocks.FROZEN_STELLAR_BLOCK)

                .add(ModBlocks.WHITE_ORNAMENT)
                .add(ModBlocks.ORANGE_ORNAMENT)
                .add(ModBlocks.MAGENTA_ORNAMENT)
                .add(ModBlocks.LIGHT_BLUE_ORNAMENT)
                .add(ModBlocks.YELLOW_ORNAMENT)
                .add(ModBlocks.LIME_ORNAMENT)
                .add(ModBlocks.PINK_ORNAMENT)
                .add(ModBlocks.GRAY_ORNAMENT)
                .add(ModBlocks.LIGHT_GRAY_ORNAMENT)
                .add(ModBlocks.CYAN_ORNAMENT)
                .add(ModBlocks.PURPLE_ORNAMENT)
                .add(ModBlocks.BLUE_ORNAMENT)
                .add(ModBlocks.BROWN_ORNAMENT)
                .add(ModBlocks.GREEN_ORNAMENT)
                .add(ModBlocks.RED_ORNAMENT)
                .add(ModBlocks.BLACK_ORNAMENT);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CANDY_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.STELLAR_HEART_ORE)
                .add(ModBlocks.STELLAR_BLOCK)
                .add(ModBlocks.FROZEN_STELLAR_BLOCK);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.RED_OMORIKA_LOG)
                .add(ModBlocks.RED_OMORIKA_WOOD)
                .add(ModBlocks.STRIPPED_RED_OMORIKA_LOG)
                .add(ModBlocks.STRIPPED_RED_OMORIKA_WOOD)
                .add(ModBlocks.RED_OMORIKA_PLANKS)
                .add(ModBlocks.RED_OMORIKA_SLAB)
                .add(ModBlocks.RED_OMORIKA_STAIRS)

                .add(ModBlocks.SHIROMORIKA_LOG)
                .add(ModBlocks.SHIROMORIKA_WOOD)
                .add(ModBlocks.STRIPPED_SHIROMORIKA_LOG)
                .add(ModBlocks.STRIPPED_SHIROMORIKA_WOOD)
                .add(ModBlocks.SHIROMORIKA_PLANKS)
                .add(ModBlocks.SHIROMORIKA_SLAB)
                .add(ModBlocks.SHIROMORIKA_STAIRS);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.RED_OMORIKA_FENCE)
                .add(ModBlocks.SHIROMORIKA_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.RED_OMORIKA_FENCE_GATE)
                .add(ModBlocks.SHIROMORIKA_FENCE_GATE);
    }
}
