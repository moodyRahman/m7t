package m7t.m7t;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import m7t.m7t.commands.RemainCommand;
import m7t.m7t.db.Db;
import m7t.m7t.listeners.InventoryOpenListener;
import m7t.m7t.listeners.WalkListener;
import m7t.m7t.server.Server;

public final class M7t extends JavaPlugin {

    public void broadcast(String s) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(s);
        }
    }

    @Override
    public void onEnable() {
        // Plugin startup
        Bukkit.getLogger()
                .info("m7t  Copyright (C) 2024  Moody Rahman");

        // initialize configs from the plugin .yml file
        // initialize the Javalin server
        // initialize the database
        new Configs(this);
        new Server();
        new Db(this);

        getServer().getPluginManager().registerEvents(new WalkListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryOpenListener(), this);

        // event loop that decrements the time remaining every iteration

        if (Configs.ShutOff) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Db.decrement();
                    int t = Db.getRemainingTime();
                    // getLogger().info("remaining active time: " + Integer.toString(t));

                    if (t % 30 == 0) {
                        broadcast("remaining active time: " + Integer.toString(t) + " minutes");
                        getLogger().info("remaining active time: " + Integer.toString(t));
                    }

                    if (t <= 5) {
                        broadcast("server shutting down in " + Db.getRemainingTime() + " minutes");
                    }

                    if (t <= 0) {
                        Bukkit.shutdown();
                    }
                }
            }.runTaskTimer(this, 0L, 100);
        }

        this.getCommand("m7t").setExecutor(new RemainCommand());

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
