package sweetskylia.a_christmas_tale.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> STELLAR_HEART_ORE_KEY = registerKey("stellar_heart_ore_placed");

    public static final RegistryKey<PlacedFeature> SHIRO_TREE_PLACED_KEY = registerKey("shiro_tree_placed");
    public static final RegistryKey<PlacedFeature> RED_TREE_PLACED_KEY = registerKey("red_tree_placed");

//    public static final RegistryKey<PlacedFeature> SNOW_LAYER_KEY = registerKey("snow_layer_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context,STELLAR_HEART_ORE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STELLAR_HEART_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0),YOffset.fixed(20))));

        register(context, SHIRO_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SHIROMORIKA_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(5, 0.02F, 4),
                        ModBlocks.SHIROMORIKA_SAPLING));
        register(context, RED_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_OMORIKA_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(5, 0.02F, 4),
                        ModBlocks.RED_OMORIKA_SAPLING));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(AChristmasTale.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

}
