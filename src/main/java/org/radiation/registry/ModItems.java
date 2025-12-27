package org.radiation.registry;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.radiation.item.RadiationArmorItem;

public class ModItems {

    // Регистрация нашего 3D шлема
    public static final Item RADIATION_HELMET = Registry.register(Registries.ITEM,
            Identifier.of("radiation", "radiation_helmet"),
            new RadiationArmorItem(ModArmorMaterials.RADIATION_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1)));

    // Вспомогательный метод для регистрации
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of("radiation", name), item);
    }

    public static void registerModItems() {
        // Метод для вызова в главном классе (Radiation.java), чтобы предметы загрузились
    }
}
