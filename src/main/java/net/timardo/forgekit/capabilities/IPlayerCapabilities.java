package net.timardo.forgekit.capabilities;

import net.minecraft.util.text.ITextComponent;

public interface IPlayerCapabilities {
	
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
	
}
