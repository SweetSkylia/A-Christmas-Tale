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

                        entries.add(ModItems.SNOWFLAKE);
                        entries.add(ModItems.CANDY);
                        entries.add(ModItems.HOT_CHOCOLATE);
                        entries.add(ModBlocks.CANDY_BLOCK);

                        //CORE ORE
                        entries.add(ModBlocks.STELLAR_HEART_ORE);
                        entries.add(ModItems.STELLAR_HEART);
                    }).build());

    public static void registerItemGroups() {
        AChristmasTale.LOGGER.info("[" + AChristmasTale.MOD_ID + "] Registering Item Groups");
    }
}
