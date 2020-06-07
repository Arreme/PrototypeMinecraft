package com.arreme.mtt3.event.mobs;

import com.arreme.mtt3.ModTry3;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModTry3.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MainEventHandler {

    @SubscribeEvent
    public static void mainSpawnHandler(EntityJoinWorldEvent event) {
        ModTry3.LOGGER.info("Hey" + event.getEntity().getName().getFormattedText());
    }

}
