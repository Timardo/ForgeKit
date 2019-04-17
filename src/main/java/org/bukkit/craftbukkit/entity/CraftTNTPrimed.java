package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;

public class CraftTNTPrimed extends CraftEntity implements TNTPrimed {

    public CraftTNTPrimed(CraftServer server, EntityTNTPrimed entity) {
        super(server, entity);
    }

    public float getYield() {
        return getHandle().yield; //TODO impl (probably useless)
    }

    public boolean isIncendiary() {
        return getHandle().isIncendiary; //TODO impl (probably useless)
    }

    public void setIsIncendiary(boolean isIncendiary) {
        getHandle().isIncendiary = isIncendiary; //TODO impl (probably useless)
    }

    public void setYield(float yield) {
        getHandle().yield = yield; //TODO impl (probably useless)
    }

    public int getFuseTicks() {
        return getHandle().getFuse();
    }

    public void setFuseTicks(int fuseTicks) {
        getHandle().setFuse(fuseTicks);
    }

    @Override
    public EntityTNTPrimed getHandle() {
        return (EntityTNTPrimed) entity;
    }

    @Override
    public String toString() {
        return "CraftTNTPrimed";
    }

    public EntityType getType() {
        return EntityType.PRIMED_TNT;
    }

    public Entity getSource() {
    	EntityLivingBase source = getHandle().getTntPlacedBy();

        return (source != null) ? source.getBukkitEntity() : null; //TODO impl
    }
}
