package sweetskylia.a_christmas_tale.world.tree;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.world.tree.foliagePlacer.RedFoliagePlacer;
import sweetskylia.a_christmas_tale.world.tree.trunkPlacer.RedTrunkPlacer;

public class ModFoliagePlacerTypes {
//
    public static final FoliagePlacerType<RedFoliagePlacer> RED_FOLIAGE_PLACER =
            Registry.register(Registries.FOLIAGE_PLACER_TYPE,
                    Identifier.of("a_christmas_tale", "red_foliage_placer"),
                    new FoliagePlacerType<>(RedFoliagePlacer.CODEC));

    private static <T extends net.minecraft.world.gen.foliage.FoliagePlacer> FoliagePlacerType<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.FOLIAGE_PLACER_TYPE, Identifier.of(AChristmasTale.MOD_ID, name), new FoliagePlacerType<>(codec));
    }

    public static void register() {
    }
}
