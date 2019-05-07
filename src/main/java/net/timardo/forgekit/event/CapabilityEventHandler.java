package net.timardo.forgekit.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.timardo.forgekit.ForgeKitMod;
import net.timardo.forgekit.capabilities.player.ICustomPlayerCapability;
import net.timardo.forgekit.capabilities.world.chunk.BukkitChunkCapProvider;
import net.timardo.forgekit.capabilities.world.chunk.IBukkitChunkCap;
import net.timardo.forgekit.capabilities.entity.EntityAgeableBukkitCapabilityProvider;
import net.timardo.forgekit.capabilities.entity.IEntityAgeableBukkitCapability;
import net.timardo.forgekit.capabilities.player.CustomPlayerCapabilityProvider;

import static net.timardo.forgekit.Constants.*;

public class CapabilityEventHandler { //TODO rename all this capability stuff to something more self-explaining
	
	public static final ResourceLocation PLAYER = new ResourceLocation(ForgeKitMod.MODID, PLAYER_BUKKIT_CAP);
	public static final ResourceLocation ENTITY_AGEABLE = new ResourceLocation(ForgeKitMod.MODID, ENTITY_AGEABLE_BUKKIT_CAP);
	public static final ResourceLocation CHUNK = new ResourceLocation(ForgeKitMod.MODID, BUKKIT_CHUNK_CAP);
	
	@SubscribeEvent
	public void attachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityPlayer) {
			event.addCapability(PLAYER, new CustomPlayerCapabilityProvider());
			ICustomPlayerCapability capability = event.getObject().getCapability(CustomPlayerCapabilityProvider.PLAYER_CAPABILITY, null);
			capability.setDisplayName(event.getObject().getName()); //Default as in Bukkit 
			capability.setJoiningState(true); //check if this is the right way (MUST be called before the first onUpdate tick)
		}
		
		if (event.getObject() instanceof EntityAgeable) {
			event.addCapability(ENTITY_AGEABLE, new EntityAgeableBukkitCapabilityProvider());
			IEntityAgeableBukkitCapability capability = event.getObject().getCapability(EntityAgeableBukkitCapabilityProvider.ENTITY_AGEABLE_BUKKIT_CAP, null);
			capability.setAgeLocked(false);
		}
	}
	
	@SubscribeEvent
	public void attachChunkCapabilities(AttachCapabilitiesEvent<Chunk> event) {
		event.addCapability(CHUNK, new BukkitChunkCapProvider());
		IBukkitChunkCap capability = event.getObject().getCapability(BukkitChunkCapProvider.BUKKIT_CHUNK_CAP_PROVIDER, null);
		capability.setBukkitChunk(new org.bukkit.craftbukkit.CraftChunk(event.getObject()));
	}
}
