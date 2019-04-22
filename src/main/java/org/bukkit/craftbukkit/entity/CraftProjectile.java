package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;

public abstract class CraftProjectile extends AbstractProjectile implements Projectile {
    public CraftProjectile(CraftServer server, net.minecraft.entity.Entity entity) {
        super(server, entity);
    }

    public ProjectileSource getShooter() {
        return getHandle().projectileSource; //TODO impl
    }

    public void setShooter(ProjectileSource shooter) {
        if (shooter instanceof CraftLivingEntity) {
            getHandle().thrower = (EntityLivingBase) ((CraftLivingEntity) shooter).entity;
            if (shooter instanceof CraftHumanEntity) {
                getHandle().throwerName = ((CraftHumanEntity) shooter).getName();
            }
        } else {
            getHandle().thrower = null;
            getHandle().throwerName = null;
        }
        getHandle().projectileSource = shooter; //TODO impl
    }

    @Override
    public EntityThrowable getHandle() {
        return (EntityThrowable) entity;
    }

    @Override
    public String toString() {
        return "CraftProjectile";
    }
}
