package org.radiation.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.radiation.registry.ModEffects;

import java.util.List;

public class RadiationSnowLayerBlock extends Block {
    // Свойство слоев (как у ванильного снега)
    public static final IntProperty LAYERS = Properties.LAYERS;

    // Массив форм хитбокса для каждого из 8 слоев
    protected static final VoxelShape[] LAYERS_TO_SHAPE = new VoxelShape[]{
            VoxelShapes.empty(),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
    };

    public RadiationSnowLayerBlock(Settings settings) {
        super(settings);
        // Устанавливаем 1 слой по умолчанию
        this.setDefaultState(this.stateManager.getDefaultState().with(LAYERS, 1));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LAYERS_TO_SHAPE[state.get(LAYERS)];
    }

    // Позволяет наслаивать блоки при клике правой кнопкой мыши
    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        int i = state.get(LAYERS);
        if (context.getStack().isOf(this.asItem()) && i < 8) {
            return context.canReplaceExisting();
        }
        return i == 1;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockState = context.getWorld().getBlockState(context.getBlockPos());
        if (blockState.isOf(this)) {
            int i = blockState.get(LAYERS);
            return blockState.with(LAYERS, Math.min(8, i + 1));
        }
        return super.getPlacementState(context);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }

    // Радиация вокруг блока (Scheduled Tick)
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int layers = state.get(LAYERS);
        // Если слоев больше 4, даем Радиацию II (amplifier 1), иначе Радиацию I (0)
        int amplifier = layers > 4 ? 1 : 0;
        // Радиус ауры равен количеству слоев
        double radius = (double) layers;

        Box box = new Box(pos).expand(radius);
        List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, box, entity -> true);

        // В 1.21.6 получаем RegistryEntry напрямую
        var effectEntry = Registries.STATUS_EFFECT.getEntry(ModEffects.RADIATION);

        for (LivingEntity entity : entities) {
            entity.addStatusEffect(new StatusEffectInstance(effectEntry, 60, amplifier, false, true));
        }

        // Перезапуск тика через 1 секунду (20 тиков)
        world.scheduleBlockTick(pos, this, 20);
    }

    // Радиация при наступании на блок
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && entity instanceof LivingEntity living) {
            int amplifier = state.get(LAYERS) > 4 ? 1 : 0;
            var effectEntry = Registries.STATUS_EFFECT.getEntry(ModEffects.RADIATION);

            living.addStatusEffect(new StatusEffectInstance(effectEntry, 60, amplifier, false, true));
        }
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient) {
            world.scheduleBlockTick(pos, this, 20);
        }
    }
}