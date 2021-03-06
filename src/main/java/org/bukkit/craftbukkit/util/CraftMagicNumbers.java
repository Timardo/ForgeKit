package org.bukkit.craftbukkit.util;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.advancements.AdvancementManager;
import net.minecraft.item.Item;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;

import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Statistic;
import org.bukkit.UnsafeValues;
import org.bukkit.advancement.Advancement;
import org.bukkit.craftbukkit.CraftStatistic;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

@SuppressWarnings("deprecation")
public final class CraftMagicNumbers implements UnsafeValues {
    public static final UnsafeValues INSTANCE = new CraftMagicNumbers();

    private CraftMagicNumbers() {}

    public static net.minecraft.block.Block getBlock(org.bukkit.block.Block block) {
        return getBlock(block.getType());
    }

    @Deprecated
    public static net.minecraft.block.Block getBlock(int id) {
        return getBlock(Material.getMaterial(id));
    }

    @Deprecated
    public static int getId(net.minecraft.block.Block block) {
        return net.minecraft.block.Block.getIdFromBlock(block);
    }

    public static Material getMaterial(net.minecraft.block.Block block) {
        return Material.getMaterial(net.minecraft.block.Block.getIdFromBlock(block));
    }

    public static net.minecraft.item.Item getItem(Material material) {
    	net.minecraft.item.Item item = net.minecraft.item.Item.getItemById(material.getId());
        return item;
    }

    @Deprecated
    public static Item getItem(int id) {
        return Item.getItemById(id);
    }

    @Deprecated
    public static int getId(Item item) {
        return Item.getIdFromItem(item);
    }

    public static Material getMaterial(Item item) {
        Material material = Material.getMaterial(Item.getIdFromItem(item));

        if (material == null) {
            return Material.AIR;
        }

        return material;
    }

    public static net.minecraft.block.Block getBlock(Material material) {
        if (material == null) {
            return null;
        }
        net.minecraft.block.Block block = net.minecraft.block.Block.getBlockById(material.getId());

        if (block == null) {
            return net.minecraft.init.Blocks.AIR;
        }

        return block;
    }

    @Override
    public Material getMaterialFromInternalName(String name) {
        return getMaterial((Item) Item.REGISTRY.getObject(new ResourceLocation(name)));
    }

    @Override
    public List<String> tabCompleteInternalMaterialName(String token, List<String> completions) {
        ArrayList<String> results = Lists.newArrayList();
        for (ResourceLocation key : (Set<ResourceLocation>)Item.REGISTRY.getKeys()) {
            results.add(key.toString());
        }
        return StringUtil.copyPartialMatches(token, results, completions);
    }

    @Override
    public ItemStack modifyItemStack(ItemStack stack, String arguments) {
        net.minecraft.item.ItemStack nmsStack = CraftItemStack.asNMSCopy(stack);

        try {
            nmsStack.setTagCompound((NBTTagCompound) JsonToNBT.getTagFromJson(arguments));
        } catch (NBTException ex) {
            Logger.getLogger(CraftMagicNumbers.class.getName()).log(Level.SEVERE, null, ex);
        }

        stack.setItemMeta(CraftItemStack.getItemMeta(nmsStack));

        return stack;
    }

    @Override
    public Statistic getStatisticFromInternalName(String name) {
        return CraftStatistic.getBukkitStatisticByName(name);
    }

    @Override
    public Achievement getAchievementFromInternalName(String name) {
        throw new UnsupportedOperationException("Not supported in this Minecraft version.");
    }

    @SuppressWarnings("rawtypes")
	@Override
    public List<String> tabCompleteInternalStatisticOrAchievementName(String token, List<String> completions) {
        List<String> matches = new ArrayList<String>();
        Iterator iterator = StatList.ALL_STATS.iterator();
        while (iterator.hasNext()) {
            String statistic = ((net.minecraft.stats.StatBase) iterator.next()).statId;
            if (statistic.startsWith(token)) {
                matches.add(statistic);
            }
        }
        return matches;
    }

    @Override
    public Advancement loadAdvancement(NamespacedKey key, String advancement) {
        if (Bukkit.getAdvancement(key) != null) {
            throw new IllegalArgumentException("Advancement " + key + " already exists.");
        }

        net.minecraft.advancements.Advancement.Builder nms = (net.minecraft.advancements.Advancement.Builder) JsonUtils.gsonDeserialize(AdvancementManager.GSON, advancement, net.minecraft.advancements.Advancement.Builder.class);
        if (nms != null) {
        	AdvancementManager.ADVANCEMENT_LIST.loadAdvancements(Maps.newHashMap(Collections.singletonMap(CraftNamespacedKey.toMinecraft(key), nms)));
            Advancement bukkit = Bukkit.getAdvancement(key);

            if (bukkit != null) {
                File file = new File(FMLCommonHandler.instance().getMinecraftServerInstance().getAdvancementManager().advancementsDir, key.getNamespace() + File.separator + key.getKey() + ".json");
                file.getParentFile().mkdirs();

                try {
                    Files.write(advancement, file, Charsets.UTF_8);
                } catch (IOException ex) {
                    Bukkit.getLogger().log(Level.SEVERE, "Error saving advancement " + key, ex);
                }

                FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().reloadResources();

                return bukkit;
            }
        }

        return null;
    }

    @Override
    public boolean removeAdvancement(NamespacedKey key) {
        File file = new File(FMLCommonHandler.instance().getMinecraftServerInstance().getAdvancementManager().advancementsDir, key.getNamespace() + File.separator + key.getKey() + ".json");
        return file.delete();
    }

    public static class NBT {

        public static final int TAG_END = 0;
        public static final int TAG_BYTE = 1;
        public static final int TAG_SHORT = 2;
        public static final int TAG_INT = 3;
        public static final int TAG_LONG = 4;
        public static final int TAG_FLOAT = 5;
        public static final int TAG_DOUBLE = 6;
        public static final int TAG_BYTE_ARRAY = 7;
        public static final int TAG_STRING = 8;
        public static final int TAG_LIST = 9;
        public static final int TAG_COMPOUND = 10;
        public static final int TAG_INT_ARRAY = 11;
        public static final int TAG_ANY_NUMBER = 99;
    }
}
