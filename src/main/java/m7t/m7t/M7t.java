package m7t.m7t;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class M7t extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup
        Bukkit.getLogger().info("Hello there! Thank you for using m7t, a moody rahman project :)");
        getServer().getPluginManager().registerEvents(new WalkListener(), this);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Goobnight");
    }
}
