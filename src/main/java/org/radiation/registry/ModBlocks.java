package org.radiation.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.radiation.Radiation;
import org.radiation.block.RadiationSnowLayerBlock;

public final class ModBlocks {

    // Оставляем только один основной блок
    public static Block RADIATION_SNOW;

    public static void register() {
        RADIATION_SNOW = registerBlock("radiation_snow");
    }

    private static Block registerBlock(String name) {
        Identifier id = Identifier.of(Radiation.MOD_ID, name);

        // Убираем .registryKey(blockKey), так как он вызывает ошибку
        Block block = new RadiationSnowLayerBlock(AbstractBlock.Settings.create()
                .strength(0.1F)
                .sounds(BlockSoundGroup.SNOW));

        // Регистрируем блок
        Registry.register(Registries.BLOCK, id, block);

        // Регистрируем предмет для блока (тоже без .registryKey)
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));

        return block;
    }
}