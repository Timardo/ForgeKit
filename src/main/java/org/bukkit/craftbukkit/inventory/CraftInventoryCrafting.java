package org.bukkit.craftbukkit.inventory;

import java.util.Arrays;
import java.util.List;

import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.IRecipe;

public class CraftInventoryCrafting extends CraftInventory implements CraftingInventory {
    private final IInventory resultInventory;

    public CraftInventoryCrafting(InventoryCrafting inventory, IInventory resultInventory) {
        super(inventory);
        this.resultInventory = resultInventory;
    }

    public IInventory getResultInventory() {
        return resultInventory;
    }

    public IInventory getMatrixInventory() {
        return inventory;
    }

    @Override
    public int getSize() {
        return getResultInventory().getSizeInventory() + getMatrixInventory().getSizeInventory();
    }

    @Override
    public void setContents(ItemStack[] items) {
        if (getSize() > items.length) {
            throw new IllegalArgumentException("Invalid inventory size; expected " + getSize() + " or less");
        }
        setContents(items[0], Arrays.copyOfRange(items, 1, items.length));
    }

    @Override
    public ItemStack[] getContents() {
        ItemStack[] items = new ItemStack[getSize()];
        List<net.minecraft.item.ItemStack> mcResultItems = getResultInventory().getContents(); //TODO impl

        int i = 0;
        for (i = 0; i < mcResultItems.size(); i++ ) {
            items[i] = CraftItemStack.asCraftMirror(mcResultItems.get(i));
        }

        List<net.minecraft.item.ItemStack> mcItems = getMatrixInventory().getContents(); //TODO impl

        for (int j = 0; j < mcItems.size(); j++) {
            items[i + j] = CraftItemStack.asCraftMirror(mcItems.get(j));
        }

        return items;
    }

    public void setContents(ItemStack result, ItemStack[] contents) {
        setResult(result);
        setMatrix(contents);
    }

    @Override
    public CraftItemStack getItem(int index) {
        if (index < getResultInventory().getSizeInventory()) {
            net.minecraft.item.ItemStack item = getResultInventory().getStackInSlot(index);
            return item.isEmpty() ? null : CraftItemStack.asCraftMirror(item);
        } else {
            net.minecraft.item.ItemStack item = getMatrixInventory().getStackInSlot(index - getResultInventory().getSizeInventory());
            return item.isEmpty() ? null : CraftItemStack.asCraftMirror(item);
        }
    }

    @Override
    public void setItem(int index, ItemStack item) {
        if (index < getResultInventory().getSizeInventory()) {
            getResultInventory().setInventorySlotContents(index, CraftItemStack.asNMSCopy(item));
        } else {
            getMatrixInventory().setInventorySlotContents((index - getResultInventory().getSizeInventory()), CraftItemStack.asNMSCopy(item));
        }
    }

    public ItemStack[] getMatrix() {
        List<net.minecraft.item.ItemStack> matrix = getMatrixInventory().getContents(); //TODO impl

        return asCraftMirror(matrix);
    }

    public ItemStack getResult() {
        net.minecraft.item.ItemStack item = getResultInventory().getStackInSlot(0);
        if (!item.isEmpty()) return CraftItemStack.asCraftMirror(item);
        return null;
    }

    public void setMatrix(ItemStack[] contents) {
        if (getMatrixInventory().getSizeInventory() > contents.length) {
            throw new IllegalArgumentException("Invalid inventory size; expected " + getMatrixInventory().getSizeInventory() + " or less");
        }

        for (int i = 0; i < getMatrixInventory().getSizeInventory(); i++) {
            if (i < contents.length) {
                getMatrixInventory().setInventorySlotContents(i, CraftItemStack.asNMSCopy(contents[i]));
            } else {
                getMatrixInventory().setInventorySlotContents(i, net.minecraft.item.ItemStack.EMPTY);
            }
        }
    }

    public void setResult(ItemStack item) {
        List<net.minecraft.item.ItemStack> contents = getResultInventory().getContents(); //TODO impl
        contents.set(0, CraftItemStack.asNMSCopy(item));
    }

    public Recipe getRecipe() {
        IRecipe recipe = ((InventoryCrafting)getInventory()).currentRecipe;
        /*
         * currentRecipe - holds the currently crafted item for PrepareItemCraftEvent, declared in CraftingManager#findMatchingRecipe and in RecipeRepairItem#getCraftingResult
         * this PrepareItemCraftEvent is actually called AFTER the forge's ItemCraftedEvent in fml's PlayerEvent class and BEFORE bukkit's CraftItemEvent, not sure about the 
         * anvil version, but it looks like it's called after the AnvilUpdateEvent
         * possible solution - subscribe to fml's PlayerEvent#ItemCraftedEvent and call the PrepareItemCraftEvent here with correct args, subscribe to AnvilUpdateEvent and also
         * call the PrepareItemCraftEvent as an Anvil version with correct args, also replace this method's body with universal native getter to avoid problems with toBukkitRecipe
         * method below so plugins will always get valid reference to the recipe being used in the crafting event
         * TODO - event
         */
        return recipe == null ? null : recipe.toBukkitRecipe(); //TODO impl
    }
}
