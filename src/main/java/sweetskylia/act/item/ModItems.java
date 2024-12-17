package sweetskylia.act.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sweetskylia.act.AChristmasTale;

public class ModItems {
    public static final Item CANDY = registerItem("candy", new Item(new Item.Settings().food(ModFoodComponents.CANDY)));
    public static final Item SNOWFLAKE = registerItem("snowflake", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AChristmasTale.MOD_ID, name), item);
    }

    public static void registerModItems(){
        AChristmasTale.LOGGER.info("Registering Mod Items for " + AChristmasTale.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(CANDY);
            entries.add(SNOWFLAKE);
        } );
    }
}
