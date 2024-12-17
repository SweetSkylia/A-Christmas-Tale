package sweetskylia.act.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CANDY = new FoodComponent.Builder().alwaysEdible().nutrition(3)
            .saturationModifier(0.25f).build();
}
