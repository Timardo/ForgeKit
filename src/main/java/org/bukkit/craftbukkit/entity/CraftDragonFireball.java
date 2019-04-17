package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.EntityType;

import net.minecraft.entity.projectile.EntityDragonFireball;

public class CraftDragonFireball extends CraftFireball implements DragonFireball {
    public CraftDragonFireball(CraftServer server, EntityDragonFireball entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftDragonFireball";
    }

    @Override
    public EntityType getType() {
        return EntityType.DRAGON_FIREBALL;
    }
}
