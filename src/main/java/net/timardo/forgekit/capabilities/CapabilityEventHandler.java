package net.timardo.forgekit.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.timardo.forgekit.ForgeKitMod;

import static net.timardo.forgekit.Constants.*;

public class CapabilityEventHandler {
	
	public static final ResourceLocation PLAYER_CAPABILITIES = new ResourceLocation(ForgeKitMod.MODID, BUKKIT_PLAYER_CAPABILITIES);
	
	@SubscribeEvent
	public void attachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityPlayer) {
			event.addCapability(PLAYER_CAPABILITIES, new PlayerCapabilityProvider());
		}
	}
}
