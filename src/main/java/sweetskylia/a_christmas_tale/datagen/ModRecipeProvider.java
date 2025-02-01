package sweetskylia.a_christmas_tale.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
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
}
