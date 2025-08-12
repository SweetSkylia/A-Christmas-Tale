package sweetskylia.a_christmas_tale.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import sweetskylia.a_christmas_tale.world.biome.ModBiomes;

public class ModMaterialRules {


    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule BLUE_ICE = makeStateRule(Blocks.BLUE_ICE);
    private static final MaterialRules.MaterialRule SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);


    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialCondition isShiroForest = MaterialRules.biome(ModBiomes.SHIRO_FOREST);


        MaterialRules.MaterialCondition blueIcePatch = MaterialRules.noiseThreshold(
                RegistryKey.of(RegistryKeys.NOISE_PARAMETERS, Identifier.of("minecraft", "surface")),
                -0.2D,
                0.2D
        );
        MaterialRules.MaterialRule blueIceOrSnow = MaterialRules.sequence(
                // Si bruit dans la plage → Blue Ice
                MaterialRules.condition(blueIcePatch, BLUE_ICE),
                // Sinon → Snow Block
                SNOW_BLOCK
        );

        // Shiro Forest
        MaterialRules.MaterialRule shiroSurface = MaterialRules.sequence(
                MaterialRules.condition(isAtOrAboveWaterLevel, blueIceOrSnow),
                DIRT
        );

        // Default rule
        MaterialRules.MaterialRule defaultSurface = MaterialRules.sequence(
                MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK),
                DIRT
        );

        return MaterialRules.sequence(
                MaterialRules.condition(
                        isShiroForest,
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, shiroSurface)
                ),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, defaultSurface)
        );
    }
    private static MaterialRules.MaterialRule makeStateRule(Block block){
        return MaterialRules.block(block.getDefaultState());
    }
}
