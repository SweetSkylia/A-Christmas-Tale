package sweetskylia.a_christmas_tale.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.entity.custom.ReindeerEntity;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> REINDEER_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(AChristmasTale.MOD_ID, "reindeer"));

    public static final EntityType<ReindeerEntity> REINDEER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(AChristmasTale.MOD_ID,"reindeer"),
            EntityType.Builder.create(ReindeerEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9F,1.4F).build(REINDEER_KEY));


    public static void registerModEntities() {
        AChristmasTale.LOGGER.info("[" + AChristmasTale.MOD_ID + "] "+ "Registering Mod Entities");
    }
}
