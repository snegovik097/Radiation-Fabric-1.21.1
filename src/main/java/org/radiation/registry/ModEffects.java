package org.radiation.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.radiation.Radiation;
import org.radiation.effect.RadiationStatusEffect;

public final class ModEffects {
    public static StatusEffect RADIATION;

    private ModEffects() {
    }

    public static void register() {
        RADIATION = register("radiation", new RadiationStatusEffect());
    }

    private static StatusEffect register(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(Radiation.MOD_ID, name), effect);
    }
}

