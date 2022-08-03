package com.earthpol.antiblockglitch.events;

import com.earthpol.antiblockglitch.util.BlockUtil;
import com.palmergames.bukkit.towny.event.actions.TownyBuildEvent;
import com.palmergames.bukkit.towny.event.actions.TownyDestroyEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownyEventListener implements Listener {

    @EventHandler
    public void on (TownyDestroyEvent event){
        if(event.isCancelled()){
            BlockUtil.applyBlockGlitchPrevention(event.getPlayer());
        }
    }

    @EventHandler
    public void on (TownyBuildEvent event) {
        if (event.isCancelled()) {
            BlockUtil.applyBlockGlitchPrevention(event.getPlayer());
        }
    }
}
