package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.SkeletonHorse;

import net.minecraft.entity.passive.EntitySkeletonHorse;

@SuppressWarnings("deprecation")
public class CraftSkeletonHorse extends CraftAbstractHorse implements SkeletonHorse {

    public CraftSkeletonHorse(CraftServer server, EntitySkeletonHorse entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftSkeletonHorse";
    }

    @Override
    public EntityType getType() {
        return EntityType.SKELETON_HORSE;
    }

    @Override
    public Variant getVariant() {
        return Variant.SKELETON_HORSE;
    }
}
