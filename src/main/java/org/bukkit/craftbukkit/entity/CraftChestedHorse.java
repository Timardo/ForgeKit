package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.ChestedHorse;

import net.minecraft.entity.passive.AbstractChestHorse;

public abstract class CraftChestedHorse extends CraftAbstractHorse implements ChestedHorse {

    public CraftChestedHorse(CraftServer server, AbstractChestHorse entity) {
        super(server, entity);
    }

    @Override
    public AbstractChestHorse getHandle() {
        return (AbstractChestHorse) super.getHandle();
    }

    @Override
    public boolean isCarryingChest() {
        return getHandle().hasChest();
    }

    @Override
    public void setCarryingChest(boolean chest) {
        if (chest == isCarryingChest()) return;
        getHandle().setChested(chest);
        getHandle().initHorseChest(); //TODO AT
    }
}
