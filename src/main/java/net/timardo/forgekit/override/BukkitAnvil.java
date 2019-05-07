package net.timardo.forgekit.override;

import net.minecraft.block.BlockAnvil.Anvil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BukkitAnvil extends Anvil {

	private final World world;
	private final BlockPos position;

	public BukkitAnvil(World worldIn, BlockPos pos) {
		super(worldIn, pos);
		this.world = worldIn;
        this.position = pos;
	}
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerBukkitRepair(playerInventory, this.world, this.position, playerIn);
    }

}
