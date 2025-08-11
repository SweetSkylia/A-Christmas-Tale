package sweetskylia.a_christmas_tale.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import sweetskylia.a_christmas_tale.world.biome.ModBiomes;

public class ModMaterialRules {


    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule BLUE_ICE = makeStateRule(Blocks.BLUE_ICE);


    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialCondition isShiroForest = MaterialRules.biome(ModBiomes.SHIRO_FOREST);

        // Shiro Forest
        MaterialRules.MaterialRule blueIceSurface = MaterialRules.sequence(
                MaterialRules.condition(isAtOrAboveWaterLevel, BLUE_ICE),
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
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, blueIceSurface)
                ),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, defaultSurface)
        );
    }
    private static MaterialRules.MaterialRule makeStateRule(Block block){
        return MaterialRules.block(block.getDefaultState());
    }
}
