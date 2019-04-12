package org.bukkit.craftbukkit.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.DaylightDetector;

import net.minecraft.tileentity.TileEntityDaylightDetector;

public class CraftDaylightDetector extends CraftBlockEntityState<TileEntityDaylightDetector> implements DaylightDetector {

    public CraftDaylightDetector(final Block block) {
        super(block, TileEntityDaylightDetector.class);
    }

    public CraftDaylightDetector(final Material material, final TileEntityDaylightDetector te) {
        super(material, te);
    }
}
