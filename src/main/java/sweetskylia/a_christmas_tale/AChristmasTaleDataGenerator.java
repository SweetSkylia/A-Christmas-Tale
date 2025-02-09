package sweetskylia.a_christmas_tale;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import sweetskylia.a_christmas_tale.datagen.*;
import sweetskylia.a_christmas_tale.world.ModConfiguredFeatures;
import sweetskylia.a_christmas_tale.world.ModPlacedFeatures;
import sweetskylia.a_christmas_tale.world.biome.ModBiomes;

public class AChristmasTaleDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);
		pack.addProvider(ModWorldGenerator::new);
	}

	public void buildRegistry(RegistryBuilder registryBuilder){
		 registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
		 registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		 registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
	}
}
