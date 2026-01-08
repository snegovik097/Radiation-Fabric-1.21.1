package org.radiation.registry;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.util.Identifier;
import org.radiation.item.RadiationArmorItem;

public class ModItems {
    public static final RegistryEntry<ArmorMaterial> RADIATION_MATERIAL = ModArmorMaterials.RADIATION_MATERIAL;

    public static final Item RADIATION_HELMET = Registry.register(Registries.ITEM,
            Identifier.of("radiation", "radiation_helmet"),
            new RadiationArmorItem(RADIATION_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxCount(1))); // Combat tab

    public static final Item RADIATION_CHESTPLATE = Registry.register(Registries.ITEM,
            Identifier.of("radiation", "radiation_chestplate"),
            new RadiationArmorItem(RADIATION_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxCount(1)));

    public static final Item RADIATION_LEGGINGS = Registry.register(Registries.ITEM,
            Identifier.of("radiation", "radiation_leggings"),
            new RadiationArmorItem(RADIATION_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxCount(1)));

    public static final Item RADIATION_BOOTS = Registry.register(Registries.ITEM,
            Identifier.of("radiation", "radiation_boots"),
            new RadiationArmorItem(RADIATION_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxCount(1)));

    public static void registerModItems() {
        // Уже зарегистрировано статически
    }
}
