package net.timardo.forgekit.capabilities.entity;

public interface IEntityAgeableBukkitCapability {
	/**
	 * Sets the locked state of age of an entity, if true, its age will remain same until unlocked or killed
	 */
	public void setAgeLocked(boolean value);
	
	/**
	 * Gets the locked state of age of an entity
	 */
	public boolean getAgeLocked();

}
