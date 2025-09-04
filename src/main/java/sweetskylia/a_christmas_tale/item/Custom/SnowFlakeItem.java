package sweetskylia.a_christmas_tale.item.Custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sweetskylia.a_christmas_tale.util.BlizzardEffect;

public class SnowFlakeItem extends Item {

    public SnowFlakeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            BlockPos pos = user.getBlockPos();
            BlizzardEffect.spawn(world, pos, user);
            if (!user.isCreative()) {
                user.getStackInHand(hand).decrement(1);
            }
            user.getItemCooldownManager().set(stack, 200);
        }
        return ActionResult.SUCCESS;
    }
}
