package sweetskylia.a_christmas_tale.world.tree;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.world.tree.trunkPlacer.ShiroTrunkPlacer;

public class ModTrunkPlacerTypes {
//    public static final TrunkPlacerType<ShiroTrunkPlacer> SHIRO_TRUNK_PLACER =
//            register("shiro_trunk_placer", ShiroTrunkPlacer.CODEC);

    public static final TrunkPlacerType<ShiroTrunkPlacer> SHIRO_TRUNK_PLACER =
            Registry.register(Registries.TRUNK_PLACER_TYPE,
                    Identifier.of("a_christmas_tale", "shiro_trunk_placer"),
                    new TrunkPlacerType<>(ShiroTrunkPlacer.CODEC));

    private static <T extends net.minecraft.world.gen.trunk.TrunkPlacer> TrunkPlacerType<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.TRUNK_PLACER_TYPE, Identifier.of(AChristmasTale.MOD_ID, name), new TrunkPlacerType<>(codec));
    }

    public static void register() {
    }
}
