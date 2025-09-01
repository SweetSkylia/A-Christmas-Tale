package sweetskylia.a_christmas_tale.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class BlizzardEffect {
    public static void spawn(World world, BlockPos center, PlayerEntity caster) {
        int radius = 10;
        int duration = 8 *20;


        for (int i = 0; i < 500; i++) {
            double offsetX = world.random.nextGaussian() * radius;
            double offsetZ = world.random.nextGaussian() * radius;
            double offsetY = world.random.nextDouble() * 3;

            ((ServerWorld) world).spawnParticles(
                    ParticleTypes.SNOWFLAKE,
                    center.getX() + offsetX,
                    center.getY() + offsetY,
                    center.getZ() + offsetZ,
                    1,5,0,5,0.3
            );
            if (i % 8 == 0) {
            ((ServerWorld) world).spawnParticles(
                    ParticleTypes.POOF,
                    center.getX() + offsetX,
                    center.getY() + offsetY,
                    center.getZ() + offsetZ,
                    1,0,0,0,0.1
            );
            }
        }


        Box area = new Box(
                new Vec3d(center.getX() - radius, center.getY() - 2, center.getZ() - radius),
                new Vec3d( center.getX() + radius, center.getY() + 4, center.getZ() + radius)
        );

        List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, area, e -> e != caster);
        for (LivingEntity entity : entities) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, duration, 1));
        }
    }
}
