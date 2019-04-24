package com.sm9.zoneutilities.Utils;

import com.sm9.zoneutilities.Classes.Zone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.List;

import static com.sm9.zoneutilities.ZoneUtilities.zoneMap;

public class PlayerUtils {
    public static List getPlayersWithinAABB(BlockPos bpStart, BlockPos bpEnd, World world) {
        return world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(bpStart, bpEnd));
    }

    public static List getPlayersWithinZone(String zoneName) {
        if (zoneMap == null) {
            return null;
        }

        return getPlayersWithinZone(zoneMap.get(zoneName));
    }

    public static List getPlayersWithinZone(Zone zone) {
        if (zone == null) {
            return null;
        }

        BlockPos zoneStart = zone.getStart();
        BlockPos zoneEnd = zone.getEnd();

        int dimensionId = zone.getDimensionId();
        MinecraftServer mcServer = FMLCommonHandler.instance().getMinecraftServerInstance();

        return getPlayersWithinAABB(zoneStart, zoneEnd, mcServer.getWorld(dimensionId));
    }
}