package sweetskylia.a_christmas_tale.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen(){
        ModOreGeneration.generateOres();
        ModVegetationGeneration.generateVegetation();
    }
}
