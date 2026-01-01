package org.radiation.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.radiation.Radiation;
import org.radiation.item.RadiationArmorItem;

public class ModItems {

    public static final RadiationArmorItem RADIATION_HELMET =
            new RadiationArmorItem(
                    ModArmorMaterials.RADIATION_MATERIAL,
                    RadiationArmorItem.Type.HELMET,
                    new Item.Settings().maxCount(1)
            );

    public static void registerItem() {
         Registry.register(
                Registries.ITEM,
                Identifier.of(Radiation.MOD_ID, "radiation_helmet"),
                RADIATION_HELMET
        );
    }
}
