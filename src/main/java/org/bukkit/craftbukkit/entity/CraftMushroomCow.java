package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MushroomCow;

import net.minecraft.entity.passive.EntityMooshroom;

public class CraftMushroomCow extends CraftCow implements MushroomCow {
    public CraftMushroomCow(CraftServer server, EntityMooshroom entity) {
        super(server, entity);
    }

    @Override
    public EntityMooshroom getHandle() {
        return (EntityMooshroom) entity;
    }

    @Override
    public String toString() {
        return "CraftMushroomCow";
    }

    public EntityType getType() {
        return EntityType.MUSHROOM_COW;
    }
}
