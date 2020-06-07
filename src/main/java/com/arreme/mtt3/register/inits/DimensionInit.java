package com.arreme.mtt3.register.inits;

import com.arreme.mtt3.ModTry3;
import com.arreme.mtt3.domain.generation.dimension.ModDimensionOne;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {

    public static final DeferredRegister<ModDimension> DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS,ModTry3.MOD_ID);

    public static final RegistryObject<ModDimension> DIMENSION_ONE = DIMENSIONS.register("dimension_one", () -> new ModDimensionOne());
}
