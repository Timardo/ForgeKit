package net.timardo.forgekit.capabilities.world.chunk;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class BukkitChunkCapStorage implements IStorage<IBukkitChunkCap> {

	@Override
	public NBTBase writeNBT(Capability<IBukkitChunkCap> capability, IBukkitChunkCap instance, EnumFacing side) {
		return null;
	}

	@Override
	public void readNBT(Capability<IBukkitChunkCap> capability, IBukkitChunkCap instance, EnumFacing side,
			NBTBase nbt) {
		
	}

}
