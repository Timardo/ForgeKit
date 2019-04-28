package net.timardo.forgekit;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ForgeKitMod.MODID, version = ForgeKitMod.VERSION)
public class ForgeKitMod {
	
	public static final String MODID = "forgekit";
	public static final String VERSION = "1.0.0";
	
	@SidedProxy(serverSide = "net.timardo.forgekit.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}
