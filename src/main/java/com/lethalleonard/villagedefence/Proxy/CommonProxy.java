package com.lethalleonard.villagedefence.Proxy;

import com.lethalleonard.villagedefence.Items.TimeWand;
import com.lethalleonard.villagedefence.MobWaves.MobSpawning;
import com.lethalleonard.villagedefence.Utils.RegisterUtil;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{

    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new MobSpawning());
        MinecraftForge.EVENT_BUS.register(new RegisterUtil());
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
