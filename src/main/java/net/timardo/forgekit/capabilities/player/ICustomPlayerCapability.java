package net.timardo.forgekit.capabilities.player;

import org.bukkit.Location;

import net.minecraft.util.text.ITextComponent;

public interface ICustomPlayerCapability {
	
	/**
	 * Sets the display name of player used by Bukkit plugins
	 */
	public void setDisplayName(String displayName);
	
	/**
	 * Gets the display name of player
	 */
	public String getDisplayName();
	
	/**
	 * Sets the list name of player used by Bukkit plugins
	 */
	public void setListName(ITextComponent name);
	
	/**
	 * Gets the list name of player
	 */
	public ITextComponent getListName();
	
	/**
	 * Gets the compass target of the player
	 */
	public Location getCompassTarget();
	
	/**
	 * Sets the compass target
	 */
	public void setCompassTarget(Location newTarget);
	
	/**
	 * Sets the newExp property of player used in PlayerDeathEvent. Indicates how much XP the player should have after the respawn.
	 * Set in fml's PlayerEvent.PlayerRespawnEvent where the whole bukkit's event is processed.
	 * 
	 * WRITE TO NBT
	 */
	public void setNewXP(int newXP);
	
	/**
	 * Gets the newExp property of player
	 */
	public int getNewXP();
	
	/**
	 * Sets the newLevel property of player used in PlayerDeathEvent. Stores the level with which the player should respawn with.
	 * Present in fml's PlayerEvent.PlayerRespawnEvent
	 * 
	 * WRITE TO NBT
	 */
	public void setNewLevel(int newLevel);
	
	/**
	 * Gets the newLevel property
	 */
	public int getNewLevel();
	
	/**
	 * Sets the newTotalExp property of player which holds the total experience the player should have after respawn
	 * 
	 * WRITE TO NBT
	 */
	public void setNewTotalXP(int newTotalXP);
	
	/**
	 * Gets the newTotalExp property
	 */
	public int getNewTotalXP();
	
	/**
	 * Sets whether the player should keep their level or not. Resets after death.
	 * 
	 * WRITE TO NBT
	 */
	public void setKeepLevel(boolean keepLevel);
	
	/**
	 * Gets whether the player should keep level after the death.
	 */
	public boolean getKeepLevel();
	
	/**
	 * Sets the maxHealthCache property. I really can't figure out what is this thing for, it just somehow handles health updates.
	 */
	public void setMaxHealthCache(double value);
	
	/**
	 * Gets the maxHealthCache property.
	 */
	public double getMaxHealthCache();
	
	/**
	 * Sets the joining state of player (actually before the player receive an EntityPlayerMP#onUpdate() tick L-355).
	 * Automatically sets to true when the player object is created and sets to false when the player receives the first onUpdate() tick.
	 * Used in bukkit's isDisconnected method which is then used in EnderTeleportEvent and PlayerEvent.PlayerRespawnEvent.
	 */
	public void setJoiningState(boolean isJoining);
	
	/**
	 * Gets the joining state of player.
	 */
	public boolean isJoining();
	
	/**
	 * Sets the sentListPacket property of player
	 */
	public void setSentListPacket(boolean value);
	
	/**
	 * Returns true or false if the player was already handled (added to) in the PlayerList after they joined. Later used to handle "hidden players" - 
	 * Bukkit's implementation of ignoring/hiding players from others
	 */
	public boolean getSentListPacket(); //TODO - just a remainder for myself - when a player joins, depending on their "hiding state", bukkit does't add their name to the PlayerList - we will remove it in player login event
}
