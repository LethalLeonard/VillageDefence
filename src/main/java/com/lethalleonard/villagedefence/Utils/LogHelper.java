package com.lethalleonard.villagedefence.Utils;

import com.lethalleonard.villagedefence.Reference.Reference;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper
{
    public static Logger LOGGER = LogManager.getLogger(Reference.MODID);

    //creates a logging method for each level of log

    public static void logInfo(String msg)
    {
        LOGGER.log(Level.INFO, formatOutput(msg));
    }

    public static void logFatal(String msg)
    {
        LOGGER.log(Level.FATAL, formatOutput(msg));
    }

    public static void logError(String msg)
    {
        LOGGER.log(Level.ERROR, formatOutput(msg));
    }

    public static void logWarn(String msg)
    {
        LOGGER.log(Level.WARN, formatOutput(msg));
    }

    public static void logAll(String msg)
    {
        LOGGER.log(Level.ALL, formatOutput(msg));
    }

    public static void logDebug(String msg)
    {
        LOGGER.log(Level.DEBUG, formatOutput(msg));
    }

    //formats the output in the form of [modid] <message>
    public static String formatOutput(String msg)
    {
        return(String.format("[%s] %s", Reference.MODID, msg));
    }
}
