package com.earthpol.antiblockglitch.util;

import com.palmergames.bukkit.towny.Towny;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.HashSet;
import java.util.Set;

public class BlockUtil {

    private static Set<Player> pendingAntiGlitchTeleports = new HashSet<>();

    public static void applyBlockGlitchPrevention(Player player){
        if(!pendingAntiGlitchTeleports.contains(player)) {
            //Add player to the pending list
            pendingAntiGlitchTeleports.add(player);
            //Schedule the teleport
            Location targetLocation = player.getLocation();
            int delayTimeTicks = (int)(20d * 500 / 1000);
            Towny.getPlugin().getServer().getScheduler().runTaskLater(Towny.getPlugin(), () -> {
                //Note: We set the cause to "Unknown" so that SW's own teleport blocker won't stop it.
                player.teleport(targetLocation, PlayerTeleportEvent.TeleportCause.UNKNOWN);
                pendingAntiGlitchTeleports.remove(player);
            }, delayTimeTicks);
        }
    }


}
