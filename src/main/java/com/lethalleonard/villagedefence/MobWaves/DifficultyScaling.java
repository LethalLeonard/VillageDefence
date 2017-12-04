package com.lethalleonard.villagedefence.MobWaves;

import net.minecraft.world.World;

public class DifficultyScaling
{
    public static double getDifficulty(int currDay)
    {
        //calculates the day of the week so that day 0 is the 7th day in the week
        int dayOfWeek = (currDay + 1) % 7;

        //calculates the number of weeks and adds 1 so that the first week is week 1
        int week = (int)Math.floor(currDay/7) + 1;

        //variable to set a multiplier for days
        int dayMult;

        //makes any day that is a multiple of 7 have a much higher difficulty
        //if day is not the 7th day, the multiplier is the day of the week
        if(dayOfWeek == 0)
            dayMult = 10;
        else
            dayMult = dayOfWeek;

        //adds the day multiplier to the week multiplier to get the total multiplier
        double multiplier = (dayMult * 0.77) + (week * 1.2);

        return(multiplier);
    }

    //returns the active world day
    public static int getCurrDay(World world)
    {
        return((int)world.getWorldTime()/24000);
    }
}