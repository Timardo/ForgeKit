package net.timardo.forgekit.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerCapabilityProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject(IPlayerCapabilities.class)
	public static final Capability<IPlayerCapabilities> PLAYER_CAPABILITIES = null;
	private IPlayerCapabilities instance = PLAYER_CAPABILITIES.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PLAYER_CAPABILITIES;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == PLAYER_CAPABILITIES ? PLAYER_CAPABILITIES.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return PLAYER_CAPABILITIES.getStorage().writeNBT(PLAYER_CAPABILITIES, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PLAYER_CAPABILITIES.getStorage().readNBT(PLAYER_CAPABILITIES, instance, null, nbt);
		
	}

}
