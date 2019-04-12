package org.bukkit.craftbukkit.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Comparator;

import net.minecraft.tileentity.TileEntityComparator;

public class CraftComparator extends CraftBlockEntityState<TileEntityComparator> implements Comparator {

    public CraftComparator(final Block block) {
        super(block, TileEntityComparator.class);
    }

    public CraftComparator(final Material material, final TileEntityComparator te) {
        super(material, te);
    }
}
