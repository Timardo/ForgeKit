package net.timardo.forgekit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.timardo.forgekit.capabilities.CapabilityEventHandler;
import net.timardo.forgekit.capabilities.IPlayerCapabilities;
import net.timardo.forgekit.capabilities.PlayerCapabilities;
import net.timardo.forgekit.capabilities.PlayerCapabilityStorage;

public class CommonProxy {

	public void init() {
		CapabilityManager.INSTANCE.register(IPlayerCapabilities.class, new PlayerCapabilityStorage(), PlayerCapabilities::new);
		MinecraftForge.EVENT_BUS.register(new CapabilityEventHandler());
	}

}
