package com.lethalleonard.villagedefence.ModInit;

import com.lethalleonard.villagedefence.Items.TimeWand;
import com.lethalleonard.villagedefence.Utils.LogHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;

public class ItemInit
{
    public static ArrayList<Item> itemList = new ArrayList<>();
    public static TimeWand timeWand;

    public static void prepareItems()
    {
        timeWand = new TimeWand();
        itemList.add(timeWand);
    }

    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        for(Item item : itemList)
        {
            LogHelper.logInfo("Starting item registration...");
            event.getRegistry().register(item);
            LogHelper.logInfo("Registering item: " + item.getUnlocalizedName().substring(5));
            LogHelper.logInfo("Finished registering " + item.getUnlocalizedName() + "...");
        }

        LogHelper.logInfo("Finished registering items.");
    }

    public static void registerTextures()
    {
        for(Item item : itemList)
        {
            ModelLoader.setCustomModelResourceLocation(
                    item,
                    0,
                    new ModelResourceLocation(item.getUnlocalizedName().substring(5)));
        }
    }
}
