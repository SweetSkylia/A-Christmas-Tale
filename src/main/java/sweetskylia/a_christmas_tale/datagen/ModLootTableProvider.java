package sweetskylia.a_christmas_tale.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import sweetskylia.a_christmas_tale.block.ModBlocks;
import sweetskylia.a_christmas_tale.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CANDY_BLOCK);
        addDrop(ModBlocks.STELLAR_BLOCK);
        addDrop(ModBlocks.FROZEN_STELLAR_BLOCK);
        addDrop(ModBlocks.CHRISTMAS_CARPET);
        addDrop(ModBlocks.WINTER_CARPET);
        addDrop(ModBlocks.STELLAR_HEART_ORE, multipleDrops(ModBlocks.STELLAR_HEART_ORE,ModItems.STELLAR_HEART,1,3));

        addDrop(ModBlocks.RED_OMORIKA_LOG);
        addDrop(ModBlocks.RED_OMORIKA_WOOD);
        addDrop(ModBlocks.STRIPPED_RED_OMORIKA_LOG);
        addDrop(ModBlocks.STRIPPED_RED_OMORIKA_WOOD);
        addDrop(ModBlocks.RED_OMORIKA_PLANKS);
        addDrop(ModBlocks.RED_OMORIKA_SAPLING);

        addDrop(ModBlocks.RED_OMORIKA_LEAVES, leavesDrops(ModBlocks.RED_OMORIKA_LEAVES, ModBlocks.RED_OMORIKA_SAPLING, 0.0625f));
    }



    //Permet de gérer les drops multiple d'un block
    public LootTable.Builder multipleDrops(Block drop, Item item, float minDrops, float maxDrops){
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops,maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
