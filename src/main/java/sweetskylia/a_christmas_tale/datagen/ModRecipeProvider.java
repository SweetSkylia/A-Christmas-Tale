package sweetskylia.a_christmas_tale.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
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

        List<ItemConvertible> STELLAR_HEART_SMELTABLES = List.of(ModBlocks.STELLAR_HEART_ORE,ModItems.FROZEN_STELLAR_HEART);

       offerSmelting(exporter, STELLAR_HEART_SMELTABLES, RecipeCategory.MISC,ModItems.STELLAR_HEART,0.25f,200, "stellar_heart");
       offerBlasting(exporter, STELLAR_HEART_SMELTABLES, RecipeCategory.MISC,ModItems.STELLAR_HEART,0.25f,100, "stellar_heart");

       offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModItems.CANDY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CANDY_BLOCK);
//       offerSmithingTrimRecipe();
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.PAPER),Ingredient.ofItems(Items.IRON_SWORD),Ingredient.ofItems(ModItems.FROZEN_STELLAR_HEART), RecipeCategory.TOOLS, ModItems.FROZEN_SWORD)
                .criterion(hasItem(ModItems.FROZEN_STELLAR_HEART), conditionsFromItem(ModItems.FROZEN_STELLAR_HEART))
                .offerTo(exporter, Identifier.of(AChristmasTale.MOD_ID, "frozen_sword_from_smithing"));
//        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD)


    }
}
