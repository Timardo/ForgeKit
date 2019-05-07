package net.timardo.forgekit.capabilities.player;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CustomPlayerCapabilityProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject(ICustomPlayerCapability.class)
	public static final Capability<ICustomPlayerCapability> PLAYER_CAPABILITY = null;
	private ICustomPlayerCapability instance = PLAYER_CAPABILITY.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PLAYER_CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == PLAYER_CAPABILITY ? PLAYER_CAPABILITY.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return PLAYER_CAPABILITY.getStorage().writeNBT(PLAYER_CAPABILITY, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PLAYER_CAPABILITY.getStorage().readNBT(PLAYER_CAPABILITY, instance, null, nbt);
		
	}

}
