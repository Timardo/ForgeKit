package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;

import net.minecraft.entity.monster.AbstractSkeleton;

public class CraftSkeleton extends CraftMonster implements Skeleton {

    public CraftSkeleton(CraftServer server, AbstractSkeleton entity) {
        super(server, entity);
    }

    @Override
    public AbstractSkeleton getHandle() {
        return (AbstractSkeleton) entity;
    }

    @Override
    public String toString() {
        return "CraftSkeleton";
    }

    public EntityType getType() {
        return EntityType.SKELETON;
    }

    @SuppressWarnings("deprecation")
	@Override
    public SkeletonType getSkeletonType() {
       return SkeletonType.NORMAL;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void setSkeletonType(SkeletonType type) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
