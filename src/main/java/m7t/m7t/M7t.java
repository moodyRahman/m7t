package m7t.m7t;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import m7t.m7t.db.Db;
import m7t.m7t.server.Server;

public final class M7t extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup
        Bukkit.getLogger()
                .info("m7t  Copyright (C) 2024  Moody Rahman");

        new Configs(this);
        new Server();
        new Db(this);

        getServer().getPluginManager().registerEvents(new WalkListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryOpenListener(), this);

        new BukkitRunnable() {
            @Override
            public void run() {
                getLogger().info("doing a check");
                Db.decrement();
            }
        }.runTaskTimer(this, 0L, 100);

        getLogger().info("JavalinPlugin is enabled");
        getLogger().info("Working Directory = " + this.getDataFolder().getAbsolutePath());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Goobnight");
        try {
            Db.conn.close();
            Bukkit.getLogger().info("successfully closed db");

        } catch (SQLException e) {
            Bukkit.getLogger().warning("error while closing db");
        }
    }
}
