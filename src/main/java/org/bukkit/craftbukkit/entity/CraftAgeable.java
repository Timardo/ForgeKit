package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Ageable;

import net.minecraft.entity.EntityAgeable;

public class CraftAgeable extends CraftCreature implements Ageable {
    public CraftAgeable(CraftServer server, EntityAgeable entity) {
        super(server, entity);
    }

    public int getAge() {
        return getHandle().getGrowingAge();
    }

    public void setAge(int age) {
        getHandle().setGrowingAge(age);
    }

    public void setAgeLock(boolean lock) {
        getHandle().ageLocked = lock;
    }
    /* 
     * ageLocked - used for locking entity's age so it won't grow up in EntityAgeable.onLivingUpdate() L-210
     * possible solution - hook the LivingEvent#LivingUpdateEvent and handle EntityAgeable#growingAge - set it to growingAge-1 if a capability is true
     * TODO - event
     * TODO - capability
     */
    public boolean getAgeLock() {
        return getHandle().ageLocked;
    }

    public void setBaby() {
        if (isAdult()) {
            setAge(-24000);
        }
    }

    public void setAdult() {
        if (!isAdult()) {
            setAge(0);
        }
    }

    public boolean isAdult() {
        return getAge() >= 0;
    }


    public boolean canBreed() {
        return getAge() == 0;
    }

    public void setBreed(boolean breed) {
        if (breed) {
            setAge(0);
        } else if (isAdult()) {
            setAge(6000);
        }
    }

    @Override
    public EntityAgeable getHandle() {
        return (EntityAgeable) entity;
    }

    @Override
    public String toString() {
        return "CraftAgeable";
    }
}
