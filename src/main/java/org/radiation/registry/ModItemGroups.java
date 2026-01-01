package org.radiation.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.radiation.Radiation;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemGroups {
    public static final ItemGroup RADIATION_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Radiation.MOD_ID, "radiation_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.RADIATION_SNOW))
                    .displayName(Text.translatable("itemGroup.radiation.radiation_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RADIATION_SNOW);
                        entries.add(ModItems.RADIATION_HELMET);
                    })
                    .build());


    public static void register() {
        // Метод может быть пустым, главное чтобы класс загрузился
    }
}