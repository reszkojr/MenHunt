package me.santres.menhunt;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterHunter extends JavaPlugin {

    @Override
    public void onEnable() {
        Utils.printBroadcast(ChatColor.GREEN + "BetterHunter initiated.");
    }

    @Override
    public void onDisable() {
        Utils.printBroadcast(ChatColor.RED + "BetterHunter disabled.");
    }
}
