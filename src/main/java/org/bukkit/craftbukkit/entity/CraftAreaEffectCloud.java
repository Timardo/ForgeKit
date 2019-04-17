package org.bukkit.craftbukkit.entity;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.CraftParticle;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.potion.CraftPotionUtil;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.potion.PotionData;

import com.google.common.collect.ImmutableList;

import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class CraftAreaEffectCloud extends CraftEntity implements AreaEffectCloud {

    public CraftAreaEffectCloud(CraftServer server, EntityAreaEffectCloud entity) {
        super(server, entity);
    }

    @Override
    public EntityAreaEffectCloud getHandle() {
        return (EntityAreaEffectCloud) super.getHandle();
    }

    @Override
    public String toString() {
        return "CraftAreaEffectCloud";
    }

    @Override
    public EntityType getType() {
        return EntityType.AREA_EFFECT_CLOUD;
    }

    @Override
    public int getDuration() {
        return getHandle().getDuration();
    }

    @Override
    public void setDuration(int duration) {
        getHandle().setDuration(duration);
    }

    @Override
    public int getWaitTime() {
        return getHandle().waitTime; //TODO AT
    }

    @Override
    public void setWaitTime(int waitTime) {
        getHandle().setWaitTime(waitTime);
    }

    @Override
    public int getReapplicationDelay() {
        return getHandle().reapplicationDelay; //TODO AT
    }

    @Override
    public void setReapplicationDelay(int delay) {
        getHandle().reapplicationDelay = delay; //TODO AT
    }

    @Override
    public int getDurationOnUse() {
        return getHandle().durationOnUse; //TODO AT
    }

    @Override
    public void setDurationOnUse(int duration) {
        getHandle().durationOnUse = duration; //TODO AT
    }

    @Override
    public float getRadius() {
        return getHandle().getRadius();
    }

    @Override
    public void setRadius(float radius) {
        getHandle().setRadius(radius);
    }

    @Override
    public float getRadiusOnUse() {
        return getHandle().radiusOnUse; //TODO AT
    }

    @Override
    public void setRadiusOnUse(float radius) {
        getHandle().setRadiusOnUse(radius);
    }

    @Override
    public float getRadiusPerTick() {
        return getHandle().radiusPerTick; //TODO AT
    }

    @Override
    public void setRadiusPerTick(float radius) {
        getHandle().setRadiusPerTick(radius);
    }

    @Override
    public Particle getParticle() {
        return CraftParticle.toBukkit(getHandle().getParticle());
    }

    @Override
    public void setParticle(Particle particle) {
        getHandle().setParticle(CraftParticle.toNMS(particle));
    }

    @Override
    public Color getColor() {
        return Color.fromRGB(getHandle().getColor());
    }

    @Override
    public void setColor(Color color) {
        getHandle().setColor(color.asRGB());
    }

    @Override
    public boolean addCustomEffect(PotionEffect effect, boolean override) {
        int effectId = effect.getType().getId();
        net.minecraft.potion.PotionEffect existing = null;
        for (net.minecraft.potion.PotionEffect mobEffect : getHandle().effects) { //TODO AT
            if (Potion.getIdFromPotion(mobEffect.getPotion()) == effectId) {
                existing = mobEffect;
            }
        }
        if (existing != null) {
            if (!override) {
                return false;
            }
            getHandle().effects.remove(existing); //TODO AT
        }
        getHandle().addEffect(CraftPotionUtil.fromBukkit(effect));
        getHandle().refreshEffects(); //TODO imlp
        return true;
    }

    @Override
    public void clearCustomEffects() {
        getHandle().effects.clear(); //TODO AT
        getHandle().refreshEffects(); //TODO impl
    }

    @Override
    public List<PotionEffect> getCustomEffects() {
        ImmutableList.Builder<PotionEffect> builder = ImmutableList.builder();
        for (net.minecraft.potion.PotionEffect effect : getHandle().effects) { //TODO AT
            builder.add(CraftPotionUtil.toBukkit(effect));
        }
        return builder.build();
    }

    @Override
    public boolean hasCustomEffect(PotionEffectType type) {
        for (net.minecraft.potion.PotionEffect effect : getHandle().effects) { //TODO AT
            if (CraftPotionUtil.equals(effect.getPotion(), type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasCustomEffects() {
        return !getHandle().effects.isEmpty(); //TODO AT
    }

    @Override
    public boolean removeCustomEffect(PotionEffectType effect) {
        int effectId = effect.getId();
        net.minecraft.potion.PotionEffect existing = null;
        for (net.minecraft.potion.PotionEffect mobEffect : getHandle().effects) { //TODO AT
            if (Potion.getIdFromPotion(mobEffect.getPotion()) == effectId) {
                existing = mobEffect;
            }
        }
        if (existing == null) {
            return false;
        }
        getHandle().effects.remove(existing); //TODO AT
        getHandle().refreshEffects(); //TODO impl
        return true;
    }

    @Override
    public void setBasePotionData(PotionData data) {
        Validate.notNull(data, "PotionData cannot be null");
        getHandle().setType(CraftPotionUtil.fromBukkit(data)); //TODO impl
    }

    @Override
    public PotionData getBasePotionData() {
        return CraftPotionUtil.toBukkit(getHandle().getType()); //TODO impl
    }

    public ProjectileSource getSource() {
        EntityLivingBase source = getHandle().getOwner();
        return (source == null) ? null : (LivingEntity) source.getBukkitEntity(); //TODO impl
    }

    public void setSource(ProjectileSource shooter) {
        if (shooter instanceof CraftLivingEntity) {
            getHandle().setOwner((EntityLivingBase) ((CraftLivingEntity) shooter).getHandle());
        } else {
            getHandle().setOwner((EntityLivingBase) null);
        }
    }
}
