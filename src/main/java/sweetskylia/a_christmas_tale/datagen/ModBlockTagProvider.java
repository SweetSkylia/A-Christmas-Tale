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
                .add(ModBlocks.FROZEN_STELLAR_BLOCK);

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
                .add(ModBlocks.RED_OMORIKA_PLANKS);

    }
}
