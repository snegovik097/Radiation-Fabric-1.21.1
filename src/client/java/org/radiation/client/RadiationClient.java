package org.radiation.client;

import net.fabricmc.api.ClientModInitializer;
import org.radiation.client.renderer.RadiationArmorRenderer;
import org.radiation.registry.ModItems;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class RadiationClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        GeoItemRenderer.register(
                ModItems.RADIATION_HELMET,
                new RadiationArmorRenderer()
        );
    }
}
