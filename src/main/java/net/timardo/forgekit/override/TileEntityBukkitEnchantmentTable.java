package net.timardo.forgekit.override;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntityEnchantmentTable;

public class TileEntityBukkitEnchantmentTable extends TileEntityEnchantmentTable {
	
	@Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerBukkitEnchantment(playerInventory, this.world, this.pos);
    }

}
