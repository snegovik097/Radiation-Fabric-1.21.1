package org.radiation.registry;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.radiation.Radiation;
import java.util.List;
import java.util.Map;

public class ModArmorMaterials {
    // РАДИАЦИОННАЯ БРОНЯ — защита, энчант, звук, ремонт снегом
    public static final RegistryEntry<ArmorMaterial> RADIATION_MATERIAL = register("radiation",
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3
            ), 15, 2.0f, 0.1f);

    private static RegistryEntry<ArmorMaterial> register(String name, Map<ArmorItem.Type, Integer> defense,
                                                         int enchantability, float toughness, float knockbackResistance) {
        Identifier id = Identifier.of(Radiation.MOD_ID, name);
        ArmorMaterial material = new ArmorMaterial(
                defense, enchantability, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                () -> Ingredient.ofItems(ModBlocks.RADIATION_SNOW), // Ремонт снегом
                List.of(new ArmorMaterial.Layer(id)), toughness, knockbackResistance);
        return Registry.registerReference(Registries.ARMOR_MATERIAL, id, material);
    }
}
