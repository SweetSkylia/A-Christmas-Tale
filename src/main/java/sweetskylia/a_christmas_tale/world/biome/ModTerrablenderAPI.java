package sweetskylia.a_christmas_tale.world.biome;

import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(AChristmasTale.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, AChristmasTale.MOD_ID, ModMaterialRules.makeRules());
        }
}

