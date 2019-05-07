package net.timardo.forgekit.capabilities.world.chunk;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class BukkitChunkCapProvider implements ICapabilityProvider {
	
	@CapabilityInject(IBukkitChunkCap.class)
	public static final Capability<IBukkitChunkCap> BUKKIT_CHUNK_CAP_PROVIDER = null;
	private IBukkitChunkCap instance = BUKKIT_CHUNK_CAP_PROVIDER.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == BUKKIT_CHUNK_CAP_PROVIDER;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == BUKKIT_CHUNK_CAP_PROVIDER ? BUKKIT_CHUNK_CAP_PROVIDER.<T> cast(this.instance) : null;
	}

}
