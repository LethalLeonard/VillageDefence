package com.lethalleonard.villagedefence.Utils;

import com.lethalleonard.villagedefence.ModInit.ItemInit;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegisterUtil
{
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
        ItemInit.prepareItems();
        ItemInit.registerItems(event);
    }
}
