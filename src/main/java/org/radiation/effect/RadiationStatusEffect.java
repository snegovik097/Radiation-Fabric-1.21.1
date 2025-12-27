package org.radiation.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class RadiationStatusEffect extends StatusEffect {

    public RadiationStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x4EFD8A); // green-ish color
        this.addAttributeModifier(
                EntityAttributes.MOVEMENT_SPEED,
                Identifier.of("rad_eff"),
                -0.15D,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        int interval = Math.max(20, 40 - amplifier * 5); // hurt roughly every 1-2s
        long gameTime = world.getTime();
        if (gameTime % interval != 0) {
            return false;
        }

        float damage = 1.0F + amplifier * 0.5F;
        var damageSource = world.getDamageSources().magic();

        entity.damage(world, damageSource, damage);
        return true;
    }
}

