package org.bukkit.craftbukkit.entity;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Hanging;

import net.minecraft.entity.EntityHanging;
import net.minecraft.util.EnumFacing;

public class CraftHanging extends CraftEntity implements Hanging {
    public CraftHanging(CraftServer server, EntityHanging entity) {
        super(server, entity);
    }

    public BlockFace getAttachedFace() {
        return getFacing().getOppositeFace();
    }

    public void setFacingDirection(BlockFace face) {
        setFacingDirection(face, false);
    }

    public boolean setFacingDirection(BlockFace face, boolean force) {
        EntityHanging hanging = getHandle();
        EnumFacing dir = hanging.facingDirection;
        switch (face) {
            case SOUTH:
            default:
                getHandle().updateFacingWithBoundingBox(EnumFacing.SOUTH); //TODO AT
                break;
            case WEST:
                getHandle().updateFacingWithBoundingBox(EnumFacing.WEST); //TODO AT
                break;
            case NORTH:
                getHandle().updateFacingWithBoundingBox(EnumFacing.NORTH); //TODO AT
                break;
            case EAST:
                getHandle().updateFacingWithBoundingBox(EnumFacing.EAST); //TODO AT
                break;
        }
        if (!force && !hanging.onValidSurface()) {
            hanging.updateFacingWithBoundingBox(dir); //TODO AT
            return false;
        }
        return true;
    }

    public BlockFace getFacing() {
    	EnumFacing direction = this.getHandle().facingDirection;
        if (direction == null) return BlockFace.SELF;
        switch (direction) {
            case SOUTH:
            default:
                return BlockFace.SOUTH;
            case WEST:
                return BlockFace.WEST;
            case NORTH:
                return BlockFace.NORTH;
            case EAST:
                return BlockFace.EAST;
        }
    }

    @Override
    public EntityHanging getHandle() {
        return (EntityHanging) entity;
    }

    @Override
    public String toString() {
        return "CraftHanging";
    }

    public EntityType getType() {
        return EntityType.UNKNOWN;
    }
}
