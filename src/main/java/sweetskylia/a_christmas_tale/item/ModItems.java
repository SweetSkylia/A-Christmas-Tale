package sweetskylia.a_christmas_tale.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentModels;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.block.ModBlocks;
import sweetskylia.a_christmas_tale.entity.ModEntities;
import sweetskylia.a_christmas_tale.item.Custom.*;

import java.util.function.Function;

public class ModItems {
    public static final Item CANDY = registerItem("candy",
        settings -> new Item(settings.food(ModFoodComponents.CANDY)));

    public static final Item SNOWFLAKE = registerItem("snowflake",
        settings -> new SnowFlakeItem(settings));

    public static final Item STELLAR_HEART = registerItem("stellar_heart",
            settings -> new Item(settings));
    public static final Item FROZEN_STELLAR_HEART = registerItem("frozen_stellar_heart",
            settings -> new Item(settings));
    public static final Item HOT_CHOCOLATE = registerItem("hot_chocolate",
            settings -> new HotChocolate(settings.food(ModFoodComponents.HOT_CHOCOLATE, ModFoodComponents.HOT_CHOCOLATE_EFFECT)));

    public static final Item SNOW_CANNON = registerItem("snow_cannon",
            settings -> new SnowCannon(settings));

    public static final Item FROZEN_SWORD = registerItem("frozen_sword",
            settings -> new FrozenSword(ToolMaterial.IRON, 3, 5f, settings.enchantable(14)));


    public static final Item FROZEN_FRUIT_PIE = registerItem("frozen_fruit_pie",
            settings -> new Item(settings.food(ModFoodComponents.FROZEN_FRUIT_PIE, ModFoodComponents.FROZEN_FRUIT_PIE_EFFECT)));

    public static final Item REINDEER_SPAWN_EGG = registerItem("reindeer_spawn_egg",
            settings -> new SpawnEggItem(ModEntities.REINDEER, 0x947165, 0xbdbdbd, settings));

    public static final Item STELLAR_CANDY_SWORD = registerItem("stellar_candy_sword",
            settings -> new SwordItem(ModToolMaterials.STELLAR_CANDY,3,-2.4F, settings));

    public static final Item STELLAR_CANDY_PICKAXE = registerItem("stellar_candy_pickaxe",
            settings -> new PickaxeItem(ModToolMaterials.STELLAR_CANDY ,1.0F, -2.8F,settings));

    public static final Item STELLAR_CANDY_AXE = registerItem("stellar_candy_axe",
            settings -> new AxeItem(ModToolMaterials.STELLAR_CANDY,6.0F,-3.1F, settings));

    public static final Item STELLAR_CANDY_SHOVEL = registerItem("stellar_candy_shovel",
            settings -> new ShovelItem(ModToolMaterials.STELLAR_CANDY, 1.5F , -3.0F,settings));

    public static final Item STELLAR_CANDY_HOE = registerItem("stellar_candy_hoe",
            settings ->  new HoeItem(ModToolMaterials.STELLAR_CANDY,0, -1.0F,settings));

    public static final Item FROZEN_FRUIT = registerItem("frozen_fruit",
            settings -> new BlockItem(ModBlocks.FROZEN_BUSH, settings.food(ModFoodComponents.FROZEN_FRUIT, ModFoodComponents.FROZEN_FRUIT_EFFECT)));

    public static final Item CHRISTMAS_HAT = registerItem("christmas_hat",
            settings -> new Item(settings.component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.HEAD).equipSound(SoundEvents.ITEM_ARMOR_EQUIP_GENERIC).damageOnHurt(false).build())));


private static Item registerItem(String name, Function<Item.Settings, Item> function) {
    return Registry.register(Registries.ITEM, Identifier.of(AChristmasTale.MOD_ID, name),
            function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AChristmasTale.MOD_ID, name)))));
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
