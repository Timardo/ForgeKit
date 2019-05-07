package net.timardo.forgekit.capabilities.entity;

public interface IEntityLivingCapability {
	
	/**
	 * Sets the amount of XP that should be dropped after death, declared in Bukkit's death event 
	 * and then used as an XP source in EntityLivingBase#onDeathUpdate() L-436. In ForgeKit, this
	 * property is declared in Forge's version of death event and then used also in LivingDropsEvent
	 */
	public void setXPToDrop(int amount);
	
	/**
	 * Gets the XP to drop from death event
	 */
	public int getXPToDrop();
	
	/**
	 * Sets the maximum amount of ticks an entity can breathe in water, can be set by a plugin, ASM 
	 * injected Bukkit-like behavior
	 */
	public void setMaxAirTicks(int ticks);
	
	/**
	 * Gets max air ticks
	 */
	public int getMaxAirTicks();
	
	/**
	 * Sets the forceDrops property for this entity. AFAIK this thing is there to force dropping of wool and saddle when 
	 */
	public void setForceDrops(boolean value);
}
