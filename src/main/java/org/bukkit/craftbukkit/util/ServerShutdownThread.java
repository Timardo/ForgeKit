package org.bukkit.craftbukkit.util;

import net.minecraft.server.MinecraftServer;

public class ServerShutdownThread extends Thread {
    private final MinecraftServer server;

    public ServerShutdownThread(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public void run() {
//        try { //TODO since method MinecraftServer#stopServer() doesn't include bukkit stuff yet, no exception should be raised
            server.stopServer();
//        } catch (MinecraftException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                server.reader.getTerminal().restore();
//            } catch (Exception e) {
//            }
//        }
    }
}
