package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LeashHitch;

import net.minecraft.entity.EntityLeashKnot;

public class CraftLeash extends CraftHanging implements LeashHitch {
    public CraftLeash(CraftServer server, EntityLeashKnot entity) {
        super(server, entity);
    }

    @Override
    public EntityLeashKnot getHandle() {
        return (EntityLeashKnot) entity;
    }

    @Override
    public String toString() {
        return "CraftLeash";
    }

    public EntityType getType() {
        return EntityType.LEASH_HITCH;
    }
}
