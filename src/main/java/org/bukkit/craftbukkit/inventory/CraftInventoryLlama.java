package org.bukkit.craftbukkit.inventory;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.LlamaInventory;

import net.minecraft.inventory.IInventory;

public class CraftInventoryLlama extends CraftInventoryAbstractHorse implements LlamaInventory {

    public CraftInventoryLlama(IInventory inventory) {
        super(inventory);
    }

    @Override
    public ItemStack getDecor() {
        return getItem(1);
    }

    @Override
    public void setDecor(ItemStack stack) {
        setItem(1, stack);
    }
}
