package sweetskylia.a_christmas_tale.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class OrnamentBlock extends Block implements Stainable {

    private static final VoxelShape SHAPE = Block.createCuboidShape(4,2,4,12,12,12);

    public static final MapCodec<OrnamentBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(DyeColor.CODEC.fieldOf("color").forGetter(OrnamentBlock::getColor), createSettingsCodec())
                    .apply(instance, OrnamentBlock::new)
    );


    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    private final DyeColor color;

    public MapCodec<OrnamentBlock> getColorCodec() {return CODEC;}

    public OrnamentBlock(DyeColor color, AbstractBlock.Settings settings) {
        super(settings);
        this.color = color;
    }

    @Override
    public DyeColor getColor() {
        return this.color;
    }
}
