package org.bukkit.craftbukkit.entity;

import com.google.common.base.Preconditions;

import net.minecraft.entity.monster.EntityShulker;

import org.bukkit.DyeColor;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Shulker;

public class CraftShulker extends CraftGolem implements Shulker {

    public CraftShulker(CraftServer server, EntityShulker entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftShulker";
    }

    @Override
    public EntityType getType() {
        return EntityType.SHULKER;
    }

    @Override
    public EntityShulker getHandle() {
        return (EntityShulker) entity;
    }

    @SuppressWarnings("deprecation")
	@Override
    public DyeColor getColor() {
        return DyeColor.getByWoolData(getHandle().getDataManager().get(EntityShulker.COLOR));
    }

    @SuppressWarnings("deprecation")
	@Override
    public void setColor(DyeColor color) {
        Preconditions.checkArgument(color != null, "color");

        getHandle().getDataManager().set(EntityShulker.COLOR, color.getWoolData());
    }
}
