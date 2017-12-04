package com.lethalleonard.villagedefence.MobWaves;

import net.minecraft.world.World;

public class DifficultyScaling
{
    public static double getDifficulty(int currDay)
    {
        int dayOfWeek = (currDay + 1) % 7;
        int week = (int)Math.floor(currDay/7) + 1;
        double multiplier = dayMultiplier(dayOfWeek) + weekMultiplier(week);

        return(multiplier);
    }

    private static double dayMultiplier(int dayOfWeek)
    {
        int temp;
        if(dayOfWeek == 0)
            temp = 10;
        else
            temp = dayOfWeek;
        return(temp * 0.77);
    }

    private static double weekMultiplier(int week)
    {
        double temp = week * 1.2;
        return temp;
    }

    public static int getCurrDay(World world)
    {
        return((int)world.getWorldTime()/24000);
    }
}