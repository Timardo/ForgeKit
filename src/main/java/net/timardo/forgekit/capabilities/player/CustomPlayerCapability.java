package net.timardo.forgekit.capabilities.player;

import org.bukkit.Location;

import net.minecraft.util.text.ITextComponent;

public class CustomPlayerCapability implements ICustomPlayerCapability {
	
	//public for NMS reflection, idk if it can be used at all
	public String displayName;
	public ITextComponent listName;
	public Location compassTarget;
	public int newExp = 0;
    public int newLevel = 0;
    public int newTotalExp = 0;
    public boolean keepLevel = false;
    public double maxHealthCache; //Weird thing, but whatever
    public boolean joining = true;
    public boolean sentListPacket = false;
	
	@Override
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
		
	}

	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public void setListName(ITextComponent name) {
		this.listName = name;
		
	}

	@Override
	public ITextComponent getListName() {
		return this.listName;
	}

	@Override
	public Location getCompassTarget() {
		return this.compassTarget;
	}

	@Override
	public void setCompassTarget(Location newTarget) {
		this.compassTarget = newTarget;
		
	}

	@Override
	public void setNewXP(int newXP) {
		this.newExp = newXP;
		
	}

	@Override
	public int getNewXP() {
		return this.newExp;
	}

	@Override
	public void setNewLevel(int newLevel) {
		this.newLevel = newLevel;
		
	}

	@Override
	public int getNewLevel() {
		return this.newLevel;
	}

	@Override
	public void setNewTotalXP(int newTotalXP) {
		this.newTotalExp = newTotalXP;
		
	}

	@Override
	public int getNewTotalXP() {
		return this.newTotalExp;
	}

	@Override
	public void setKeepLevel(boolean keepLevel) {
		this.keepLevel = keepLevel;
		
	}

	@Override
	public boolean getKeepLevel() {
		return this.keepLevel;
	}

	@Override
	public void setMaxHealthCache(double value) {
		this.maxHealthCache = value;
		
	}

	@Override
	public double getMaxHealthCache() {
		return this.maxHealthCache;
	}

	@Override
	public void setJoiningState(boolean isJoining) {
		this.joining = isJoining;
		
	}

	@Override
	public boolean isJoining() {
		return this.joining;
	}


	@Override
	public void setSentListPacket(boolean value) {
		this.sentListPacket = value;
		
	}

	@Override
	public boolean getSentListPacket() {
		return this.sentListPacket;
	}
	
}
