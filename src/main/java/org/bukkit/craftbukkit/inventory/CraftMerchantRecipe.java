package org.bukkit.craftbukkit.inventory;

import com.google.common.base.Preconditions;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class CraftMerchantRecipe extends MerchantRecipe {

    private final net.minecraft.village.MerchantRecipe handle;

    public CraftMerchantRecipe(net.minecraft.village.MerchantRecipe merchantRecipe) {
        super(CraftItemStack.asBukkitCopy(merchantRecipe.getItemToSell()), 0);
        this.handle = merchantRecipe;
        addIngredient(CraftItemStack.asBukkitCopy(merchantRecipe.getItemToBuy()));
        addIngredient(CraftItemStack.asBukkitCopy(merchantRecipe.getSecondItemToBuy()));
    }

    public CraftMerchantRecipe(ItemStack result, int uses, int maxUses, boolean experienceReward) {
        super(result, uses, maxUses, experienceReward);
        this.handle = new net.minecraft.village.MerchantRecipe( //TODO impl
        		net.minecraft.item.ItemStack.EMPTY,
        		net.minecraft.item.ItemStack.EMPTY,
                CraftItemStack.asNMSCopy(result),
                uses,
                maxUses,
                this
        );
    }

    @Override
    public int getUses() {
        return handle.getToolUses();
    }

    @Override
    public void setUses(int uses) {
        handle.toolUses = uses; //TODO AT
    }

    @Override
    public int getMaxUses() {
        return handle.getMaxTradeUses();
    }

    @Override
    public void setMaxUses(int maxUses) {
        handle.maxTradeUses = maxUses; //TODO AT
    }

    @Override
    public boolean hasExperienceReward() {
        return handle.getRewardsExp();
    }

    @Override
    public void setExperienceReward(boolean flag) {
        handle.rewardsExp = flag; //TODO AT
    }

    public net.minecraft.village.MerchantRecipe toMinecraft() {
        List<ItemStack> ingredients = getIngredients();
        Preconditions.checkState(!ingredients.isEmpty(), "No offered ingredients");
        handle.itemToBuy = CraftItemStack.asNMSCopy(ingredients.get(0)); //TODO AT
        if (ingredients.size() > 1) {
            handle.secondItemToBuy = CraftItemStack.asNMSCopy(ingredients.get(1)); //TODO AT
        }
        return handle;
    }

    public static CraftMerchantRecipe fromBukkit(MerchantRecipe recipe) {
        if (recipe instanceof CraftMerchantRecipe) {
            return (CraftMerchantRecipe) recipe;
        } else {
            CraftMerchantRecipe craft = new CraftMerchantRecipe(recipe.getResult(), recipe.getUses(), recipe.getMaxUses(), recipe.hasExperienceReward());
            craft.setIngredients(recipe.getIngredients());

            return craft;
        }
    }
}
