package sweetskylia.a_christmas_tale.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.AChristmasTale;

public class ModBlocks {
    //BLOCKS DECLARATION
    public static final Block CANDY_BLOCK = registerBlock("candy_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.GLASS)));




    //INIT BLOCKS REGISTERING
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AChristmasTale.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AChristmasTale.MOD_ID,name), block);
    }
    public static void registerModBlocks() {
        AChristmasTale.LOGGER.info("[" + AChristmasTale.MOD_ID + "] Registering Blocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(CANDY_BLOCK);
        });
    }
}
