package m7t.m7t.server;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import io.javalin.Javalin;
import m7t.m7t.Configs;

public class Server {

    Javalin app;

    public Server() {
        app = Javalin.create().start(Configs.JavalinPort);

        app.get("/", ctx -> {
            ctx.result("Hello World!");
            Bukkit.getLogger().warning("got an API call...");

            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage("got an API call...");
            }
        });

        app.get("/increment", ctx -> {
        });

        app.get("/stats", ctx -> {

            ArrayList<String> pout = new ArrayList<String>();
            for (Player p : Bukkit.getOnlinePlayers()) {
                pout.add(p.getName());
            }
            Bukkit.getLogger().info(pout.toString());
            ctx.json(pout);
        });

    }

    private class StatsResponse {
        ArrayList<String> onlinePlayers = new ArrayList<String>();

    }
}
