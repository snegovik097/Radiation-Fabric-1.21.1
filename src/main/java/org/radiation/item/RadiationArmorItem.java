package org.radiation.item;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import org.radiation.client.renderer.RadiationArmorRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.event.GeoRenderEvent;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class RadiationArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    // Для GeckoLib 4.8.2 на Fabric используем этот способ:
//    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    private final Supplier<GeoRenderEvent.Object> renderProvider = GeoRenderProvider(this);

    public RadiationArmorItem(RegistryEntry<ArmorMaterial> material, ArmorItem.Type type, Settings settings) {
        super(material, type, settings);
    }


    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private RadiationArmorRenderer renderer;


            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(
                    LivingEntity livingEntity,
                    ItemStack itemStack,
                    EquipmentSlot equipmentSlot,
                    BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null) {
                    this.renderer = new RadiationArmorRenderer();
                }

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, state ->
                state.setAndContinue(RawAnimation.begin().thenLoop("idle"))
        ));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }
}