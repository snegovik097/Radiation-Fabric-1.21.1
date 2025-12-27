package org.radiation.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar;

public class RadiationArmorItem extends ArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache =
            new SingletonAnimatableInstanceCache(this);

    public RadiationArmorItem(
            RegistryEntry<ArmorMaterial> material,
            Type type,
            Settings settings
    ) {
        super(material, type, settings);

        // ОБЯЗАТЕЛЬНО для GeoItem (sync)
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    /**
     * ОБЯЗАТЕЛЬНО в GeckoLib 4.8+
     * Даже если анимаций пока нет
     */
    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        // Пока без анимаций
    }
}
