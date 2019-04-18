package org.bukkit.craftbukkit.inventory;

import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

import net.minecraft.item.crafting.FurnaceRecipes;

public class CraftFurnaceRecipe extends FurnaceRecipe implements CraftRecipe {
    @SuppressWarnings("deprecation")
	public CraftFurnaceRecipe(ItemStack result, ItemStack source) {
        super(result, source.getType(), source.getDurability());
    }

    public static CraftFurnaceRecipe fromBukkitRecipe(FurnaceRecipe recipe) {
        if (recipe instanceof CraftFurnaceRecipe) {
            return (CraftFurnaceRecipe) recipe;
        }
        return new CraftFurnaceRecipe(recipe.getResult(), recipe.getInput());
    }

    @Override
    public void addToCraftingManager() {
        ItemStack result = this.getResult();
        ItemStack input = this.getInput();
        FurnaceRecipes.instance().addSmeltingRecipe(CraftItemStack.asNMSCopy(input), CraftItemStack.asNMSCopy(result), getExperience());
    }
}
