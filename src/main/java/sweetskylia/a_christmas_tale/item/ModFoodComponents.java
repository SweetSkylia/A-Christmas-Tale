package sweetskylia.a_christmas_tale.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    public static final FoodComponent CANDY = new FoodComponent.Builder().alwaysEdible().nutrition(3)
            .saturationModifier(0.25f).build();

    public static final FoodComponent HOT_CHOCOLATE = new FoodComponent.Builder().alwaysEdible().nutrition(3)
            .saturationModifier(0.25f).build();

    public static final ConsumableComponent HOT_CHOCOLATE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 3*20, 1),100.0f)).build();

    public static final FoodComponent FROZEN_FRUIT = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(3)
            .saturationModifier(0.50f).build();

    public static final ConsumableComponent FROZEN_FRUIT_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 5*20, 0), 60f)).build();

    public static final FoodComponent FROZEN_FRUIT_PIE = new FoodComponent.Builder()
            .nutrition(6)
            .build();

    public static final ConsumableComponent FROZEN_FRUIT_PIE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 180*20, 0), 100f)).build();
}
