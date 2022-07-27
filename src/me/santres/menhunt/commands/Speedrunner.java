package me.santres.menhunt.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Speedrunner implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (cmd.getName().equals("speedrunner")) {
            if (args.length == 2) {
                switch (args[0]) {
                    case "add" -> {

                    }

                    case "remove" -> {

                    }
                }
            } else {
                sendUsage(sender);
            }
        }
        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Wrong usage.");
        sender.sendMessage(ChatColor.RED + "Use \"/speedrunner add|remove <player>\"");
    }
}
