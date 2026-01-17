package sweetskylia.a_christmas_tale.world.dimension;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGenerators;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import sweetskylia.a_christmas_tale.AChristmasTale;

import java.util.OptionalLong;

public class ModDimension {
    public static final RegistryKey<DimensionOptions> ACTDIM_KEY = RegistryKey.of( RegistryKeys.DIMENSION,
            Identifier.of(AChristmasTale.MOD_ID, "actdim"));

    public static final RegistryKey<World> ACTDIM_LEVEL_KEY = RegistryKey.of( RegistryKeys.WORLD,
            Identifier.of(AChristmasTale.MOD_ID, "actdim"));

    public static final RegistryKey<DimensionType> ACT_DIM_TYPE = RegistryKey.of( RegistryKeys.DIMENSION_TYPE,
            Identifier.of(AChristmasTale.MOD_ID, "actdim_type"));



    public static void bootstrapType(Registerable<DimensionType> context){
        context.register(ACT_DIM_TYPE, new DimensionType(
                OptionalLong.empty(), //time fixed ?
                true, //skylight
                false, //ceiling
                false, //ultrawarm
                true, //natural
                1.0, //scale of coordinates
                true, //usage of beds
                false, //usage of respawn anchors
                -64, //min y
                256, //max y
                256, //local height
                BlockTags.INFINIBURN_OVERWORLD, //infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                1.0f, //ambiant light
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0,0),0)
        ));
    }
}
