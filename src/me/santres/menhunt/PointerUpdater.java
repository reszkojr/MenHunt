package me.santres.menhunt;

import me.santres.menhunt.entities.HunterList;
import me.santres.menhunt.entities.Speedrunner;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class PointerUpdater extends BukkitRunnable {

    private static PointerUpdater pc = new PointerUpdater();;

    public static void startPointer() {
        pc.runTaskTimer(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MenHunt")), 0L, 2L);
    }

    public static void cancelPointer() {
        pc.cancel();
    }

    @Override
    public void run() {
        for (Player player : HunterList.getHunters()) {
            PointerCreator pc = new PointerCreator(player.getLocation(), Speedrunner.getInstance().get().getLocation());
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(pc.create()));
        }
    }
}
