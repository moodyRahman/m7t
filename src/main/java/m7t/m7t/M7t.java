package m7t.m7t;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import m7t.m7t.server.Server;

public final class M7t extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup
        Bukkit.getLogger()
                .info("m7t  Copyright (C) 2024  Moody Rahman");

        getServer().getPluginManager().registerEvents(new WalkListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryOpenListener(), this);

        new Server();

        getLogger().info("JavalinPlugin is enabled");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Goobnight");
    }
}
