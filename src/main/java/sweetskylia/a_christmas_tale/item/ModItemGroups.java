package sweetskylia.a_christmas_tale.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup A_CHRISTMAS_TALE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AChristmasTale.MOD_ID, "a_christmas_tale_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SNOWFLAKE))
                    .displayName(Text.translatable("itemgroup.a_christmas_tale.a_christmas_tale_items"))
                    .entries((displayContext, entries) -> {
                        //Blocks
                        entries.add(ModBlocks.CHRISTMAS_CARPET);
                        entries.add(ModBlocks.CHRISTMAS_WOOL);
                        entries.add(ModBlocks.WINTER_CARPET);
                        entries.add(ModBlocks.WINTER_WOOL);
                        entries.add(ModBlocks.STELLAR_HEART_ORE);
                        entries.add(ModBlocks.STELLAR_BLOCK);
                        entries.add(ModBlocks.FROZEN_STELLAR_BLOCK);
                        entries.add(ModBlocks.CANDY_BLOCK);
                        entries.add(ModBlocks.PRESENT_BLOCK);


                        //Items
                        entries.add(ModItems.STELLAR_HEART);
                        entries.add(ModItems.FROZEN_STELLAR_HEART);
                        entries.add(ModItems.CANDY);
                        entries.add(ModItems.HOT_CHOCOLATE);
                        entries.add(ModItems.FROZEN_FRUIT);
                        entries.add(ModItems.SNOWFLAKE);
                        entries.add(ModItems.FROZEN_SWORD);
                        entries.add(ModItems.STELLAR_CANDY_SWORD);
                        entries.add(ModItems.STELLAR_CANDY_PICKAXE);
                        entries.add(ModItems.STELLAR_CANDY_AXE);
                        entries.add(ModItems.STELLAR_CANDY_SHOVEL);
                        entries.add(ModItems.STELLAR_CANDY_HOE);


                    }).build());


    public static final ItemGroup A_CHRISTMAS_TALE_WOOD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AChristmasTale.MOD_ID, "a_christmas_tale_wood"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModBlocks.SHIROMORIKA_PLANKS))
                    .displayName(Text.translatable("itemgroup.a_christmas_tale.a_christmas_tale_wood"))
                    .entries((displayContext, entries) -> {
                        //TREES
                        entries.add(ModBlocks.RED_OMORIKA_LEAVES);
                        entries.add(ModBlocks.RED_OMORIKA_LOG);
                        entries.add(ModBlocks.STRIPPED_RED_OMORIKA_WOOD);
                        entries.add(ModBlocks.STRIPPED_RED_OMORIKA_LOG);
                        entries.add(ModBlocks.RED_OMORIKA_WOOD);
                        entries.add(ModBlocks.RED_OMORIKA_SAPLING);
                        entries.add(ModBlocks.RED_OMORIKA_PLANKS);
                        entries.add(ModBlocks.RED_OMORIKA_STAIRS);
                        entries.add(ModBlocks.RED_OMORIKA_SLAB);
                        entries.add(ModBlocks.RED_OMORIKA_DOOR);
                        entries.add(ModBlocks.RED_OMORIKA_TRAPDOOR);
                        entries.add(ModBlocks.RED_OMORIKA_FENCE);
                        entries.add(ModBlocks.RED_OMORIKA_FENCE_GATE);
                        entries.add(ModBlocks.RED_OMORIKA_PRESSURE_PLATE);
                        entries.add(ModBlocks.RED_OMORIKA_BUTTON);



                        entries.add(ModBlocks.SHIROMORIKA_LEAVES);
                        entries.add(ModBlocks.SHIROMORIKA_LOG);
                        entries.add(ModBlocks.STRIPPED_SHIROMORIKA_WOOD);
                        entries.add(ModBlocks.STRIPPED_SHIROMORIKA_LOG);
                        entries.add(ModBlocks.SHIROMORIKA_WOOD);
                        entries.add(ModBlocks.SHIROMORIKA_SAPLING);
                        entries.add(ModBlocks.SHIROMORIKA_PLANKS);
                        entries.add(ModBlocks.SHIROMORIKA_STAIRS);
                        entries.add(ModBlocks.SHIROMORIKA_SLAB);
                        entries.add(ModBlocks.SHIROMORIKA_DOOR);
                        entries.add(ModBlocks.SHIROMORIKA_TRAPDOOR);
                        entries.add(ModBlocks.SHIROMORIKA_FENCE);
                        entries.add(ModBlocks.SHIROMORIKA_FENCE_GATE);
                        entries.add(ModBlocks.SHIROMORIKA_PRESSURE_PLATE);
                        entries.add(ModBlocks.SHIROMORIKA_BUTTON);

                    }).build());

    public static void registerItemGroups() {
        AChristmasTale.LOGGER.info("[" + AChristmasTale.MOD_ID + "] Adding items to custom groups");
    }
}
