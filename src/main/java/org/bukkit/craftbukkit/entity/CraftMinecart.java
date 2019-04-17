package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;
import org.bukkit.entity.Minecart;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.init.Blocks;

public abstract class CraftMinecart extends CraftVehicle implements Minecart {
    public CraftMinecart(CraftServer server, EntityMinecart entity) {
        super(server, entity);
    }

    public void setDamage(double damage) {
        getHandle().setDamage((float) damage);
    }

    public double getDamage() {
        return getHandle().getDamage();
    }

    public double getMaxSpeed() {
        return getHandle().maxSpeed; //TODO impl (probably useless)
    }

    public void setMaxSpeed(double speed) {
        if (speed >= 0D) {
            getHandle().maxSpeed = speed; //TODO impl (probably useless)
        }
    }

    public boolean isSlowWhenEmpty() {
        return getHandle().slowWhenEmpty; //TODO impl
    }

    public void setSlowWhenEmpty(boolean slow) {
        getHandle().slowWhenEmpty = slow; //TODO impl
    }

    public Vector getFlyingVelocityMod() {
        return getHandle().getFlyingVelocityMod(); //TODO impl
    }

    public void setFlyingVelocityMod(Vector flying) {
        getHandle().setFlyingVelocityMod(flying); //TODO impl
    }

    public Vector getDerailedVelocityMod() {
        return getHandle().getDerailedVelocityMod(); //TODO impl
    }

    public void setDerailedVelocityMod(Vector derailed) {
        getHandle().setDerailedVelocityMod(derailed); //TODO impl
    }

    @Override
    public EntityMinecart getHandle() {
        return (EntityMinecart) entity;
    }

    @SuppressWarnings("deprecation")
	public void setDisplayBlock(MaterialData material) {
        if(material != null) {
            IBlockState block = CraftMagicNumbers.getBlock(material.getItemTypeId()).getDefaultState();
            this.getHandle().setDisplayTile(block);
        } else {
            // Set block to air (default) and set the flag to not have a display block.
            this.getHandle().setDisplayTile(Blocks.AIR.getDefaultState());
            this.getHandle().setHasDisplayTile(false);
        }
    }

    @SuppressWarnings("deprecation")
	public MaterialData getDisplayBlock() {
    	IBlockState blockData = getHandle().getDisplayTile();
        return CraftMagicNumbers.getMaterial(blockData.getBlock()).getNewData((byte) blockData.getBlock().getMetaFromState(blockData));
    }

    public void setDisplayBlockOffset(int offset) {
        getHandle().setDisplayTileOffset(offset);
    }

    public int getDisplayBlockOffset() {
        return getHandle().getDisplayTileOffset();
    }
}
