package me.santres.menhunt.entities;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class HunterList {
    private final static Set<Player> hunterList = new HashSet<>();

    public static void addHunter(Player player) {
        HunterList.hunterList.add(player);
    }

    public static void removeHunter(Player player) {
        HunterList.hunterList.remove(player);
    }

    public static Set<Player> getHunters() {
        return HunterList.hunterList;
    }

    public static void reset() {
        hunterList.clear();
    }
}
