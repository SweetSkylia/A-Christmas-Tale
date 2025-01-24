package sweetskylia.a_christmas_tale.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Orientation;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.block.ModBlocks;
import sweetskylia.a_christmas_tale.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CANDY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STELLAR_HEART_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STELLAR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROZEN_STELLAR_BLOCK);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHRISTMAS_WOOL);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WINTER_WOOL);
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.CHRISTMAS_WOOL,ModBlocks.CHRISTMAS_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.WINTER_WOOL,ModBlocks.WINTER_CARPET);




    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.STELLAR_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROZEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CANDY, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOT_CHOCOLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOWFLAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROZEN_STELLAR_HEART, Models.GENERATED);
    }


}
