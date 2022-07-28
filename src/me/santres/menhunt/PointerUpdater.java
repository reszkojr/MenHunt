package me.santres.menhunt;

import me.santres.menhunt.entities.HunterList;
import me.santres.menhunt.entities.Speedrunner;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PointerUpdater extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : HunterList.getHunters()) {
            PointerCreator pc = new PointerCreator(player.getLocation(), Speedrunner.getInstance().get().getLocation());
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(pc.create()));
        }
    }
}
