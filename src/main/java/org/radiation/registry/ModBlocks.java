package org.radiation.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
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
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);

        Block block = new RadiationSnowLayerBlock(AbstractBlock.Settings.create()
                .strength(0.1F)
                .sounds(BlockSoundGroup.SNOW));

        Registry.register(Registries.BLOCK, blockKey, block);
        Registry.register(Registries.ITEM, itemKey, new BlockItem(block, new Item.Settings()));

        return block;
    }
}