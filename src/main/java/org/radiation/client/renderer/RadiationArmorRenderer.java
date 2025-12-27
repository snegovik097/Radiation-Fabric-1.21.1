package org.radiation.client.renderer;

import org.radiation.client.model.RadiationArmorModel;
import org.radiation.item.RadiationArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RadiationArmorRenderer extends GeoArmorRenderer<RadiationArmorItem> {
    public RadiationArmorRenderer() {
        super(new RadiationArmorModel());
    }
}
