package m7t.m7t.server;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import io.javalin.Javalin;

public class Server {

    Javalin app;

    public Server() {
        app = Javalin.create().start(8080);

        app.get("/", ctx -> {
            ctx.result("Hello World!");
            Bukkit.getLogger().warning("got an API call...");

            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage("got an API call...");
            }
        });

        app.get("/increment", ctx -> {
        });

    }
}
