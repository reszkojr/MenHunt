package me.santres.menhunt;

import me.santres.menhunt.entities.Speedrunner;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {

    Speedrunner speedrunner = Speedrunner.getInstance();

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (event.getPlayer() != speedrunner.get()) return;
        speedrunner.set(null);

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity().getPlayer() == speedrunner.get()) return;
        for (ItemStack item : event.getDrops()) {
            if (item.getType() == Material.COMPASS) {
                event.getDrops().remove(item);
                break;
            }
        }
    }

    @EventHandler
    public void onPlayerPortalEnter(PlayerPortalEvent event) {
        if (event.getPlayer() != speedrunner.get()) return;
        if (event.getPlayer().getWorld().getEnvironment() != World.Environment.NORMAL) return;
        // The player needs to be the speedrunner and
        // has to be in the overworld to save the portal location.

        Location speedrunnerPortalLocation = event.getPlayer().getLocation();
    }
}

