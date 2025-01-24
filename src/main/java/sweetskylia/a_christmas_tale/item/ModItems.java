package sweetskylia.a_christmas_tale.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.item.Custom.FrozenSword;
import sweetskylia.a_christmas_tale.item.Custom.HotChocolate;

public class ModItems {
    public static final Item CANDY = registerItem("candy", new Item(new Item.Settings().food(ModFoodComponents.CANDY)));
    public static final Item SNOWFLAKE = registerItem("snowflake", new Item(new Item.Settings()));
    public static final Item STELLAR_HEART = registerItem("stellar_heart", new Item(new Item.Settings()));
    public static final Item FROZEN_STELLAR_HEART = registerItem("frozen_stellar_heart", new Item(new Item.Settings()));
    public static final Item HOT_CHOCOLATE = registerItem("hot_chocolate", new HotChocolate(new HotChocolate.Settings().food(ModFoodComponents.HOT_CHOCOLATE)));

    public static final Item FROZEN_SWORD = registerItem("frozen_sword",new FrozenSword(ToolMaterials.IRON, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 3, 5f))));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AChristmasTale.MOD_ID, name), item);
    }

    public static void registerModItems(){
        AChristmasTale.LOGGER.info("Registering Mod Items for " + AChristmasTale.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(CANDY);
            entries.add(SNOWFLAKE);
            entries.add(STELLAR_HEART);
            entries.add(FROZEN_STELLAR_HEART);
        } );
    }
}
