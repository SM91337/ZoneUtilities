package com.sm9.zoneutilities.Handlers;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;

import static com.sm9.zoneutilities.ZoneUtilities.zoneList;

public class ForgeEvents {
    public static void preInit(FMLPreInitializationEvent evEvent) {
        MinecraftForge.EVENT_BUS.register(new ForgeEvents());
        zoneList = new ArrayList<>();

    }

    public static void postInit(FMLPostInitializationEvent evEvent) {

    }
}