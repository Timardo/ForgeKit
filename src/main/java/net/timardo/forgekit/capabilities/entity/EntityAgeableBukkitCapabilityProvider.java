package net.timardo.forgekit.capabilities.entity;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class EntityAgeableBukkitCapabilityProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject(IEntityAgeableBukkitCapability.class)
	public static final Capability<IEntityAgeableBukkitCapability> ENTITY_AGEABLE_BUKKIT_CAP = null;
	private IEntityAgeableBukkitCapability instance = ENTITY_AGEABLE_BUKKIT_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == ENTITY_AGEABLE_BUKKIT_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == ENTITY_AGEABLE_BUKKIT_CAP ? ENTITY_AGEABLE_BUKKIT_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return ENTITY_AGEABLE_BUKKIT_CAP.getStorage().writeNBT(ENTITY_AGEABLE_BUKKIT_CAP, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		ENTITY_AGEABLE_BUKKIT_CAP.getStorage().readNBT(ENTITY_AGEABLE_BUKKIT_CAP, instance, null, nbt);
		
	}

}
