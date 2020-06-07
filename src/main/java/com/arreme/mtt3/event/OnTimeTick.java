package com.arreme.mtt3.event;

import com.arreme.mtt3.ModTry3;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

//This should be created when the world is created
@Mod.EventBusSubscriber(modid = ModTry3.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnTimeTick {

    private static int tick;
    public static long time;

    @SubscribeEvent
    public static void worldTick(TickEvent.WorldTickEvent event) {
        tick++;
        if (tick == 16) { //1 second in real life
            tick = 0;
            try {
                ModTry3.LOGGER.info(clockCalculator(event.world));
                time = event.world.getDayTime();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String clockCalculator(World world) throws Exception{
        int day = ((int) world.getDayTime()+6000)/24000;
        int minutes = ((int) world.getDayTime() - ((int) world.getDayTime()/1000)*1000)/16;
        int hours = ((int) world.getDayTime()/1000 - 24*day)+6;
        String convert = hours+":"+minutes;
        DateFormat date = new SimpleDateFormat("HH:mm");
        return day +" "+date.format(date.parse(convert));
    }

}