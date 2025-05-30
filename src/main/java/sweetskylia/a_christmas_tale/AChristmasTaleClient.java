package sweetskylia.a_christmas_tale;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import sweetskylia.a_christmas_tale.block.ModBlocks;

import java.util.List;

public class AChristmasTaleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //TRANSPARENT BLOCKS
        List<Block> transparentBlocks = List.of(ModBlocks.RED_OMORIKA_SAPLING,
                ModBlocks.SHIROMORIKA_SAPLING,
                ModBlocks.SHIROMORIKA_DOOR,
                ModBlocks.SHIROMORIKA_TRAPDOOR,
                ModBlocks.RED_OMORIKA_SAPLING,
                ModBlocks.RED_OMORIKA_DOOR,
                ModBlocks.RED_OMORIKA_TRAPDOOR,
                ModBlocks.PRESENT_BLOCK,
                ModBlocks.FROZEN_BUSH
        );

        transparentBlocks.forEach((block) ->{
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
                }
        );
    }
}
