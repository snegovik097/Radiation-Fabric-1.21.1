package org.radiation.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class RadiationStatusEffect extends StatusEffect {
    public RadiationStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x33FF33);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        // В 1.21.1 метод damage теперь не требует World первым аргументом
        // Атрибуты теперь вызываются через GENERIC_...
        entity.damage(entity.getDamageSources().magic(), 1.0f * (amplifier + 1));
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }
}