package sweetskylia.a_christmas_tale.item.Custom;

import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.item.Item;

public class HotChocolate extends Item {

    public HotChocolate(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

//    @Override
//    public SoundEvent getDrinkSound() {
//        return super.getDrinkSound();
//    }

//    public SoundEvent getEatSound() {
//        return super.;
//    }


}