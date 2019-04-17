package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

import net.minecraft.entity.EntityCreature;

public class CraftCreature extends CraftLivingEntity implements Creature {
    public CraftCreature(CraftServer server, EntityCreature entity) {
        super(server, entity);
    }

    public void setTarget(LivingEntity target) {
        EntityCreature entity = getHandle();
        if (target == null) {
            entity.setAttackTarget(null, null, false); //TODO impl
        } else if (target instanceof CraftLivingEntity) {
            entity.setAttackTarget(((CraftLivingEntity) target).getHandle(), null, false); //TODO impl
        }
    }

    public CraftLivingEntity getTarget() {
        if (getHandle().getAttackTarget() == null) return null;

        return (CraftLivingEntity) getHandle().getAttackTarget().getBukkitEntity(); //TODO impl
    }

    @Override
    public EntityCreature getHandle() {
        return (EntityCreature) entity;
    }

    @Override
    public String toString() {
        return "CraftCreature";
    }
}
