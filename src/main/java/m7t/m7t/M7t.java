package m7t.m7t;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import io.javalin.Javalin;

public final class M7t extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup
        Bukkit.getLogger()
                .info("Hello there! Thank you for using m7t, a moody rahman project :), made proudle in VSCode");
        getServer().getPluginManager().registerEvents(new WalkListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryOpenListener(), this);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClassLoader());
        Javalin app = Javalin.create().start(8080);
        Thread.currentThread().setContextClassLoader(classLoader);
        app.get("/", ctx -> ctx.result("Hello World!"));
        getLogger().info("JavalinPlugin is enabled");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Goobnight");
    }
}
