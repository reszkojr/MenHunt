package me.santres.menhunt.entities;

import org.bukkit.entity.Player;

/*
    I still don't know if using a singleton for the speedrunner
    is the best method, I'm still learning and exploring new methods
    of doing things, so I am sorry if this is not the best/right way
    of doing it.
 */

public class Speedrunner {
    private static Speedrunner instance;
    private Player player;

    private Speedrunner(Player player) {
        this.player = player;
    }

    public static Speedrunner getInstance() {
        if (instance == null) {
            instance = new Speedrunner(null);
        }
        return instance;
    }

    public Player get() {
        return player;
    }

    public void set(Player player) {
        this.player = player;
    }
}
