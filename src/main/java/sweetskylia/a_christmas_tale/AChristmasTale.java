package sweetskylia.a_christmas_tale;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sweetskylia.a_christmas_tale.block.ModBlocks;
import sweetskylia.a_christmas_tale.entity.ModEntities;
import sweetskylia.a_christmas_tale.entity.custom.ReindeerEntity;
import sweetskylia.a_christmas_tale.item.ModItemGroups;
import sweetskylia.a_christmas_tale.item.ModItems;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.item.ItemStack;
import sweetskylia.a_christmas_tale.world.gen.ModWorldGeneration;
import sweetskylia.a_christmas_tale.world.tree.ModTrunkPlacerTypes;

import java.util.UUID;

public class AChristmasTale implements ModInitializer {
    public static final String MOD_ID = "a_christmas_tale";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final int CHECK_ITEM_INTERVAL = 100; // toutes les 5 sec
    private int tickWorldCounter = 0;

    //====================================
    //Transformation en Frozen Stellar Heart
    private boolean isBiomeCold(ServerWorld world, ItemEntity itemEntity) {
        RegistryEntry<Biome> biomeEntry = world.getBiome(itemEntity.getBlockPos()); //On récup le biome
        return biomeEntry.isIn(ConventionalBiomeTags.IS_COLD); //On regarde s'il fait parti des biomes froid
    }

    private void ConvertToFrozenStellarHeart(ServerWorld world, ItemEntity itemEntity) {
        int numberOfItems = itemEntity.getStack().getCount();
        ItemStack stack = new ItemStack(ModItems.FROZEN_STELLAR_HEART, numberOfItems);
        itemEntity.setStack(stack);
    }
    //====================================

    private void checkEntitiesInWorld(ServerWorld world) {
        Box box = new Box( //Récup des coordonnées du monde
                world.getWorldBorder().getBoundWest(),
                world.getBottomY(),
                world.getWorldBorder().getBoundNorth(),
                world.getWorldBorder().getBoundEast(),
                world.getTopYInclusive(),
                world.getWorldBorder().getBoundSouth()
        );
        //Pour chaque item on regarde si c'est un Stellar Heart & qu'il est dans un biome froid
        world.getEntitiesByClass(ItemEntity.class, box, itemEntity -> itemEntity.isTouchingWater())
                .forEach(itemEntity -> {
                    if ((itemEntity.getStack().getItem() == ModItems.STELLAR_HEART) && (isBiomeCold(world, itemEntity))) {
                        ConvertToFrozenStellarHeart(world, itemEntity);
                        spawnSnowParticles(world, itemEntity);
                    }
                });
    }

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModWorldGeneration.generateModWorldGen();
        ModTrunkPlacerTypes.register();

        //STELLAR HEART TO FROZEN STELLAR HEART EVENT
        ServerTickEvents.START_WORLD_TICK.register(world -> {
            if (++tickWorldCounter >= CHECK_ITEM_INTERVAL) {
                tickWorldCounter = 0;
                checkEntitiesInWorld(world);
            }
        });

        ServerMessageEvents.CHAT_MESSAGE.register( (message, sender, params) ->{
            String rawText = message.getContent().getString();
            if (rawText.toLowerCase().contains("omorika")) {
                sender.getServer().execute(() -> {
                    sender.sendMessage(Text.literal("En mémoire de Mattéo").withColor(2262471));
                    sender.sendMessage(Text.literal("Merci pour tout.").withColor(2262471));
                });

            }
        });


        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.STELLAR_ICE)
                .destDimID(Identifier.of("the_nether"))
                .tintColor(131, 66, 184)
                .registerPortal();

		//INIT WOOD PROPERTIES
		StrippableBlockRegistry.register(ModBlocks.RED_OMORIKA_LOG, ModBlocks.STRIPPED_RED_OMORIKA_LOG);
		StrippableBlockRegistry.register(ModBlocks.RED_OMORIKA_WOOD, ModBlocks.STRIPPED_RED_OMORIKA_WOOD);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_OMORIKA_LOG, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_OMORIKA_WOOD, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_RED_OMORIKA_LOG, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_RED_OMORIKA_WOOD, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_OMORIKA_PLANKS, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_OMORIKA_LEAVES, 30,60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_OMORIKA_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_OMORIKA_STAIRS, 5, 20);

        StrippableBlockRegistry.register(ModBlocks.SHIROMORIKA_LOG, ModBlocks.STRIPPED_SHIROMORIKA_LOG);
		StrippableBlockRegistry.register(ModBlocks.SHIROMORIKA_WOOD, ModBlocks.STRIPPED_SHIROMORIKA_WOOD);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SHIROMORIKA_LOG, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SHIROMORIKA_WOOD, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SHIROMORIKA_LOG, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SHIROMORIKA_WOOD, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SHIROMORIKA_PLANKS, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SHIROMORIKA_LEAVES, 30,60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SHIROMORIKA_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SHIROMORIKA_STAIRS, 5, 20);

        FabricDefaultAttributeRegistry.register(ModEntities.REINDEER, ReindeerEntity.createAttributes());
    }


    private void spawnSnowParticles(World world, ItemEntity itemEntity) {
        if (world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ParticleTypes.SNOWFLAKE, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 50, 0.4, 0.4, 0.4, 0.1);
        }
    }


}