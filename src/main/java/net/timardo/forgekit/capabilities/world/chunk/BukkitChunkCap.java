package net.timardo.forgekit.capabilities.world.chunk;

import org.bukkit.Chunk;

public class BukkitChunkCap implements IBukkitChunkCap {
	
	public Chunk bukkit;

	@Override
	public void setBukkitChunk(Chunk chunk) {
		this.bukkit = chunk;
		
	}

	@Override
	public Chunk getBukkitChunk() {
		return this.bukkit;
	}

}
