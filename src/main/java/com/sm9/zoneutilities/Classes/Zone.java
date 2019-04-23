package com.sm9.zoneutilities.Classes;

import net.minecraft.util.math.BlockPos;

public class Zone {
    private String name;
    private BlockPos blockPosStart;
    private BlockPos blockPosEnd;
    private ZoneRules zoneRules;
    private ZoneActions zoneActions;

    public Zone(String name, BlockPos start, BlockPos end) {
        this.name = name;
        this.blockPosStart = start;
        this.blockPosEnd = end;
    }

    public Zone(String name, int xStart, int yStart, int zStart, int xEnd, int yEnd, int zEnd) {
        new Zone(name, new BlockPos(xStart, yStart, zStart), new BlockPos(xEnd, yEnd, zEnd));
    }

    public void setZoneActions(ZoneActions actions) {
        this.zoneActions = actions;
    }

    public void setZoneRules(ZoneRules rules) {
        this.zoneRules = rules;
    }

    public ZoneRules getZoneRules() {
        return this.zoneRules;
    }

    public ZoneActions getZoneActions() {
        return this.zoneActions;
    }

    public String getName() {
        return this.name;
    }

    public BlockPos getStart() {
        return this.blockPosStart;
    }

    public BlockPos getEnd() {
        return this.blockPosEnd;
    }
}