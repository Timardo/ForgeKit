package net.timardo.forgekit.utils;

import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.PotionTypes;

public class NMSMethods {

	public static boolean isTipped(EntityTippedArrow entity) {
		return !(entity.customPotionEffects.isEmpty() && entity.potion == PotionTypes.EMPTY); //Is it actually needed to make an AT entry for the potion field?
	}

}
