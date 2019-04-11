package org.bukkit.craftbukkit.util;

import org.bukkit.NamespacedKey;

import net.minecraft.util.ResourceLocation;

public final class CraftNamespacedKey {

    public CraftNamespacedKey() {
    }

    public static NamespacedKey fromString(String string) {
        return fromMinecraft(new ResourceLocation(string));
    }

    @SuppressWarnings("deprecation")
	public static NamespacedKey fromMinecraft(ResourceLocation minecraft) {
        return new NamespacedKey(minecraft.getResourceDomain(), minecraft.getResourcePath());
    }

    public static ResourceLocation toMinecraft(NamespacedKey key) {
        return new ResourceLocation(key.getNamespace(), key.getKey());
    }
}
