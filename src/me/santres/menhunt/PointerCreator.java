package me.santres.menhunt;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class PointerCreator {

    private Location hunter;
    private Location target;

    public PointerCreator(Location hunter, Location target) {
        this.hunter = hunter;
        this.target = target;
    }

    private double getAngle() {
        Vector hunterVec = hunter.toVector();
        Vector targetVec = target.toVector();

        Vector trajectory = targetVec.clone().subtract(hunterVec).normalize();

        double yaw = Math.toDegrees(Math.atan(-trajectory.getX() / trajectory.getZ()));

        if (trajectory.getZ() < 0) {
            yaw += 180;
        }

        double angle = yaw - hunter.getYaw();

        if (angle > 180) {
            angle -= 360;
        }
        return angle;
    }

    private ChatColor colorDistance(int distance) {
        ChatColor color;

        if (distance > 40000) {
            color = ChatColor.AQUA;
        } else if (distance > 10000) {
            color = ChatColor.DARK_AQUA;
        } else if (distance > 2500) {
            color = ChatColor.GOLD;
        } else if (distance > 400) {
            color = ChatColor.RED;
        } else {
            color = ChatColor.DARK_RED;
        }

        return color;
    }

    public String create() {
        double angle = getAngle();

        int MAX_CHARS = 81;
        int drawnChars = 0;

        final StringBuilder stringBuilder = new StringBuilder(MAX_CHARS);
        stringBuilder.append(ChatColor.BOLD);

        if (angle > 90) {
            while (stringBuilder.length() < MAX_CHARS - 1) stringBuilder.append(' ');
            stringBuilder.append('>');
            drawnChars = MAX_CHARS + 1;
        } else if (angle < -90) {
            stringBuilder.append('<');
            while (stringBuilder.length() < MAX_CHARS - 1) stringBuilder.append(' ');
            drawnChars = MAX_CHARS + 1;
        } else {
            for (double percent = (angle + 90.0) / 180.0; percent >= drawnChars / (double) MAX_CHARS; drawnChars++) {
                stringBuilder.append(' ');
            }
            stringBuilder.append('X');
            drawnChars++;
        }
        while (drawnChars <= MAX_CHARS) {
            stringBuilder.append(' ');
            drawnChars++;
        }
        String text = stringBuilder.toString();

        int distance = (int) hunter.distanceSquared(target);

        return colorDistance(distance) + text;
    }

    public void setHunter() {
        this.hunter = hunter;
    }

    public void setTarget() {
        this.target = target;
    }
}
