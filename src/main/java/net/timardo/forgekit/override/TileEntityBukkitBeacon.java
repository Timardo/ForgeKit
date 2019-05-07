package net.timardo.forgekit.override;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.tileentity.TileEntityBeacon;

public class TileEntityBukkitBeacon extends TileEntityBeacon {
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerBukkitBeacon(playerInventory, this);
    }
}
