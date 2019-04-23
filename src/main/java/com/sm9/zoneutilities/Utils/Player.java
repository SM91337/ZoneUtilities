package com.sm9.zoneutilities.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class Player {
    public static List getPlayersWithinAABB(BlockPos bpStart, BlockPos bpEnd, World world) {
        return world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(bpStart, bpEnd));
    }
}