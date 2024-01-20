package m7t.m7t.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WalkListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // Bukkit.getLogger().info("detected some movement from " +
        // event.getPlayer().getName() + " "
        // + event.getPlayer().getLocation().getX() + ", "
        // + event.getPlayer().getLocation().getY() + ", "
        // + event.getPlayer().getLocation().getZ() + ", ");

        event.getPlayer().setLevel((int) event.getPlayer().getLocation().getY());
    }
}
