package com.arreme.mtt3.register;

import com.arreme.mtt3.ModTry3;
import com.arreme.mtt3.client.gui.ExampleChestScreen;
import com.arreme.mtt3.register.inits.ContainerInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ModTry3.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ContainerInit.EXAMPLE_CHEST.get(), ExampleChestScreen::new);
    }
}
