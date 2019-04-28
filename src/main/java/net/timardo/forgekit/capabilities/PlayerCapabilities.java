package net.timardo.forgekit.capabilities;

import net.minecraft.util.text.ITextComponent;

public class PlayerCapabilities implements IPlayerCapabilities {
	
	public String displayName;
	public ITextComponent listName;
	
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

}
