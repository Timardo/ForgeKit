package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Mule;

import net.minecraft.entity.passive.EntityMule;

@SuppressWarnings("deprecation")
public class CraftMule extends CraftChestedHorse implements Mule {

    public CraftMule(CraftServer server, EntityMule entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftMule";
    }

    @Override
    public EntityType getType() {
        return EntityType.MULE;
    }

    @Override
    public Variant getVariant() {
        return Variant.MULE;
    }
}
