package sweetskylia.a_christmas_tale.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CANDY = new FoodComponent.Builder().alwaysEdible().nutrition(3)
            .saturationModifier(0.25f).build();

    public static final FoodComponent HOT_CHOCOLATE = new FoodComponent.Builder().alwaysEdible().nutrition(3)
            .saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 3 * 20, 1), 100.0f).build();

    public static final FoodComponent FROZEN_FRUIT = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(3)
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 5 * 20, 0), 60.0f)
            .saturationModifier(0.50f).build();

    public static final FoodComponent FROZEN_FRUIT_PIE = new FoodComponent.Builder()
            .nutrition(8)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 180 * 20, 0), 100.0f)
            .saturationModifier(0.7f)
            .build();

    public static final FoodComponent MANNELE = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.7f)
            .build();
}
