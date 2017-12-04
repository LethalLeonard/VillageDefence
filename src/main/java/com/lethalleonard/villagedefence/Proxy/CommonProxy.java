package com.lethalleonard.villagedefence.Proxy;

import com.lethalleonard.villagedefence.Utils.LogHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{

    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.logInfo("Starting PreInit");
    }

    public void init(FMLInitializationEvent event)
    {
        LogHelper.logInfo("Starting Init");
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
