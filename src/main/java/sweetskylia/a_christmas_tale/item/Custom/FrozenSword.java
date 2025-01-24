package sweetskylia.a_christmas_tale.item.Custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class FrozenSword extends SwordItem {
    public FrozenSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        return super.useOnBlock(context);
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


//            spawnParticles(target.getWorld(), target.getBlockPos(), ParticleTypes.EXPLOSION);
        }

        return super.postHit(context, target, attacker);
    }

    private void spawnParticles(World world, BlockPos pos, ParticleEffect particles){

        System.out.println(world.isClient);
        if (world.isClient){
        double radius = 1.5;
        for (int i = 0; i < 100; i++) {
            double xOffset = (world.random.nextDouble() - 0.5) * 2 * radius; // Décalage aléatoire en x
            double yOffset = (world.random.nextDouble() - 0.5) * 2 * radius; // Décalage aléatoire en y
            double zOffset = (world.random.nextDouble() - 0.5) * 2 * radius; // Décalage aléatoire en z


            double x = (pos.getX() + xOffset);
            double y = (pos.getY() + yOffset + 1);
            double z = (pos.getZ() + zOffset);

            System.out.println("Particle: " + particles.toString() + "x: " + x + "y: " + y + "z: " + z);
            world.addParticle(particles,true, x, y, z, 0, 0, 0);
        }

        }
        }//Nombres de particules

}
