package sweetskylia.a_christmas_tale.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.block.ModBlocks;
import sweetskylia.a_christmas_tale.entity.ModEntities;
import sweetskylia.a_christmas_tale.item.Custom.*;

public class ModItems {
    public static final Item CANDY = registerItem("candy", new Item(new Item.Settings().food(ModFoodComponents.CANDY)));
    public static final Item SNOWFLAKE = registerItem("snowflake", new SnowFlakeItem(new Item.Settings()));
    public static final Item STELLAR_HEART = registerItem("stellar_heart", new Item(new Item.Settings()));
    public static final Item FROZEN_STELLAR_HEART = registerItem("frozen_stellar_heart", new Item(new Item.Settings()));
    public static final Item HOT_CHOCOLATE = registerItem("hot_chocolate", new HotChocolate(new HotChocolate.Settings().food(ModFoodComponents.HOT_CHOCOLATE)));

    public static final Item SNOW_CANNON = registerItem("snow_cannon", new SnowCannon(new Item.Settings()));
    public static final Item FROZEN_SWORD = registerItem("frozen_sword", new FrozenSword(ToolMaterials.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, 5f))));
    public static final Item FROZEN_FRUIT_PIE = registerItem("frozen_fruit_pie", new Item(new Item.Settings().food(ModFoodComponents.FROZEN_FRUIT_PIE)));

    public static final Item STELLAR_CANDY_SWORD = registerItem("stellar_candy_sword", new SwordItem(ModToolMaterials.STELLAR_CANDY, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STELLAR_CANDY, 3, -2.4F))));
    public static final Item STELLAR_CANDY_PICKAXE = registerItem("stellar_candy_pickaxe", new PickaxeItem(ModToolMaterials.STELLAR_CANDY, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STELLAR_CANDY, 1.0F, -2.8F))));
    public static final Item STELLAR_CANDY_AXE = registerItem("stellar_candy_axe", new AxeItem(ModToolMaterials.STELLAR_CANDY, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STELLAR_CANDY, 6.0F, -3.1F))));
    public static final Item STELLAR_CANDY_SHOVEL = registerItem("stellar_candy_shovel", new ShovelItem(ModToolMaterials.STELLAR_CANDY, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STELLAR_CANDY, 1.5F, -3.0F))));
    public static final Item STELLAR_CANDY_HOE = registerItem("stellar_candy_hoe", new HoeItem(ModToolMaterials.STELLAR_CANDY, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STELLAR_CANDY, 0, -1.0F))));

    public static final Item FROZEN_FRUIT = registerItem("frozen_fruit", new AliasedBlockItem(ModBlocks.FROZEN_BUSH,new Item.Settings().food(ModFoodComponents.FROZEN_FRUIT)));

    public static final Item CHRISTMAS_HAT = registerItem("christmas_hat", new ModWearableItems(new Item.Settings()));

    public static final Item REINDEER_SPAWN_EGG = registerItem("reindeer_spawn_egg",
            new SpawnEggItem(ModEntities.REINDEER, 0x947165, 0xbdbdbd,new Item.Settings()));

    //MANNALA (ici on est haut-rhinois, pas bas-rhinois)
    public static final Item MANNELE = registerItem("mannele", new Item(new Item.Settings().food(ModFoodComponents.MANNELE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AChristmasTale.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AChristmasTale.LOGGER.info("[" + AChristmasTale.MOD_ID + "] Adding items to vanilla groups");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SNOWFLAKE);
            entries.add(STELLAR_HEART);
            entries.add(FROZEN_STELLAR_HEART);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(FROZEN_SWORD);
            entries.add(STELLAR_CANDY_SWORD);
            entries.add(STELLAR_CANDY_PICKAXE);
            entries.add(STELLAR_CANDY_AXE);
            entries.add(STELLAR_CANDY_SHOVEL);
            entries.add(STELLAR_CANDY_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(HOT_CHOCOLATE);
            entries.add(CANDY);
        });
    }
}
