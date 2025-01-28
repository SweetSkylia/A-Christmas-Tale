package sweetskylia.a_christmas_tale;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.entity.ItemEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sweetskylia.a_christmas_tale.block.ModBlocks;
import sweetskylia.a_christmas_tale.item.ModItemGroups;
import sweetskylia.a_christmas_tale.item.ModItems;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.item.ItemStack;
import sweetskylia.a_christmas_tale.world.gen.ModWorldGeneration;

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
				world.getTopY(),
				world.getWorldBorder().getBoundSouth()
		);
		//Pour chaque item on regarde si c'est un Stellar Heart & qu'il est dans un biome froid
		world.getEntitiesByClass(ItemEntity.class,box, itemEntity -> itemEntity.isTouchingWater())
				.forEach(itemEntity -> {
					if ((itemEntity.getStack().getItem() == ModItems.STELLAR_HEART) && (isBiomeCold(world, itemEntity))) {
						ConvertToFrozenStellarHeart(world,itemEntity);
						spawnSnowParticles(world, itemEntity);
					}
				});
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
		LOGGER.info("uwu");

		ServerTickEvents.START_WORLD_TICK.register(world -> {
			if (++tickWorldCounter >= CHECK_ITEM_INTERVAL) {
				tickWorldCounter = 0;
				checkEntitiesInWorld(world);
			}
		});

		}

		
private void spawnSnowParticles(World world, ItemEntity itemEntity) {
	if (world instanceof ServerWorld serverWorld) {
		serverWorld.spawnParticles(ParticleTypes.SNOWFLAKE, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 50, 0.4, 0.4, 0.4, 0.1);
	}
}





}