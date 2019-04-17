package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;

import net.minecraft.entity.projectile.EntitySnowball;

public class CraftSnowball extends CraftProjectile implements Snowball {
    public CraftSnowball(CraftServer server, EntitySnowball entity) {
        super(server, entity);
    }

    @Override
    public EntitySnowball getHandle() {
        return (EntitySnowball) entity;
    }

    @Override
    public String toString() {
        return "CraftSnowball";
    }

    public EntityType getType() {
        return EntityType.SNOWBALL;
    }
}
