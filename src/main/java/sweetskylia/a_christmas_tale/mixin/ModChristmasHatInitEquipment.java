package sweetskylia.a_christmas_tale.mixin;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.item.ModItems;

@Mixin(MobEntity.class)
public class ModChristmasHatInitEquipment {
    @Inject(method = "initEquipment", at = @At("TAIL"))
    protected void addChristmasHatOnHead(Random random, LocalDifficulty localDifficulty, CallbackInfo ci){
        MobEntity mobEntity = (MobEntity) (Object) this; //cast

        if (!(mobEntity.getWorld() instanceof ServerWorld serverWorld)) {
            return;
        }
        RegistryEntry<Biome> biomeEntry = serverWorld.getBiome(mobEntity.getBlockPos());
        if (biomeEntry.isIn(ConventionalBiomeTags.IS_COLD)) {
            if (random.nextFloat() < 0.15F) {
                ItemStack christmasHat = new ItemStack(ModItems.CHRISTMAS_HAT);
                mobEntity.equipStack(EquipmentSlot.HEAD, christmasHat);
            }
        }
    }


}
