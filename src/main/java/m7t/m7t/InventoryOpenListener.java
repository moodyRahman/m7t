package m7t.m7t;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class InventoryOpenListener implements Listener {

    @EventHandler
    public void onEggThrow(PlayerEggThrowEvent e) {
        Bukkit.getLogger().info("omg... there's an egg!" + e.getPlayer().getName());
    }

}
