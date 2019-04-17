package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.projectiles.ProjectileSource;

import net.minecraft.entity.projectile.EntityShulkerBullet;

public class CraftShulkerBullet extends AbstractProjectile implements ShulkerBullet {

    public CraftShulkerBullet(CraftServer server, EntityShulkerBullet entity) {
        super(server, entity);
    }

    @Override
    public ProjectileSource getShooter() {
        return getHandle().projectileSource; //TODO impl
    }

    @Override
    public void setShooter(ProjectileSource shooter) {
        if (shooter instanceof LivingEntity) {
            getHandle().setShooter(((CraftLivingEntity) shooter).getHandle()); //TODO impl
        } else {
            getHandle().setShooter(null); //TODO impl
        }
        getHandle().projectileSource = shooter; //TODO impl
    }

    @Override
    public org.bukkit.entity.Entity getTarget() {
        return getHandle().getTarget() != null ? getHandle().getTarget().getBukkitEntity() : null; //TODO impl
    }

    @Override
    public void setTarget(org.bukkit.entity.Entity target) {
        getHandle().setTarget(target == null ? null : ((CraftEntity) target).getHandle()); //TODO impl
    }

    @Override
    public String toString() {
        return "CraftShulkerBullet";
    }

    @Override
    public EntityType getType() {
        return EntityType.SHULKER_BULLET;
    }

    @Override
    public EntityShulkerBullet getHandle() {
        return (EntityShulkerBullet) entity;
    }
}
