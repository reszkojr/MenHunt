package me.santres.menhunt.entities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/*
    I still don't know if using a singleton for the speedrunner
    is the best method, I'm still learning and exploring new methods
    of doing things, so I am sorry if this is not the best/right way
    of doing it.
 */

public class Speedrunner {
    private static Speedrunner instance;
    private Player speedrunner;

    private Speedrunner(Player speedrunner) {
        this.speedrunner = speedrunner;
    }

    public static Speedrunner getInstance() {
        if (instance == null) {
            instance = new Speedrunner(null);

            // Empty HunterList when altering speedrunner
            HunterList.reset();
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player != Speedrunner.instance.get()) {
                    HunterList.addHunter(player);
                }
            }
        }
        return instance;
    }

    public Player get() {
        return speedrunner;
    }

    public void set(Player player) {
        this.speedrunner = player;
    }
}
