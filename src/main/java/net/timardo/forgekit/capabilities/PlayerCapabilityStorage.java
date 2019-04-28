package net.timardo.forgekit.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

import static net.timardo.forgekit.Constants.*;

public class PlayerCapabilityStorage implements IStorage<IPlayerCapabilities> {

	@Override
	public NBTBase writeNBT(Capability<IPlayerCapabilities> capability, IPlayerCapabilities instance, EnumFacing side) {
		NBTTagCompound ret = new NBTTagCompound();
		ret.setString(BUKKIT_PLAYER_LIST_NAME, ITextComponent.Serializer.componentToJson(instance.getListName()));
		ret.setString(BUKKIT_PLAYER_DISPLAY_NAME, instance.getDisplayName());
		return ret;
	}

	@Override
	public void readNBT(Capability<IPlayerCapabilities> capability, IPlayerCapabilities instance, EnumFacing side, NBTBase nbt) {
		NBTTagCompound tag = (NBTTagCompound) nbt;
		instance.setDisplayName(tag.getString(BUKKIT_PLAYER_DISPLAY_NAME));
		instance.setListName(ITextComponent.Serializer.jsonToComponent(tag.getString(BUKKIT_PLAYER_LIST_NAME)));
		
	}

}