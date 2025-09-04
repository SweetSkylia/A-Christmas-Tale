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
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.block.custom.FrozenBushBlock;
import sweetskylia.a_christmas_tale.block.custom.ModSaplingBlock;
import sweetskylia.a_christmas_tale.block.custom.OrnamentBlock;
import sweetskylia.a_christmas_tale.block.custom.PresentBlock;
import sweetskylia.a_christmas_tale.world.tree.ModSaplingGenerators;

import java.util.function.Function;

public class ModBlocks {
    //====== BLOCKS
    public static final Block CANDY_BLOCK = registerBlock("candy_block",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.GLASS)));

    public static final Block STELLAR_BLOCK = registerBlock("stellar_block",
            settings -> new Block(settings.strength(5.5f).requiresTool()));

    public static final Block FROZEN_STELLAR_BLOCK = registerBlock("frozen_stellar_block",
           properties -> new Block(properties.strength(5.5f).requiresTool()));

    public static final Block CHRISTMAS_CARPET = registerBlock("christmas_carpet",
            properties ->new CarpetBlock(properties.strength(0.1F).sounds(BlockSoundGroup.WOOL).burnable()));

    public static final Block CHRISTMAS_WOOL = registerBlock("christmas_wool",
            properties ->new Block(properties.instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sounds(BlockSoundGroup.WOOL).burnable()));

    public static final Block WINTER_CARPET = registerBlock("winter_carpet",
            properties ->new CarpetBlock(properties.strength(0.1F).sounds(BlockSoundGroup.WOOL).burnable()));

    public static final Block WINTER_WOOL = registerBlock("winter_wool",
            properties ->new Block(properties.instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sounds(BlockSoundGroup.WOOL).burnable()));
    //====== CUSTOM ORES
    public static final Block STELLAR_HEART_ORE = registerBlock("stellar_heart_ore",
            properties ->new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    properties.strength(5.5f).requiresTool()));

    //RED OMORIKA ========================================================================
    public static final Block RED_OMORIKA_LOG = registerBlock("red_omorika_log",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block RED_OMORIKA_WOOD = registerBlock("red_omorika_wood",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block STRIPPED_RED_OMORIKA_LOG = registerBlock("stripped_red_omorika_log",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block STRIPPED_RED_OMORIKA_WOOD= registerBlock("stripped_red_omorika_wood",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block RED_OMORIKA_PLANKS = registerBlock("red_omorika_planks",
            properties ->new Block(properties.strength(3f)));

    public static final Block RED_OMORIKA_LEAVES = registerBlock("red_omorika_leaves",
            properties -> new LeavesBlock(properties
                    .mapColor(MapColor.RED).strength(0.2F).ticksRandomly()
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block RED_OMORIKA_SAPLING = registerBlock("red_omorika_sapling",
            properties ->new SaplingBlock(ModSaplingGenerators.RED_OMORIKA,properties.mapColor(MapColor.DARK_GREEN)
                    .noCollision().ticksRandomly().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));

    // WHITE OMORIKA (ShiroMorika) ========================================================

    public static final Block SHIROMORIKA_LOG = registerBlock("shiromorika_log",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block SHIROMORIKA_WOOD = registerBlock("shiromorika_wood",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block STRIPPED_SHIROMORIKA_LOG = registerBlock("stripped_shiromorika_log",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block STRIPPED_SHIROMORIKA_WOOD= registerBlock("stripped_shiromorika_wood",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block SHIROMORIKA_PLANKS = registerBlock("shiromorika_planks",
            properties ->new Block(properties.strength(3f)));

    public static final Block SHIROMORIKA_LEAVES = registerBlock("shiromorika_leaves",
            properties -> new LeavesBlock(properties
                    .mapColor(MapColor.WHITE).strength(0.2F).ticksRandomly()
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block SHIROMORIKA_SAPLING = registerBlock("shiromorika_sapling",
            properties -> new ModSaplingBlock(ModSaplingGenerators.SHIROMORIKA,properties.mapColor(MapColor.DARK_GREEN)
                    .noCollision().ticksRandomly().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block PRESENT_BLOCK = registerBlock("present_block",
            properties ->new PresentBlock(properties.nonOpaque().strength(0.6f)));




    //WOOD DECORATION FEATURES ============================================

    public static final Block RED_OMORIKA_STAIRS = registerBlock("red_omorika_stairs",
            properties ->  new StairsBlock(ModBlocks.RED_OMORIKA_PLANKS.getDefaultState(), properties
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block RED_OMORIKA_SLAB = registerBlock("red_omorika_slab",
            properties -> new SlabBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block RED_OMORIKA_BUTTON = registerBlock("red_omorika_button",
            properties -> new ButtonBlock(BlockSetType.OAK,20, properties.noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block RED_OMORIKA_PRESSURE_PLATE = registerBlock("red_omorika_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK, properties.solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block RED_OMORIKA_FENCE = registerBlock("red_omorika_fence",
            properties -> new FenceBlock(properties.solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block RED_OMORIKA_FENCE_GATE = registerBlock("red_omorika_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK,properties.solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block RED_OMORIKA_DOOR = registerBlock("red_omorika_door",
            properties ->  new DoorBlock(BlockSetType.OAK,properties.instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block RED_OMORIKA_TRAPDOOR = registerBlock("red_omorika_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.OAK,properties.instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));



    public static final Block SHIROMORIKA_STAIRS = registerBlock("shiromorika_stairs",
            properties ->  new StairsBlock(ModBlocks.RED_OMORIKA_PLANKS.getDefaultState(),properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block SHIROMORIKA_SLAB = registerBlock("shiromorika_slab",
            properties -> new SlabBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block SHIROMORIKA_BUTTON = registerBlock("shiromorika_button",
            properties -> new ButtonBlock(BlockSetType.OAK,20, properties.noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SHIROMORIKA_PRESSURE_PLATE = registerBlock("shiromorika_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK, properties.solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block SHIROMORIKA_FENCE = registerBlock("shiromorika_fence",
            properties ->  new FenceBlock(properties.solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block SHIROMORIKA_FENCE_GATE = registerBlock("shiromorika_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK,properties.solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block SHIROMORIKA_DOOR = registerBlock("shiromorika_door",
            properties ->  new DoorBlock(BlockSetType.OAK,properties.instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SHIROMORIKA_TRAPDOOR = registerBlock("shiromorika_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.OAK,properties.instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));


    public static final Block FROZEN_BUSH = registerBlockWithoutItem("frozen_bush",
            properties ->new FrozenBushBlock(properties
                    .mapColor(MapColor.DARK_GREEN)
                    .ticksRandomly()
                    .noCollision()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                    .pistonBehavior(PistonBehavior.DESTROY))
            );


    public static final Block STELLAR_ICE = registerBlock("stellar_ice",
            properties -> new Block(properties.instrument(NoteBlockInstrument.CHIME).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS).requiresTool()));

    public static final Block RED_CRYSTAL = registerBlock("red_crystal",
            properties ->new TransparentBlock(properties
            .nonOpaque()
            .strength(0.3F)
            .sounds(BlockSoundGroup.GLASS)
            .blockVision(Blocks::never)
            .allowsSpawning(Blocks::never)
            .solidBlock(Blocks::never)
            .suffocates(Blocks::never)));
    public static final Block BLUE_CRYSTAL = registerBlock("blue_crystal",
            properties ->new TransparentBlock(properties
            .nonOpaque()
            .strength(0.3F)
            .sounds(BlockSoundGroup.GLASS)
            .blockVision(Blocks::never)
            .allowsSpawning(Blocks::never)
            .solidBlock(Blocks::never)
            .suffocates(Blocks::never)));
    public static final Block PURPLE_CRYSTAL = registerBlock("purple_crystal",
            properties ->new TransparentBlock(properties
            .nonOpaque()
            .strength(0.3F)
            .sounds(BlockSoundGroup.GLASS)
            .blockVision(Blocks::never)
            .allowsSpawning(Blocks::never)
            .solidBlock(Blocks::never)
            .suffocates(Blocks::never)));

    public static final Block WHITE_ORNAMENT = registerBlock("white_ornament",properties -> createOrnamentBlock(DyeColor.WHITE, properties));
    public static final Block ORANGE_ORNAMENT = registerBlock("orange_ornament",properties -> createOrnamentBlock(DyeColor.ORANGE, properties));
    public static final Block MAGENTA_ORNAMENT = registerBlock("magenta_ornament",properties -> createOrnamentBlock(DyeColor.MAGENTA, properties));
    public static final Block LIGHT_BLUE_ORNAMENT = registerBlock("light_blue_ornament",properties ->createOrnamentBlock(DyeColor.LIGHT_BLUE, properties));
    public static final Block YELLOW_ORNAMENT = registerBlock("yellow_ornament",properties -> createOrnamentBlock(DyeColor.YELLOW, properties));
    public static final Block LIME_ORNAMENT = registerBlock("lime_ornament",properties -> createOrnamentBlock(DyeColor.LIME, properties));
    public static final Block PINK_ORNAMENT = registerBlock("pink_ornament",properties -> createOrnamentBlock(DyeColor.PINK, properties));
    public static final Block GRAY_ORNAMENT = registerBlock("gray_ornament",properties -> createOrnamentBlock(DyeColor.GRAY, properties));
    public static final Block LIGHT_GRAY_ORNAMENT = registerBlock("light_gray_ornament",properties -> createOrnamentBlock(DyeColor.LIGHT_GRAY, properties));
    public static final Block CYAN_ORNAMENT = registerBlock("cyan_ornament",properties -> createOrnamentBlock(DyeColor.CYAN, properties));
    public static final Block PURPLE_ORNAMENT = registerBlock("purple_ornament",properties -> createOrnamentBlock(DyeColor.PURPLE, properties));
    public static final Block BLUE_ORNAMENT = registerBlock("blue_ornament",properties -> createOrnamentBlock(DyeColor.BLUE, properties));
    public static final Block BROWN_ORNAMENT = registerBlock("brown_ornament",properties -> createOrnamentBlock(DyeColor.BROWN, properties));
    public static final Block GREEN_ORNAMENT = registerBlock("green_ornament",properties -> createOrnamentBlock(DyeColor.GREEN, properties));
    public static final Block RED_ORNAMENT = registerBlock("red_ornament",properties -> createOrnamentBlock(DyeColor.RED, properties));
    public static final Block BLACK_ORNAMENT = registerBlock("black_ornament",properties -> createOrnamentBlock(DyeColor.BLACK, properties));

//    private static Block registerBlock(String name, Block block) {
//        return registerBlock(name, block, true);
//    }

    //Register item without appearing when /give
//    private static Block registerBlock(String name, Block block, boolean hasItem) {
//        if (hasItem) {
//            registerBlockItem(name, block);
//        }
//        return Registry.register(Registries.BLOCK, Identifier.of(AChristmasTale.MOD_ID, name), block);
//    }

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function){
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AChristmasTale.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(AChristmasTale.MOD_ID, name), toRegister);
    }

    //Register item for block
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AChristmasTale.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AChristmasTale.MOD_ID, name)))));
    }


    private static Block registerBlockWithoutItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(AChristmasTale.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(AChristmasTale.MOD_ID,name)))));
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

    private static Block createOrnamentBlock(DyeColor color, AbstractBlock.Settings settings) {
        return new OrnamentBlock(color,
                settings
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
