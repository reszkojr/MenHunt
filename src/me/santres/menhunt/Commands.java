package me.santres.menhunt;

import me.santres.menhunt.entities.Speedrunner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (cmd.getName().equals("speedrunner")) {
            if (args.length == 2) {
                Player speedrunnerCandidate = Bukkit.getPlayer(args[1]);
                Speedrunner speedrunner = Speedrunner.getInstance();

                if (speedrunnerCandidate == null) {
                    sender.sendMessage(ChatColor.RED + "Player does not exist.");
                    return false;
                }

                switch (args[0]) {
                    case "add" -> {
                        if (speedrunner.get() == speedrunnerCandidate) {
                            sender.sendMessage(ChatColor.AQUA + speedrunnerCandidate.getName() + " already is speedrunner!");
                        }
                        PointerUpdater.startPointer();
                        speedrunner.set(speedrunnerCandidate);
                        sender.sendMessage(ChatColor.GREEN + speedrunnerCandidate.getName() + " is now speedrunner!");
                    }

                    case "remove" -> {
                        if (speedrunner.get() == null) {
                            sender.sendMessage(ChatColor.RED + "No speedrunner was set yet!");
                        }
                        PointerUpdater.cancelPointer();
                        sender.sendMessage(ChatColor.GREEN + speedrunnerCandidate.getName() +" is not speedrunner anymore.");
                        speedrunner.set(null);
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
