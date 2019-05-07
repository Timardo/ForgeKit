package net.timardo.forgekit.capabilities.entity;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class EntityAgeableBukkitCapabilityStorage implements IStorage<IEntityAgeableBukkitCapability> {

	@Override
	public NBTBase writeNBT(Capability<IEntityAgeableBukkitCapability> capability,
			IEntityAgeableBukkitCapability instance, EnumFacing side) {
		if (!instance.getAgeLocked()) {
			return new NBTTagByte((byte)0);
			}
		
		return new NBTTagByte((byte)1);
	}

	@Override
	public void readNBT(Capability<IEntityAgeableBukkitCapability> capability, IEntityAgeableBukkitCapability instance,
			EnumFacing side, NBTBase nbt) {
		byte value = ((NBTTagByte)nbt).getByte();
		if (value == 0) {
			instance.setAgeLocked(false);
		}
		else {
			instance.setAgeLocked(true);
		}
		
	}

}
