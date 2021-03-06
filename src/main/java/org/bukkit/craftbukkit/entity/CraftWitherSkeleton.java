package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;

import net.minecraft.entity.monster.EntityWitherSkeleton;

public class CraftWitherSkeleton extends CraftSkeleton implements WitherSkeleton {

    public CraftWitherSkeleton(CraftServer server, EntityWitherSkeleton entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftWitherSkeleton";
    }

    @Override
    public EntityType getType() {
        return EntityType.WITHER_SKELETON;
    }

    @SuppressWarnings("deprecation")
	@Override
    public SkeletonType getSkeletonType() {
        return SkeletonType.WITHER;
    }
}
