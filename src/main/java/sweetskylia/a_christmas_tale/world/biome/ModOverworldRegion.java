package sweetskylia.a_christmas_tale.world.biome;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;
import static terrablender.api.ParameterUtils.*;


import java.util.function.Consumer;

public class ModOverworldRegion extends Region {

    public ModOverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }


    @Override

    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper){
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

//        SHIRO FOREST
        new ParameterPointListBuilder()
                .temperature(Temperature.FROZEN)
                .humidity(Humidity.span(Humidity.ARID, Humidity.WET))
                .continentalness(Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
                .depth(Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.SHIRO_FOREST));
//        RED_FOREST
        new ParameterPointListBuilder()
                .temperature(Temperature.FROZEN)
                .humidity(Humidity.span(Humidity.ARID, Humidity.NEUTRAL))
                .continentalness(Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
                .depth(Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.RED_FOREST));

        builder.build().forEach(mapper);
    }

}
