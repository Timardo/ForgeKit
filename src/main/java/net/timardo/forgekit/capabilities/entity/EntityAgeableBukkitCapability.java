package net.timardo.forgekit.capabilities.entity;

public class EntityAgeableBukkitCapability implements IEntityAgeableBukkitCapability {
	
	public boolean ageLocked;

	@Override
	public void setAgeLocked(boolean value) {
		this.ageLocked = value;
		
	}

	@Override
	public boolean getAgeLocked() {
		return this.ageLocked;
	}
	
	

}
