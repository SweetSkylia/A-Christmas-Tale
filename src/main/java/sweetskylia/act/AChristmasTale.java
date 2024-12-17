package sweetskylia.act;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sweetskylia.act.item.ModItems;

public class AChristmasTale implements ModInitializer {
	public static final String MOD_ID = "a_christmas_tale";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();
		LOGGER.info("Hello Fabric world!");
	}
}