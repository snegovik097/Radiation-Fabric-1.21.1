package org.radiation.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;

public class RadiationStatusEffect extends StatusEffect {

    public RadiationStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x00ff00);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            DamageSource damageSource = entity.getWorld().getDamageSources().magic();
            float damage = 1.0f + (amplifier * 0.5f);
            entity.damage(damageSource, damage);
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
