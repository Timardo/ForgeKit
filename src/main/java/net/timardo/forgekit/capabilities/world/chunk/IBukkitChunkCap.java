package net.timardo.forgekit.capabilities.world.chunk;

import org.bukkit.Chunk;

public interface IBukkitChunkCap {
	/**
	 * Sets the bukkit chunk version of a chunk
	 */
	public void setBukkitChunk(Chunk chunk);
	
	/**
	 * Gets the bukkit chunk
	 */
	public Chunk getBukkitChunk();
}
