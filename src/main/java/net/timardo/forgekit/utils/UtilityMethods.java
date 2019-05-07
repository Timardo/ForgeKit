package net.timardo.forgekit.utils;

import org.apache.commons.lang.Validate;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.timardo.forgekit.capabilities.player.ICustomPlayerCapability;
import net.timardo.forgekit.capabilities.player.CustomPlayerCapabilityProvider;

public class UtilityMethods {
	
	public enum LogType {
		INVESTIGATION, UNSUPPORTED, ERROR
	}

	public static void log(LogType logType, Class<?> sourceClass, String sourceMethod) {
		//TODO logger - not very important until it's actually buildable
	}
	
	public static void registerRecipe(ResourceLocation customKey, IRecipe recipe) {
		Validate.notNull(recipe);
		customKey = customKey == null ? new ResourceLocation("customRecipe") : customKey;
		recipe.setRegistryName(customKey);
		//Do we actually need to check if this recipe IS an instance of Shaped/Shapeless recipe?
        UtilityMethods.log(UtilityMethods.LogType.UNSUPPORTED, UtilityMethods.class, "addToCraftingManager() - registering a recipe during runtime is NOT SUPPORTED AND NEVER WILL BE! "
        		+ "This feature is there for TESTING ONLY!");
		((ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES).unfreeze(); //Unfreeze the registry, bad thing thus not supported
		ForgeRegistries.RECIPES.register((IRecipe) recipe);
		((ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES).freeze(); //Freeze again, just for fun
	}
	
	public static ICustomPlayerCapability getPlayerCapability(EntityPlayer player) {
		return player.getCapability(CustomPlayerCapabilityProvider.PLAYER_CAPABILITY, null);
	}

}
