package org.bukkit.craftbukkit.inventory;

import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;

import net.minecraft.inventory.IInventory;

public class CraftInventoryHorse extends CraftInventoryAbstractHorse implements HorseInventory {

    public CraftInventoryHorse(IInventory inventory) {
        super(inventory);
    }

    public ItemStack getArmor() {
       return getItem(1);
    }

    public void setArmor(ItemStack stack) {
        setItem(1, stack);
    }
}
