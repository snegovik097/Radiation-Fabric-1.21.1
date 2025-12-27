package org.radiation.client.model;

import net.minecraft.util.Identifier;
import org.radiation.Radiation;
import org.radiation.item.RadiationArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class RadiationArmorModel extends GeoModel<RadiationArmorItem> {

    @Override
    public Identifier getModelResource(RadiationArmorItem animatable) {
        // Путь к .geo.json файлу
        return Identifier.of(Radiation.MOD_ID, "geo/radiation_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(RadiationArmorItem animatable) {
        // Путь к текстуре .png
        return Identifier.of(Radiation.MOD_ID, "textures/armor/radiation_armor.png");
    }

    @Override
    public Identifier getAnimationResource(RadiationArmorItem animatable) {
        // Путь к .animation.json файлу
        return Identifier.of(Radiation.MOD_ID, "animations/radiation_armor.animation.json");
    }
}