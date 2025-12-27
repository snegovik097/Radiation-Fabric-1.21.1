package org.radiation;

import net.fabricmc.api.ModInitializer;
import org.radiation.registry.ModBlocks;
import org.radiation.registry.ModEffects;
import org.radiation.registry.ModItemGroups;
import software.bernie.geckolib.GeckoLib;

public class Radiation implements ModInitializer {

    public static final String MOD_ID = "radiation";

    @Override
    public void onInitialize() {
        ModEffects.register();
        ModBlocks.register();
        ModItemGroups.register();
        GeckoLib.initialize();
    }
}
