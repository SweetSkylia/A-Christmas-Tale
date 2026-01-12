package sweetskylia.a_christmas_tale.world.tree.trunkPlacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import sweetskylia.a_christmas_tale.world.tree.ModTrunkPlacerTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class RedTrunkPlacer extends TrunkPlacer {


    public static final MapCodec<RedTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillTrunkPlacerFields(instance).
                    apply(instance, RedTrunkPlacer::new
            )
    );



    public RedTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight)
    {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.RED_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);
        setToDirt(world, replacer, random, startPos.down().east(), config);
        setToDirt(world, replacer, random, startPos.down().south(), config);
        setToDirt(world, replacer, random, startPos.down().east().south(), config);

        List<FoliagePlacer.TreeNode> foliage = new ArrayList<>(); //foliage node list
        for (int i = 0; i <= height; i++){ //????
            getAndSetState(world,replacer,random,startPos.up(i),config);
            getAndSetState(world,replacer,random,startPos.up(i).east(),config);
            getAndSetState(world,replacer,random,startPos.up(i).south(),config);
            getAndSetState(world,replacer,random,startPos.up(i).east().south(),config);
        }

        foliage.add(new FoliagePlacer.TreeNode( //first node for top layer
             startPos.up(height),
             0, //radius is used as an ID
             false
        ));

        foliage.add(new FoliagePlacer.TreeNode( //second node for generating foliage of the tree (branch)
                startPos.up(height),
                1, //radius is used as an ID
                false
        ));

        return foliage;
    }
}
