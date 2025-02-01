package sweetskylia.a_christmas_tale.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import sweetskylia.a_christmas_tale.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.RED_OMORIKA_LOG.asItem())
                .add(ModBlocks.RED_OMORIKA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_RED_OMORIKA_LOG.asItem())
                .add(ModBlocks.STRIPPED_RED_OMORIKA_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.RED_OMORIKA_PLANKS.asItem());
    }
}
