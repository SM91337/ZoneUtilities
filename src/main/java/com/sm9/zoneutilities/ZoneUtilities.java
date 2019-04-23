package com.sm9.zoneutilities;

import com.sm9.zoneutilities.Classes.Zone;
import com.sm9.zoneutilities.Handlers.ForgeEvents;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;

@Mod
        (
                modid = com.sm9.zoneutilities.ZUConstants.MOD_ID,
                name = com.sm9.zoneutilities.ZUConstants.MOD_NAME,
                version = com.sm9.zoneutilities.ZUConstants.MOD_VERSION,
                dependencies = com.sm9.zoneutilities.ZUConstants.DEPENDENCIES,
                acceptedMinecraftVersions = com.sm9.zoneutilities.ZUConstants.MINECRAFT_VERSION,
                acceptableRemoteVersions = "*"
        )

public final class ZoneUtilities {
    public static Configuration mainConfig;
    public static File rootConfigFolder;
    public static Logger ZULogger;
    public static ArrayList<Zone> zoneList;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evEvent) {
        ForgeEvents.preInit(evEvent);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evEvent) {
        ForgeEvents.postInit(evEvent);
    }
}