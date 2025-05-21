package sweetskylia.a_christmas_tale.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> STELLAR_HEART_ORE_KEY = registerKey("stellar_heart_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_OMORIKA_KEY = registerKey("red_omorika");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHIROMORIKA_KEY = registerKey("shiromorika");
//    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOW_LAYER_KEY = registerKey("snow_layer");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES); //règle pour générer les minerais dans la stone classique

        List<OreFeatureConfig.Target> overworldStellarHeartOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.STELLAR_HEART_ORE.getDefaultState())
                        //ajouter ici les futures règles pour ce block
                );

        register(context, STELLAR_HEART_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldStellarHeartOres, 4));


    //TREES ================================================================================
        register(context, RED_OMORIKA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.RED_OMORIKA_LOG),
                new StraightTrunkPlacer(7, 2, 1), //Trunk of the tree

                BlockStateProvider.of(ModBlocks.RED_OMORIKA_LEAVES),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).build());

        register(context, SHIROMORIKA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SHIROMORIKA_LOG),
                new StraightTrunkPlacer(7, 2, 1),

                BlockStateProvider.of(ModBlocks.SHIROMORIKA_LEAVES.getDefaultState()),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).build());

    }

    //=======================================================================================


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(AChristmasTale.MOD_ID, name));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
