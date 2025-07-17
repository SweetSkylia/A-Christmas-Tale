package sweetskylia.a_christmas_tale.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.block.custom.FrozenBushBlock;
import sweetskylia.a_christmas_tale.block.custom.OrnamentBlock;
import sweetskylia.a_christmas_tale.block.custom.PresentBlock;
import sweetskylia.a_christmas_tale.world.tree.ModSaplingGenerators;

public class ModBlocks {
    //====== BLOCKS
    public static final Block CANDY_BLOCK = registerBlock("candy_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.GLASS)));

    public static final Block STELLAR_BLOCK = registerBlock("stellar_block",
            new Block(AbstractBlock.Settings.create().strength(5.5f).requiresTool()));

    public static final Block FROZEN_STELLAR_BLOCK = registerBlock("frozen_stellar_block",
            new Block(AbstractBlock.Settings.create().strength(5.5f).requiresTool()));

    public static final Block CHRISTMAS_CARPET = registerBlock("christmas_carpet",
            new CarpetBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).burnable()));

    public static final Block CHRISTMAS_WOOL = registerBlock("christmas_wool",
            new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sounds(BlockSoundGroup.WOOL).burnable()));

    public static final Block WINTER_CARPET = registerBlock("winter_carpet", new CarpetBlock(AbstractBlock.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL).burnable()));

    public static final Block WINTER_WOOL = registerBlock("winter_wool",
            new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sounds(BlockSoundGroup.WOOL).burnable()));
    //====== CUSTOM ORES
    public static final Block STELLAR_HEART_ORE = registerBlock("stellar_heart_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(5.5f).requiresTool()));

    //RED OMORIKA ========================================================================
    public static final Block RED_OMORIKA_LOG = registerBlock("red_omorika_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block RED_OMORIKA_WOOD = registerBlock("red_omorika_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_RED_OMORIKA_LOG = registerBlock("stripped_red_omorika_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block STRIPPED_RED_OMORIKA_WOOD= registerBlock("stripped_red_omorika_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block RED_OMORIKA_PLANKS = registerBlock("red_omorika_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block RED_OMORIKA_LEAVES = registerBlock("red_omorika_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block RED_OMORIKA_SAPLING = registerBlock("red_omorika_sapling",
            new SaplingBlock(ModSaplingGenerators.RED_OMORIKA,AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    // WHITE OMORIKA (ShiroMorika) ========================================================

    public static final Block SHIROMORIKA_LOG = registerBlock("shiromorika_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block SHIROMORIKA_WOOD = registerBlock("shiromorika_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_SHIROMORIKA_LOG = registerBlock("stripped_shiromorika_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block STRIPPED_SHIROMORIKA_WOOD= registerBlock("stripped_shiromorika_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block SHIROMORIKA_PLANKS = registerBlock("shiromorika_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block SHIROMORIKA_LEAVES = registerBlock("shiromorika_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block SHIROMORIKA_SAPLING = registerBlock("shiromorika_sapling",
            new SaplingBlock(ModSaplingGenerators.SHIROMORIKA,AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block PRESENT_BLOCK = registerBlock("present_block",
            new PresentBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.6f)));




    //WOOD DECORATION FEATURES ============================================

    public static final Block RED_OMORIKA_STAIRS = registerBlock("red_omorika_stairs",
            new StairsBlock(ModBlocks.RED_OMORIKA_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    public static final Block RED_OMORIKA_SLAB = registerBlock("red_omorika_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block RED_OMORIKA_BUTTON = registerBlock("red_omorika_button",
            new ButtonBlock(BlockSetType.OAK,20, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).noCollision()));
    public static final Block RED_OMORIKA_PRESSURE_PLATE = registerBlock("red_omorika_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).noCollision()));

    public static final Block RED_OMORIKA_FENCE = registerBlock("red_omorika_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    public static final Block RED_OMORIKA_FENCE_GATE = registerBlock("red_omorika_fence_gate",
            new FenceGateBlock(WoodType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));
    public static final Block RED_OMORIKA_DOOR = registerBlock("red_omorika_door",
            new DoorBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_SLAB).nonOpaque()));
    public static final Block RED_OMORIKA_TRAPDOOR = registerBlock("red_omorika_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_SLAB).nonOpaque()));



    public static final Block SHIROMORIKA_STAIRS = registerBlock("shiromorika_stairs",
            new StairsBlock(ModBlocks.RED_OMORIKA_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    public static final Block SHIROMORIKA_SLAB = registerBlock("shiromorika_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block SHIROMORIKA_BUTTON = registerBlock("shiromorika_button",
            new ButtonBlock(BlockSetType.OAK,20, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).noCollision()));
    public static final Block SHIROMORIKA_PRESSURE_PLATE = registerBlock("shiromorika_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).noCollision()));

    public static final Block SHIROMORIKA_FENCE = registerBlock("shiromorika_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    public static final Block SHIROMORIKA_FENCE_GATE = registerBlock("shiromorika_fence_gate",
            new FenceGateBlock(WoodType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));
    public static final Block SHIROMORIKA_DOOR = registerBlock("shiromorika_door",
            new DoorBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_SLAB).nonOpaque()));
    public static final Block SHIROMORIKA_TRAPDOOR = registerBlock("shiromorika_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_SLAB).nonOpaque()));


    public static final Block FROZEN_BUSH = registerBlock("frozen_bush",
            new FrozenBushBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .ticksRandomly()
                    .noCollision()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                    .pistonBehavior(PistonBehavior.DESTROY))
            , false);

    public static final Block WHITE_ORNAMENT = registerBlock("white_ornament",createOrnamentBlock(DyeColor.WHITE));
    public static final Block ORANGE_ORNAMENT = registerBlock("orange_ornament",createOrnamentBlock(DyeColor.ORANGE));
    public static final Block MAGENTA_ORNAMENT = registerBlock("magenta_ornament",createOrnamentBlock(DyeColor.MAGENTA));
    public static final Block LIGHT_BLUE_ORNAMENT = registerBlock("light_blue_ornament",createOrnamentBlock(DyeColor.LIGHT_BLUE));
    public static final Block YELLOW_ORNAMENT = registerBlock("yellow_ornament",createOrnamentBlock(DyeColor.YELLOW));
    public static final Block LIME_ORNAMENT = registerBlock("lime_ornament",createOrnamentBlock(DyeColor.LIME));
    public static final Block PINK_ORNAMENT = registerBlock("pink_ornament",createOrnamentBlock(DyeColor.PINK));
    public static final Block GRAY_ORNAMENT = registerBlock("gray_ornament",createOrnamentBlock(DyeColor.GRAY));
    public static final Block LIGHT_GRAY_ORNAMENT = registerBlock("light_gray_ornament",createOrnamentBlock(DyeColor.LIGHT_GRAY));
    public static final Block CYAN_ORNAMENT = registerBlock("cyan_ornament",createOrnamentBlock(DyeColor.CYAN));
    public static final Block PURPLE_ORNAMENT = registerBlock("purple_ornament",createOrnamentBlock(DyeColor.PURPLE));
    public static final Block BLUE_ORNAMENT = registerBlock("blue_ornament",createOrnamentBlock(DyeColor.BLUE));
    public static final Block BROWN_ORNAMENT = registerBlock("brown_ornament",createOrnamentBlock(DyeColor.BROWN));
    public static final Block GREEN_ORNAMENT = registerBlock("green_ornament",createOrnamentBlock(DyeColor.GREEN));
    public static final Block RED_ORNAMENT = registerBlock("red_ornament",createOrnamentBlock(DyeColor.RED));
    public static final Block BLACK_ORNAMENT = registerBlock("black_ornament",createOrnamentBlock(DyeColor.BLACK));

    private static Block registerBlock(String name, Block block) {
        return registerBlock(name, block, true);
    }

    //Register item without appearing when /give
    private static Block registerBlock(String name, Block block, boolean hasItem) {
        if (hasItem) {
            registerBlockItem(name, block);
        }
        return Registry.register(Registries.BLOCK, Identifier.of(AChristmasTale.MOD_ID, name), block);
    }

    //Register item for block
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AChristmasTale.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        AChristmasTale.LOGGER.info("[" + AChristmasTale.MOD_ID + "] Registering Blocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(CANDY_BLOCK);
            entries.add(STELLAR_HEART_ORE);
            entries.add(STELLAR_BLOCK);
            entries.add(FROZEN_STELLAR_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(CHRISTMAS_WOOL);
            entries.add(CHRISTMAS_CARPET);
            entries.add(WINTER_WOOL);
            entries.add(WINTER_CARPET);
        });
    }

    private static Block createOrnamentBlock(DyeColor color){
        return new OrnamentBlock(color,
                AbstractBlock.Settings.create()
                        .mapColor(color)
                        .instrument(NoteBlockInstrument.HAT)
                        .strength(0.3F)
                        .sounds(BlockSoundGroup.GLASS)
                        .allowsSpawning(Blocks::never)
                        .solidBlock(Blocks::never)
                        .suffocates(Blocks::never)
                        .luminance( state -> 10)
                        .blockVision(Blocks::never)
                        .nonOpaque()

        );
    }
}
