package com.lethalleonard.villagedefence.Items;

import net.minecraft.item.ItemClock;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TimeWand extends ItemClock
{
    @SubscribeEvent
    public void timewand(PlayerInteractEvent.RightClickEmpty event)
    {
            //event.getEntityPlayer().sendMessage(new TextComponentString("Time: " + event.getWorld().getWorldTime()));
    }
}
