package net.timardo.forgekit.event;

import net.minecraftforge.event.entity.player.PlayerSetSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.timardo.forgekit.utils.UtilityMethods.getPlayerCapability;

import org.bukkit.Location;

/**
 * Handles various events which are here as a replacement for NMS patches
 * @author Timardo
 *
 */
public class NMSReplacementEventHandler {
	
	/**
	 * Sets the compass target for player when a SPacketSpawnPosition is sent, so plugins can rely on it
	 */
	@SubscribeEvent
	public void onPlayerSetSpawnEvent(PlayerSetSpawnEvent event) {
		getPlayerCapability(event.getEntityPlayer()).setCompassTarget(
				new Location(event.getEntityPlayer().getWorld(), event.getNewSpawn().getX(), event.getNewSpawn().getY(), event.getNewSpawn().getZ())); //TODO impl
	}
}
