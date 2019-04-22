package org.bukkit.craftbukkit.entity;

import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;

import net.minecraft.entity.item.EntityFallingBlock;

public class CraftFallingBlock extends CraftEntity implements FallingBlock {

    public CraftFallingBlock(CraftServer server, EntityFallingBlock entity) {
        super(server, entity);
    }

    @Override
    public EntityFallingBlock getHandle() {
        return (EntityFallingBlock) entity;
    }

    @Override
    public String toString() {
        return "CraftFallingBlock";
    }

    public EntityType getType() {
        return EntityType.FALLING_BLOCK;
    }

    @SuppressWarnings("deprecation")
	public Material getMaterial() {
        return Material.getMaterial(getBlockId());
    }

    @SuppressWarnings("deprecation")
	public int getBlockId() {
        return CraftMagicNumbers.getId(getHandle().getBlock().getBlock());
    }

    public byte getBlockData() {
        return (byte) getHandle().getBlock().getBlock().getMetaFromState(getHandle().getBlock());
    }

    public boolean getDropItem() {
        return getHandle().shouldDropItem;
    }

    public void setDropItem(boolean drop) {
        getHandle().shouldDropItem = drop;
    }

    @Override
    public boolean canHurtEntities() {
        return getHandle().hurtEntities;
    }

    @Override
    public void setHurtEntities(boolean hurtEntities) {
        getHandle().setHurtEntities(hurtEntities);
    }

    @Override
    public void setTicksLived(int value) {
        super.setTicksLived(value);
        getHandle().ticksExisted = value;
    }
}
