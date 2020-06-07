package com.arreme.mtt3.domain.generation.dimension;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

import java.util.function.BiFunction;

public class ModDimensionOne extends ModDimension {

    @Override
    public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
        return DimensionOne::new;
    }
}
