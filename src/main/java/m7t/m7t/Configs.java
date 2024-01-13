package m7t.m7t;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configs {

    public static int JavalinPort;

    public Configs(JavaPlugin server) {
        server.saveDefaultConfig();
        FileConfiguration config = server.getConfig();

        config.addDefault("javalin-port", 13303);

        config.options().copyDefaults(true);
        server.saveConfig();

        File newFolder = new File(server.getDataFolder().getAbsolutePath() + "/scripts");

        if (!newFolder.exists()) {
            newFolder.mkdirs(); // create the new folder
        }

        server.getLogger().info("loaded javalin port is " + config.getInt("javalin-port"));
        JavalinPort = config.getInt("javalin-port");

    }
}
