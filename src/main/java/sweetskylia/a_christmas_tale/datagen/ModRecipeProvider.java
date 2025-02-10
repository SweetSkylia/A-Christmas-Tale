package sweetskylia.a_christmas_tale.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.block.ModBlocks;
import sweetskylia.a_christmas_tale.item.ModItems;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> STELLAR_HEART_SMELTABLES = List.of(ModBlocks.STELLAR_HEART_ORE, ModItems.FROZEN_STELLAR_HEART);

        //Stellar Heart Ore Smelting
        offerSmelting(exporter, STELLAR_HEART_SMELTABLES, RecipeCategory.MISC, ModItems.STELLAR_HEART, 0.25f, 200, "stellar_heart");
        offerBlasting(exporter, STELLAR_HEART_SMELTABLES, RecipeCategory.MISC, ModItems.STELLAR_HEART, 0.25f, 100, "stellar_heart");

        //Stellar Block
        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC, ModItems.STELLAR_HEART,RecipeCategory.BUILDING_BLOCKS, ModBlocks.STELLAR_BLOCK);
        //Frozen Stellar Block
        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC, ModItems.FROZEN_STELLAR_HEART,RecipeCategory.BUILDING_BLOCKS, ModBlocks.FROZEN_STELLAR_BLOCK);

        //Winter Carpet
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.WINTER_CARPET, 3)
                .pattern("WW")
                .input('W', ModBlocks.WINTER_WOOL)
                .criterion(hasItem(ModBlocks.WINTER_WOOL), conditionsFromItem(ModBlocks.WINTER_WOOL))
                .offerTo(exporter);
        //Christmas Carpet
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.CHRISTMAS_CARPET, 3)
                .pattern("WW")
                .input('W', ModBlocks.CHRISTMAS_WOOL)
                .criterion(hasItem(ModBlocks.CHRISTMAS_WOOL), conditionsFromItem(ModBlocks.CHRISTMAS_WOOL))
                .offerTo(exporter);

        //Christmas Wool
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHRISTMAS_WOOL, 8)
                .pattern("WWW")
                .pattern("WHW")
                .pattern("WWW")
                .input('W', Ingredient.fromTag(ItemTags.WOOL))
                .input('H', ModItems.STELLAR_HEART)
                .criterion(hasItem(ModItems.STELLAR_HEART), conditionsFromItem(ModItems.STELLAR_HEART))
                .offerTo(exporter);

        //Wintel Wool
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WINTER_WOOL, 8)
                .pattern("WWW")
                .pattern("WHW")
                .pattern("WWW")
                .input('W', Ingredient.fromTag(ItemTags.WOOL))
                .input('H', ModItems.FROZEN_STELLAR_HEART)
                .criterion(hasItem(ModItems.FROZEN_STELLAR_HEART), conditionsFromItem(ModItems.FROZEN_STELLAR_HEART))
                .offerTo(exporter);

        //WOOD RECIPES ======================================
        registerPlankRecipes(exporter); //logs to planks
        registerWoodRecipes(exporter); //logs to wood

        createDoorRecipe(ModBlocks.RED_OMORIKA_DOOR, Ingredient.ofItems(ModBlocks.RED_OMORIKA_PLANKS))
                .criterion(hasItem(ModBlocks.RED_OMORIKA_PLANKS), conditionsFromItem(ModBlocks.RED_OMORIKA_PLANKS))
                .offerTo(exporter);
        createDoorRecipe(ModBlocks.SHIROMORIKA_DOOR, Ingredient.ofItems(ModBlocks.SHIROMORIKA_PLANKS))
                .criterion(hasItem(ModBlocks.SHIROMORIKA_PLANKS), conditionsFromItem(ModBlocks.SHIROMORIKA_PLANKS))
                .offerTo(exporter);

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_OMORIKA_SLAB, ModBlocks.RED_OMORIKA_PLANKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIROMORIKA_SLAB, ModBlocks.SHIROMORIKA_PLANKS);

        createStairsRecipe(ModBlocks.RED_OMORIKA_STAIRS, Ingredient.ofItems(ModBlocks.RED_OMORIKA_PLANKS))
                .criterion(hasItem(ModBlocks.RED_OMORIKA_PLANKS), conditionsFromItem(ModBlocks.RED_OMORIKA_PLANKS))
                .offerTo(exporter);
        createStairsRecipe(ModBlocks.SHIROMORIKA_STAIRS, Ingredient.ofItems(ModBlocks.SHIROMORIKA_PLANKS))
                .criterion(hasItem(ModBlocks.SHIROMORIKA_PLANKS), conditionsFromItem(ModBlocks.SHIROMORIKA_PLANKS))
                .offerTo(exporter);

        offerPressurePlateRecipe(exporter, ModBlocks.RED_OMORIKA_PRESSURE_PLATE, ModBlocks.RED_OMORIKA_PLANKS);
        offerPressurePlateRecipe(exporter, ModBlocks.SHIROMORIKA_PRESSURE_PLATE, ModBlocks.SHIROMORIKA_PLANKS);

        offerShapelessRecipe(exporter, ModBlocks.RED_OMORIKA_BUTTON,ModBlocks.RED_OMORIKA_PLANKS,RecipeCategory.REDSTONE.getName(),1);
        offerShapelessRecipe(exporter, ModBlocks.SHIROMORIKA_BUTTON,ModBlocks.SHIROMORIKA_PLANKS,RecipeCategory.REDSTONE.getName(),1);

        createFenceRecipe(ModBlocks.RED_OMORIKA_FENCE, Ingredient.ofItems(ModBlocks.RED_OMORIKA_PLANKS))
                .criterion(hasItem(ModBlocks.RED_OMORIKA_PLANKS), conditionsFromItem(ModBlocks.RED_OMORIKA_PLANKS))
                .offerTo(exporter);
        createFenceRecipe(ModBlocks.SHIROMORIKA_FENCE, Ingredient.ofItems(ModBlocks.SHIROMORIKA_PLANKS))
                .criterion(hasItem(ModBlocks.SHIROMORIKA_PLANKS), conditionsFromItem(ModBlocks.SHIROMORIKA_PLANKS))
                .offerTo(exporter);

        createFenceGateRecipe(ModBlocks.RED_OMORIKA_FENCE_GATE, Ingredient.ofItems(ModBlocks.RED_OMORIKA_PLANKS))
                .criterion(hasItem(ModBlocks.RED_OMORIKA_PLANKS), conditionsFromItem(ModBlocks.RED_OMORIKA_PLANKS))
                .offerTo(exporter);
        createFenceGateRecipe(ModBlocks.SHIROMORIKA_FENCE_GATE, Ingredient.ofItems(ModBlocks.SHIROMORIKA_PLANKS))
                .criterion(hasItem(ModBlocks.SHIROMORIKA_PLANKS), conditionsFromItem(ModBlocks.SHIROMORIKA_PLANKS))
                .offerTo(exporter);

        //CANDY RECIPES ======================================

        //Candy / Smelting
        offerSmelting(exporter,List.of(Items.SUGAR), RecipeCategory.FOOD, ModItems.CANDY, 0.1f, 200, "candy_from_smelting");
        //Candy / CandyBlock
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModItems.CANDY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CANDY_BLOCK);

        //Frozen Sword
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.PAPER), Ingredient.ofItems(Items.IRON_SWORD), Ingredient.ofItems(ModItems.FROZEN_STELLAR_HEART), RecipeCategory.TOOLS, ModItems.FROZEN_SWORD)
                .criterion(hasItem(ModItems.FROZEN_STELLAR_HEART), conditionsFromItem(ModItems.FROZEN_STELLAR_HEART))
                .offerTo(exporter, Identifier.of(AChristmasTale.MOD_ID, "frozen_sword_from_smithing"));


        //Hot Chocolate
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.HOT_CHOCOLATE)
                .pattern("SC")
                .input('S', Items.SUGAR)
                .input('C', Items.COCOA_BEANS)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);
    }

    private static void registerPlankRecipes(RecipeExporter exporter){
        Map<Block,Block> logToPlanks = Map.of(
                ModBlocks.RED_OMORIKA_LOG, ModBlocks.RED_OMORIKA_PLANKS,
                ModBlocks.STRIPPED_RED_OMORIKA_LOG, ModBlocks.RED_OMORIKA_PLANKS,
                ModBlocks.RED_OMORIKA_WOOD, ModBlocks.RED_OMORIKA_PLANKS,
                ModBlocks.STRIPPED_RED_OMORIKA_WOOD, ModBlocks.RED_OMORIKA_PLANKS,
                ModBlocks.SHIROMORIKA_LOG, ModBlocks.SHIROMORIKA_PLANKS,
                ModBlocks.STRIPPED_SHIROMORIKA_LOG, ModBlocks.SHIROMORIKA_PLANKS,
                ModBlocks.SHIROMORIKA_WOOD, ModBlocks.SHIROMORIKA_PLANKS,
                ModBlocks.STRIPPED_SHIROMORIKA_WOOD, ModBlocks.SHIROMORIKA_PLANKS
        );

        logToPlanks.forEach((log, plank) ->
                offerShapelessRecipe(exporter, plank, log, RecipeCategory.BUILDING_BLOCKS.getName(), 4)
        );
    }

    private static void registerWoodRecipes(RecipeExporter exporter){
        Map<Block,Block> logToWoods = Map.of(
                ModBlocks.RED_OMORIKA_LOG, ModBlocks.RED_OMORIKA_WOOD,
                ModBlocks.STRIPPED_RED_OMORIKA_LOG, ModBlocks.STRIPPED_RED_OMORIKA_WOOD,
                ModBlocks.SHIROMORIKA_LOG, ModBlocks.SHIROMORIKA_WOOD,
                ModBlocks.STRIPPED_SHIROMORIKA_LOG, ModBlocks.STRIPPED_SHIROMORIKA_WOOD
        );

        logToWoods.forEach((log, wood) ->
                ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, wood, 3)
                        .pattern("WW")
                        .pattern("WW")
                        .input('W', log)
                        .criterion(hasItem(log), conditionsFromItem(log))
                        .offerTo(exporter)
                );
    }
}
