package org.radiation;

import net.fabricmc.api.ModInitializer;
import org.radiation.registry.ModBlocks;
import org.radiation.registry.ModEffects;
import org.radiation.registry.ModItemGroups;
import org.radiation.registry.ModItems;

public class Radiation implements ModInitializer {

    public static final String MOD_ID = "radiation";

    @Override
    public void onInitialize() {
        // Регистрация эффектов, блоков и предметов
        ModEffects.register();
        ModBlocks.register();
        ModItems.registerItems();
        ModItemGroups.register();

        // GeckoLib.initialize() в версии 4.8.2/5.0 больше не требуется
    }

}