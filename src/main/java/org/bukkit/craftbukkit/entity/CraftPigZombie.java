package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;

import net.minecraft.entity.monster.EntityPigZombie;

public class CraftPigZombie extends CraftZombie implements PigZombie {

    public CraftPigZombie(CraftServer server, EntityPigZombie entity) {
        super(server, entity);
    }

    public int getAnger() {
        return getHandle().angerLevel; //TODO AT
    }

    public void setAnger(int level) {
        getHandle().angerLevel = level; //TODO AT
    }

    public void setAngry(boolean angry) {
        setAnger(angry ? 400 : 0);
    }

    public boolean isAngry() {
        return getAnger() > 0;
    }

    @Override
    public EntityPigZombie getHandle() {
        return (EntityPigZombie) entity;
    }

    @Override
    public String toString() {
        return "CraftPigZombie";
    }

    public EntityType getType() {
        return EntityType.PIG_ZOMBIE;
    }
}
