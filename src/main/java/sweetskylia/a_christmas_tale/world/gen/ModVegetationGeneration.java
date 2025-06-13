package sweetskylia.a_christmas_tale.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import sweetskylia.a_christmas_tale.world.ModPlacedFeatures;

import java.util.function.Predicate;

public class ModVegetationGeneration {

    public static void generateVegetation() {
        Predicate<BiomeSelectionContext> coldOverworldBiomes = context ->
                BiomeSelectors.foundInOverworld().test(context)
                        && context.getBiome().getTemperature() <= 0.2f;

        generateFrozenBush(coldOverworldBiomes);
    }

    private static void generateFrozenBush(Predicate<BiomeSelectionContext> biomeFilter){
        BiomeModifications.addFeature(
                biomeFilter,
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.FROZEN_BUSH_PATCH_PLACED_KEY
        );
    }
}
