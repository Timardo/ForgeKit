package org.bukkit.craftbukkit.inventory;

import java.util.Iterator;

import org.bukkit.inventory.Recipe;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class RecipeIterator implements Iterator<Recipe> {
    private final Iterator<IRecipe> recipes;
    private final Iterator<net.minecraft.item.ItemStack> smeltingCustom;
    private final Iterator<net.minecraft.item.ItemStack> smeltingVanilla;
    private Iterator<?> removeFrom = null;

    public RecipeIterator() {
        this.recipes = CraftingManager.REGISTRY.iterator(); //TODO forge GameData
        this.smeltingCustom = FurnaceRecipes.instance().customRecipes.keySet().iterator(); //TODO impl
        this.smeltingVanilla = FurnaceRecipes.instance().getSmeltingList().keySet().iterator(); //TODO forge GameData?
    }

    public boolean hasNext() {
        return recipes.hasNext() || smeltingCustom.hasNext() || smeltingVanilla.hasNext();
    }

    public Recipe next() {
        if (recipes.hasNext()) {
            removeFrom = recipes;
            return recipes.next().toBukkitRecipe(); //TODO impl
        } else {
            net.minecraft.item.ItemStack item;
            if (smeltingCustom.hasNext()) {
                removeFrom = smeltingCustom;
                item = smeltingCustom.next();
            } else {
                removeFrom = smeltingVanilla;
                item = smeltingVanilla.next();
            }

            CraftItemStack stack = CraftItemStack.asCraftMirror(FurnaceRecipes.instance().getSmeltingResult(item));

            return new CraftFurnaceRecipe(stack, CraftItemStack.asCraftMirror(item));
        }
    }

    public void remove() {
        if (removeFrom == null) {
            throw new IllegalStateException();
        }
        removeFrom.remove();
    }
}
