package com.lethalleonard.villagedefence;

import com.lethalleonard.villagedefence.Proxy.CommonProxy;
import com.lethalleonard.villagedefence.Reference.Reference;
import com.lethalleonard.villagedefence.Utils.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.MOD_VERSION, name = Reference.MOD_NAME)
public class VillageDefence
{

    @SidedProxy(clientSide = Reference.CLIENT_SIDE, serverSide = Reference.SERVER_SIDE)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.logInfo("Starting Pre-Initialization...");
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.logInfo("Starting Initialization...");
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.logInfo("Starting Post-Initialization...");
        proxy.postInit(event);
    }
}
