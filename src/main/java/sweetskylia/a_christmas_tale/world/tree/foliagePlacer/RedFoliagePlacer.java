package sweetskylia.a_christmas_tale.world.tree.foliagePlacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import sweetskylia.a_christmas_tale.world.tree.ModFoliagePlacerTypes;
import sweetskylia.a_christmas_tale.world.tree.trunkPlacer.ShiroTrunkPlacer;

import java.util.function.BiConsumer;

public class RedFoliagePlacer extends FoliagePlacer {


    public static final MapCodec<RedFoliagePlacer> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    fillFoliagePlacerFields(instance)
                            .apply(instance, RedFoliagePlacer::new)
            );

    public RedFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.RED_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {

        BlockPos pos = treeNode.getCenter();
        int posHeight = pos.getY();

        if (treeNode.getFoliageRadius() == 0) { //top layer
            this.generateSquare(world, placer, random, config, pos, 2,1, true);
            this.generateSquare(world, placer, random, config, pos, 1,2, true);
        } else if (treeNode.getFoliageRadius() == 1) { //other layers
            generateLayer(world,placer,random,config,trunkHeight,treeNode,foliageHeight,radius,offset);
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return trunkHeight / 2;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (dx + dz >= 7) {
            return true;
        } else {
            return dx * dx + dz * dz > radius * radius;
        }
    }

    private void generateLayer(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        BlockPos pos = treeNode.getCenter(); //the node of the tree;
        int _radius = 2;

        for (int y = pos.getY(); y > pos.getY() - foliageHeight - offset - random.nextInt(5); y--) //up to down
        {
            if (_radius == 6){
                _radius = 2;
            }
            if(Math.abs(y) % 2 != 0) {
                this.generateSquare(world, placer, random, config, new BlockPos(pos.getX(), y, pos.getZ()), _radius, 1, true);
                this.generateSquare(world, placer, random, config, new BlockPos(pos.getX(), y, pos.getZ()).down(1), _radius -1, 1, true);
                _radius++;
            }

        }

    }
}
