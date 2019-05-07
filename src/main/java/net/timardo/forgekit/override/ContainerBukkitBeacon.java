package net.timardo.forgekit.override;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.IInventory;

public class ContainerBukkitBeacon extends ContainerBeacon {

	public ContainerBukkitBeacon(IInventory playerInventory, IInventory tileBeaconIn) {
		super(playerInventory, tileBeaconIn);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
