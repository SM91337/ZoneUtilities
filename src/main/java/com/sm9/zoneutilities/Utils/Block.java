package com.sm9.zoneutilities.Utils;

import net.minecraft.util.math.BlockPos;

public class Block {
    public static boolean isBlockPosWithinAABB(BlockPos blockPosEvent, BlockPos blockPosStart, BlockPos blockPosEnd) {
        // X Axis Checking
        int startX = blockPosStart.getX();
        int endX = blockPosEnd.getX();

        int xMax = Math.max(startX, endX);
        int xMin = Math.min(startX, endX);

        int eventX = blockPosEvent.getX();

        if (eventX > xMax || eventX < xMin) {
            return false;
        }

        // Y Axis Checking
        int startY = blockPosStart.getY();
        int endY = blockPosEnd.getY();

        int yMax = Math.max(startY, endY);
        int yMin = Math.min(startY, endY);

        int eventY = blockPosEvent.getY();

        if (eventY > yMax || eventY < yMin) {
            return false;
        }

        // Z Axis Checking
        int startZ = blockPosStart.getZ();
        int endZ = blockPosEnd.getZ();

        int zMax = Math.max(startZ, endZ);
        int zMin = Math.min(startZ, endZ);

        int eventZ = blockPosEvent.getZ();

        return eventZ <= zMax && eventZ >= zMin;

    }
}