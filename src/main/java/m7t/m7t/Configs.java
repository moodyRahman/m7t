package m7t.m7t;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configs {

    // we can define a convenient and typesafe way to access config variables here
    public static int JavalinPort;
    public static boolean ShutOff;
    public static int StartingTime;

    public Configs(JavaPlugin server) {
        server.saveDefaultConfig();
        FileConfiguration config = server.getConfig();

        config.addDefault("javalin-port", 13303);
        config.addDefault("auto-shutoff", false);
        config.addDefault("starting-time", 60);

        config.options().copyDefaults(true);
        server.saveConfig();

        File newFolder = new File(server.getDataFolder().getAbsolutePath() + "/scripts");

        if (!newFolder.exists()) {
            newFolder.mkdirs(); // create the new folder
        }

        JavalinPort = config.getInt("javalin-port");
        ShutOff = config.getBoolean("auto-shutoff");
        StartingTime = config.getInt("starting-time");

    }
}
