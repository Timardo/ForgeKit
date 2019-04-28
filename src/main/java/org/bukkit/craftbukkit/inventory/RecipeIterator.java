package org.bukkit.craftbukkit.inventory;

import java.util.Iterator;

import org.bukkit.inventory.Recipe;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class RecipeIterator implements Iterator<Recipe> {
    private final Iterator<IRecipe> recipes;
    // private final Iterator<net.minecraft.item.ItemStack> smeltingCustom;
    private final Iterator<net.minecraft.item.ItemStack> smeltingVanilla;
    private Iterator<?> removeFrom = null;

    public RecipeIterator() {
        // this.recipes = CraftingManager.REGISTRY.iterator();
        this.recipes = ForgeRegistries.RECIPES.iterator();
        // this.smeltingCustom = FurnaceRecipes.instance().customRecipes.keySet().iterator(); //ForgeKit - no custom recipes field, just regular one
        this.smeltingVanilla = FurnaceRecipes.instance().getSmeltingList().keySet().iterator();
    }

    public boolean hasNext() {
        return recipes.hasNext() /*|| smeltingCustom.hasNext() */|| smeltingVanilla.hasNext();
    }

    public Recipe next() {
        if (recipes.hasNext()) {
            removeFrom = recipes;
            return recipes.next().toBukkitRecipe(); //TODO impl
        } else {
            net.minecraft.item.ItemStack item;
            if (smeltingVanilla.hasNext()) {
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
