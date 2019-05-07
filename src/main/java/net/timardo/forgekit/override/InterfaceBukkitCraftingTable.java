package net.timardo.forgekit.override;

import net.minecraft.block.BlockWorkbench.InterfaceCraftingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InterfaceBukkitCraftingTable extends InterfaceCraftingTable {

    private final World world;
    private final BlockPos position;

    public InterfaceBukkitCraftingTable(World worldIn, BlockPos pos)
    {
    	super(worldIn, pos);
    	this.world = worldIn;
    	this.position = pos;
    }
    
    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerBukkitWorkbench(playerInventory, this.world, this.position);
    }

}
