package com.sm9.zoneutilities.Classes;

import com.sm9.zoneutilities.Utils.BlockUtils;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;

import static com.sm9.zoneutilities.ZoneUtilities.zoneMap;

public class Zone {
    private String name;
    private BlockPos blockPosStart;
    private BlockPos blockPosEnd;
    private int dimensionId;
    private ZoneRules zoneRules;
    private ZoneActions zoneActions;
    private HashMap<String, Zone> innerZones = new HashMap<>();

    public Zone(String name, int dimensionId, BlockPos start, BlockPos end) {
        if(zoneMap.get(name) != null) {
            return; // TODO: Throw an exception because zone with name already exists.
        }

        this.name = name;
        this.dimensionId = dimensionId;

        for(Zone zone : zoneMap.values()) {
            if(zone == this) {
                continue;
            }

            if(zone.getStart() == start) {
                return; // TODO: Throw an exception because zone with starting pos already exists.
            }

            if(zone.getEnd() == end) {
                return; // TODO: Throw an exception because zone with ending pos already exists.
            }

            if(BlockUtils.isBlockPosWithinAABB(start, zone.getStart(), zone.getEnd()) || BlockUtils.isBlockPosWithinAABB(end, zone.getStart(), zone.getEnd())) {
                zone.setInnerZone(name, this);
            } else if(BlockUtils.isBlockPosWithinAABB(zone.getStart(), start, end) || BlockUtils.isBlockPosWithinAABB(zone.getEnd(), start, end)) {
                setInnerZone(zone.name, zone);
            }
        }

        this.blockPosStart = start;
        this.blockPosEnd = end;

        zoneMap.put(name, this);
    }

    public Zone(String name, int dimensionId, int xStart, int yStart, int zStart, int xEnd, int yEnd, int zEnd) {
        new Zone(name, dimensionId, new BlockPos(xStart, yStart, zStart), new BlockPos(xEnd, yEnd, zEnd));
    }

    public ZoneRules getZoneRules() {
        return this.zoneRules;
    }

    public void setZoneRules(ZoneRules rules) {
        this.zoneRules = rules;
    }

    public ZoneActions getZoneActions() {
        return this.zoneActions;
    }

    public void setZoneActions(ZoneActions actions) {
        this.zoneActions = actions;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDimensionId() {
        return this.dimensionId;
    }

    public BlockPos getStart() {
        return this.blockPosStart;
    }

    public BlockPos getEnd() {
        return this.blockPosEnd;
    }

    private void setInnerZone(String name, Zone zone) {
        if(zone == this) {
            return;
        }

        this.innerZones.put(name, zone);
    }
}