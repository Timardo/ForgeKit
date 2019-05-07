package net.timardo.forgekit.override;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerBukkitEnchantment extends ContainerEnchantment {

	public ContainerBukkitEnchantment(InventoryPlayer playerInv, World worldIn, BlockPos pos) {
		super(playerInv, worldIn, pos);
	}
	
    public boolean canInteractWith(EntityPlayer playerIn)
    {
    	return true;
    }

}
