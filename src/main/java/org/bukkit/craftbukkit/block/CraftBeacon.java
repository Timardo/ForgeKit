package org.bukkit.craftbukkit.block;

import java.util.ArrayList;
import java.util.Collection;
import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.inventory.CraftInventoryBeacon;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.BeaconInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;

public class CraftBeacon extends CraftContainer<TileEntityBeacon> implements Beacon {

    public CraftBeacon(final Block block) {
        super(block, TileEntityBeacon.class);
    }

    public CraftBeacon(final Material material, final TileEntityBeacon te) {
        super(material, te);
    }

    @Override
    public BeaconInventory getSnapshotInventory() {
        return new CraftInventoryBeacon(this.getSnapshot());
    }

    @Override
    public BeaconInventory getInventory() {
        if (!this.isPlaced()) {
            return this.getSnapshotInventory();
        }

        return new CraftInventoryBeacon(this.getTileEntity());
    }

    @Override
    public Collection<LivingEntity> getEntitiesInRange() {
        TileEntity tileEntity = this.getTileEntityFromWorld();
        if (tileEntity instanceof TileEntityBeacon) {
            TileEntityBeacon beacon = (TileEntityBeacon) tileEntity;

            Collection<EntityPlayer> nms = beacon.getHumansInRange(); //TODO impl
            Collection<LivingEntity> bukkit = new ArrayList<LivingEntity>(nms.size());

            for (EntityPlayer human : nms) {
                bukkit.add(human.getBukkitEntity()); //TODO impl
            }

            return bukkit;
        }

        return new ArrayList<LivingEntity>();
    }

    @Override
    public int getTier() {
        return this.getSnapshot().getLevels();
    }

    @Override
    public PotionEffect getPrimaryEffect() {
        return this.getSnapshot().getPrimaryEffect(); //TODO impl
    }

    @SuppressWarnings("deprecation")
	@Override
    public void setPrimaryEffect(PotionEffectType effect) {
        this.getSnapshot().primaryEffect = (effect != null) ? Potion.getPotionById(effect.getId()) : null;
    }

    @Override
    public PotionEffect getSecondaryEffect() {
        return this.getSnapshot().getSecondaryEffect(); //TODO impl
    }

    @SuppressWarnings("deprecation")
	@Override
    public void setSecondaryEffect(PotionEffectType effect) {
        this.getSnapshot().secondaryEffect = (effect != null) ? Potion.getPotionById(effect.getId()) : null;
    }

    @Override
    public String getCustomName() {
        TileEntityBeacon beacon = this.getSnapshot();
        return beacon.hasCustomName() ? beacon.getName() : null;
    }

    @Override
    public void setCustomName(String name) {
        this.getSnapshot().setName(name);
    }
}
