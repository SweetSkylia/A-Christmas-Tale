package sweetskylia.a_christmas_tale.world.tree.trunkPlacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
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

public class ShiroTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<ShiroTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillTrunkPlacerFields(instance).and(
                    instance.group(
                            IntProvider.createValidatingCodec(3, 8).fieldOf("branch_count").forGetter(p -> p.branchCount),
                            IntProvider.createValidatingCodec(2, 4).fieldOf("branch_length").forGetter(p -> p.branchLength),
                            IntProvider.createValidatingCodec(2, 6).fieldOf("branch_start_offset_range").forGetter(p -> p.branchStartOffsetRange)
                    )
            ).apply(instance, (baseHeight, heightRandA, heightRandB, branchCount, branchLength, branchStartOffsetRange) ->
                    new ShiroTrunkPlacer(baseHeight, heightRandA, heightRandB, branchCount, branchLength, branchStartOffsetRange)
            )
    );





    private final IntProvider branchCount;
    private final IntProvider branchLength;
    private final IntProvider branchStartOffsetRange;

    public ShiroTrunkPlacer(
            int baseHeight, int randomHeightA, int randomHeightB,
            IntProvider branchCount,
            IntProvider branchLength,
            IntProvider branchStartOffsetRange
    ) {
        super(baseHeight, randomHeightA, randomHeightB);
        this.branchCount = branchCount;
        this.branchLength = branchLength;
        this.branchStartOffsetRange = branchStartOffsetRange;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.SHIRO_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world,
                                                 BiConsumer<BlockPos, BlockState> replacer,
                                                 Random random,
                                                 int height,
                                                 BlockPos startPos,
                                                 TreeFeatureConfig config) {
        setToDirt(world,replacer,random,startPos.down(),config);
        for (int i = 0; i < height; i++) {
            getAndSetState(world,replacer,random,startPos.up(i),config);
        }
        List<FoliagePlacer.TreeNode> foliage = new ArrayList<>();


        //Branch with differents height
        int branchCount = this.branchCount.get(random);
        for (int i = 0; i < branchCount; i++) {
            Direction dir = Direction.Type.HORIZONTAL.random(random);
            int branchStartOffset = this.branchStartOffsetRange.get(random);
            int branchHeight = height - branchStartOffset; //offset from top
            BlockPos.Mutable branchPos = new BlockPos.Mutable(startPos.getX(), startPos.getY() + branchHeight , startPos.getZ());

            //Random length for branch
            for (int j = 0; j < this.branchLength.get(random); j++) {
                branchPos.move(dir);
                getAndSetState(world,replacer,random,branchPos,config,state -> state.withIfExists(PillarBlock.AXIS, dir.getAxis()));
            }
            foliage.add(new FoliagePlacer.TreeNode(branchPos.toImmutable().up(), 0, false));

        }
        foliage.add(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));
        return foliage;
    }
}
