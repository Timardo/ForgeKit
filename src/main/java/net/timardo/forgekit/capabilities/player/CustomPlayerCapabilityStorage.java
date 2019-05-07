package net.timardo.forgekit.capabilities.player;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CustomPlayerCapabilityStorage implements IStorage<ICustomPlayerCapability> {

	@Override
	public NBTBase writeNBT(Capability<ICustomPlayerCapability> capability, ICustomPlayerCapability instance, EnumFacing side) {
		return null;
	}

	@Override
	public void readNBT(Capability<ICustomPlayerCapability> capability, ICustomPlayerCapability instance, EnumFacing side, NBTBase nbt) {
		
	}

}