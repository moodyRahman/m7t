package m7t.m7t.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class InventoryOpenListener implements Listener {

    @EventHandler
    public void onEggThrow(PlayerEggThrowEvent e) {
        Bukkit.getLogger().info("omg... there's an egg!" + e.getPlayer().getName());
    }

    @EventHandler
    public void PlayerDropItemEvent(PlayerDropItemEvent e) {
        e.getPlayer().setHealth(0);
    }

}
