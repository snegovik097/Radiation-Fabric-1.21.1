package org.radiation.client;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.radiation.client.renderer.RadiationArmorRenderer;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RadiationArmorClient {
    private static RadiationArmorRenderer renderer;

    public static BipedEntityModel<LivingEntity> getModel
            (LivingEntity livingEntity,
             ItemStack itemStack,
             EquipmentSlot equipmentSlot,
             BipedEntityModel<LivingEntity> original) {
        if (renderer == null) {
            renderer = new RadiationArmorRenderer();
        }
        renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
        return renderer;
    }
}
