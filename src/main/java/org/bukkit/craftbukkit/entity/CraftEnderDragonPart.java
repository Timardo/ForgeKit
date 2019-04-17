package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.Entity;

import net.minecraft.entity.MultiPartEntityPart;

public class CraftEnderDragonPart extends CraftComplexPart implements EnderDragonPart {
    public CraftEnderDragonPart(CraftServer server, MultiPartEntityPart entity) {
        super(server, entity);
    }

    @Override
    public EnderDragon getParent() {
        return (EnderDragon) super.getParent();
    }

    @Override
    public MultiPartEntityPart getHandle() {
        return (MultiPartEntityPart) entity;
    }

    @Override
    public String toString() {
        return "CraftEnderDragonPart";
    }

    public void damage(double amount) {
        getParent().damage(amount);
    }

    public void damage(double amount, Entity source) {
        getParent().damage(amount, source);
    }

    public double getHealth() {
        return getParent().getHealth();
    }

    public void setHealth(double health) {
        getParent().setHealth(health);
    }

    @SuppressWarnings("deprecation")
	public double getMaxHealth() {
        return getParent().getMaxHealth();
    }

    @SuppressWarnings("deprecation")
	public void setMaxHealth(double health) {
        getParent().setMaxHealth(health);
    }

    @SuppressWarnings("deprecation")
	public void resetMaxHealth() {
        getParent().resetMaxHealth();
    }
}
