package me.santres.menhunt;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MenHunt extends JavaPlugin {

    @Override
    public void onEnable() {
        Utils.printBroadcast(ChatColor.GREEN + "MenHunt initiated.");
    }

    @Override
    public void onDisable() {
        Utils.printBroadcast(ChatColor.RED + "MenHunt disabled.");
    }
}
