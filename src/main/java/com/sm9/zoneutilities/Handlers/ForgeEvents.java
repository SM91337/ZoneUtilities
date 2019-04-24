package com.sm9.zoneutilities.Handlers;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.HashMap;

import static com.sm9.zoneutilities.ZoneUtilities.zoneMap;

public class ForgeEvents {
    public static void preInit(FMLPreInitializationEvent evEvent) {
        MinecraftForge.EVENT_BUS.register(new ForgeEvents());
        zoneMap = new HashMap<>();

    }

    public static void postInit(FMLPostInitializationEvent evEvent) {

    }
}