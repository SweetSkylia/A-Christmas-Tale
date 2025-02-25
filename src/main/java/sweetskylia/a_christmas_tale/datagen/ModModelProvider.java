package sweetskylia.a_christmas_tale.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
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
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.CHRISTMAS_WOOL,ModBlocks.CHRISTMAS_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.WINTER_WOOL,ModBlocks.WINTER_CARPET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PRESENT_BLOCK);

        //WOOD SET ========================================================================
        blockStateModelGenerator.registerLog(ModBlocks.RED_OMORIKA_LOG).log(ModBlocks.RED_OMORIKA_LOG).wood(ModBlocks.RED_OMORIKA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_RED_OMORIKA_LOG).log(ModBlocks.STRIPPED_RED_OMORIKA_LOG).wood(ModBlocks.STRIPPED_RED_OMORIKA_WOOD);
        BlockStateModelGenerator.BlockTexturePool redOmorikaPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_OMORIKA_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.RED_OMORIKA_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.RED_OMORIKA_SAPLING,BlockStateModelGenerator.TintType.NOT_TINTED, TextureMap.cross(ModBlocks.RED_OMORIKA_SAPLING));
        redOmorikaPlanksPool.stairs(ModBlocks.RED_OMORIKA_STAIRS);
        redOmorikaPlanksPool.slab(ModBlocks.RED_OMORIKA_SLAB);
        redOmorikaPlanksPool.button(ModBlocks.RED_OMORIKA_BUTTON);
        redOmorikaPlanksPool.pressurePlate(ModBlocks.RED_OMORIKA_PRESSURE_PLATE);
        redOmorikaPlanksPool.fence(ModBlocks.RED_OMORIKA_FENCE);
        redOmorikaPlanksPool.fenceGate(ModBlocks.RED_OMORIKA_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.RED_OMORIKA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RED_OMORIKA_TRAPDOOR);



        blockStateModelGenerator.registerLog(ModBlocks.SHIROMORIKA_LOG).log(ModBlocks.SHIROMORIKA_LOG).wood(ModBlocks.SHIROMORIKA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SHIROMORIKA_LOG).log(ModBlocks.STRIPPED_SHIROMORIKA_LOG).wood(ModBlocks.STRIPPED_SHIROMORIKA_WOOD);
        BlockStateModelGenerator.BlockTexturePool shiromorikaPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHIROMORIKA_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.SHIROMORIKA_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.SHIROMORIKA_SAPLING,BlockStateModelGenerator.TintType.NOT_TINTED, TextureMap.cross(ModBlocks.SHIROMORIKA_SAPLING));
        shiromorikaPlanksPool.stairs(ModBlocks.SHIROMORIKA_STAIRS);
        shiromorikaPlanksPool.slab(ModBlocks.SHIROMORIKA_SLAB);
        shiromorikaPlanksPool.button(ModBlocks.SHIROMORIKA_BUTTON);
        shiromorikaPlanksPool.pressurePlate(ModBlocks.SHIROMORIKA_PRESSURE_PLATE);
        shiromorikaPlanksPool.fence(ModBlocks.SHIROMORIKA_FENCE);
        shiromorikaPlanksPool.fenceGate(ModBlocks.SHIROMORIKA_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.SHIROMORIKA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SHIROMORIKA_TRAPDOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.STELLAR_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROZEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CANDY, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOT_CHOCOLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOWFLAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROZEN_STELLAR_HEART, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PRESENT_BLOCK.asItem(), Models.GENERATED);

    }


}
