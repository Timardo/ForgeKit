package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.EntityType;

import net.minecraft.entity.monster.EntityElderGuardian;

public class CraftElderGuardian extends CraftGuardian implements ElderGuardian {

    public CraftElderGuardian(CraftServer server, EntityElderGuardian entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftElderGuardian";
    }

    @Override
    public EntityType getType() {
        return EntityType.ELDER_GUARDIAN;
    }

    @Override
    public boolean isElder() {
        return true;
    }
}
