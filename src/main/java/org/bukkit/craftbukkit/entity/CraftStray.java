package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Stray;

import net.minecraft.entity.monster.EntityStray;

public class CraftStray extends CraftSkeleton implements Stray {

    public CraftStray(CraftServer server, EntityStray entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftStray";
    }

    @Override
    public EntityType getType() {
        return EntityType.STRAY;
    }

    @SuppressWarnings("deprecation")
	@Override
    public SkeletonType getSkeletonType() {
        return SkeletonType.STRAY;
    }
}
