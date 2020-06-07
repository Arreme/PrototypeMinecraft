package com.arreme.mtt3.util;

import com.arreme.mtt3.ModTry3;
import com.arreme.mtt3.register.inits.DimensionInit;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModTry3.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(ModTry3.example_dim_type) == null) {
            DimensionManager.registerDimension(ModTry3.example_dim_type, DimensionInit.DIMENSION_ONE.get(),null,true);
        }

        ModTry3.LOGGER.info("Dimensions Registered");
    }
}
