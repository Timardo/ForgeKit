package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Slime;

import net.minecraft.entity.monster.EntitySlime;

public class CraftSlime extends CraftLivingEntity implements Slime {

    public CraftSlime(CraftServer server, EntitySlime entity) {
        super(server, entity);
    }

    public int getSize() {
        return getHandle().getSlimeSize();
    }

    public void setSize(int size) {
        getHandle().setSlimeSize(size, true); //TODO AT
    }

    @Override
    public void setTarget(LivingEntity target) {
        if (target == null) {
            getHandle().setAttackTarget(null, null, false); //TODO impl
        } else if (target instanceof CraftLivingEntity) {
            getHandle().setAttackTarget(((CraftLivingEntity) target).getHandle(), null, false); //TODO impl
        }
    }

    @Override
    public LivingEntity getTarget() {
        return getHandle().getAttackTarget() == null ? null : (LivingEntity)getHandle().getAttackTarget().getBukkitEntity(); //TODO impl
    }

    @Override
    public EntitySlime getHandle() {
        return (EntitySlime) entity;
    }

    @Override
    public String toString() {
        return "CraftSlime";
    }

    public EntityType getType() {
        return EntityType.SLIME;
    }
}
