package sweetskylia.a_christmas_tale.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CANDY = new FoodComponent.Builder().alwaysEdible().nutrition(3)
            .saturationModifier(0.25f).build();

    public static final FoodComponent HOT_CHOCOLATE = new FoodComponent.Builder().alwaysEdible().nutrition(3)
            .saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100*20, 2), 100.0f).build();

}
