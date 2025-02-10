package sweetskylia.a_christmas_tale.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.MusicType;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.world.ModPlacedFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> SHIRO_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(AChristmasTale.MOD_ID, "shiro_forest"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(SHIRO_FOREST, shiroForest(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder){
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
        DefaultBiomeFeatures.addSprings(builder);
    }

    public static Biome shiroForest(Registerable<Biome> context) {

        // SPAWN SETTINGS FOR ENTITIES
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 2,3,5));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);


        //GENERATION SETTINGS FOR STUFF
        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addEmeraldOre(biomeBuilder);


        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_SNOWY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.SHIRO_TREE_PLACED_KEY));
//        biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION,context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.SNOW_LAYER_KEY));
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.1f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .fogColor(0xDDE7F1) // Couleur du brouillard
                        .waterColor(0xBAECFF) // Couleur de l'eau
                        .waterFogColor(0x50533) // Couleur du brouillard sous l'eau
                        .skyColor(0x78A7FF) // Couleur du ciel
                        .foliageColor(0x91BD59) // Couleur du feuillage (optionnel)
                        .grassColor(0x90C1B8) // Couleur de l'herbe (optionnel)
                        .build())

                .build();

    }
}
