package sweetskylia.a_christmas_tale.world.tree;

import net.minecraft.block.SaplingGenerator;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator RED_OMORIKA = new SaplingGenerator(AChristmasTale.MOD_ID + ":red_omorika",
            Optional.empty(), Optional.of(ModConfiguredFeatures.RED_OMORIKA_KEY),Optional.empty());

    public static final SaplingGenerator SHIROMORIKA = new SaplingGenerator(AChristmasTale.MOD_ID + ":shiromorika",
            Optional.empty(), Optional.of(ModConfiguredFeatures.SHIROMORIKA_KEY), Optional.empty());
}
