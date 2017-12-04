package com.lethalleonard.villagedefence.MobWaves;

import com.lethalleonard.villagedefence.Utils.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class mobSpawning
{
    public static final int baseSpawnCreeper = 4;
    public static final int baseSpawnZombie = 10;
    public static final int baseSpawnEnderman = 2;
    public static double difficulty = 0;


    @SubscribeEvent
    public void spawnMobs(WorldTickEvent event)
    {
        //makes it so that it's called at the end of the tick, only in the overworld, and serverside
        if(event.phase == TickEvent.Phase.END && event.world.provider.getDimension() ==0
                && event.side == Side.SERVER)
        {
            //fires at 10PM every in-game day
            if(event.world.getWorldTime()%24000 == 22000)
            {
                //gets the current day in-game
                int currDay = DifficultyScaling.getCurrDay(event.world);

                //sets the current difficulty
                difficulty = DifficultyScaling.getDifficulty(currDay);
                LogHelper.logInfo("It's 10 PM!");
            }
        }
    }
}
