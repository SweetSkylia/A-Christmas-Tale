package sweetskylia.a_christmas_tale.item.Custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;


public class FrozenSword extends SwordItem {
    public FrozenSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        return super.useOnBlock(context);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return ToolMaterials.IRON.getEnchantability();
    }

    @Override
    public boolean postHit(ItemStack context, LivingEntity target, LivingEntity attacker) {
        if(target != null && !target.getWorld().isClient){
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,60,2));
            target.playSound(SoundEvents.ENTITY_PLAYER_HURT_FREEZE);
            target.getWorld().playSound(null, target.getBlockPos(), SoundEvents.ENTITY_PLAYER_HURT_FREEZE, net.minecraft.sound.SoundCategory.AMBIENT, 1.0F, 1.0F);

            World world = target.getWorld();
            if (world instanceof ServerWorld serverWorld) {
                serverWorld.getPlayers(player -> player.squaredDistanceTo(target) < 100).forEach(player -> {
                    ((ServerWorld) player.getWorld()).spawnParticles(
                            ParticleTypes.SNOWFLAKE,
                            target.getX(), target.getY(), target.getZ(), 60, 0.5, 1,0.5, 0.0);
                });}


        }

        return super.postHit(context, target, attacker);
    }

}
