package net.timardo.forgekit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.timardo.forgekit.capabilities.player.CustomPlayerCapability;
import net.timardo.forgekit.capabilities.player.ICustomPlayerCapability;
import net.timardo.forgekit.capabilities.player.CustomPlayerCapabilityStorage;
import net.timardo.forgekit.event.CapabilityEventHandler;

public class CommonProxy {

	public void init() {
		CapabilityManager.INSTANCE.register(ICustomPlayerCapability.class, new CustomPlayerCapabilityStorage(), CustomPlayerCapability::new);
		MinecraftForge.EVENT_BUS.register(new CapabilityEventHandler());
	}

}
