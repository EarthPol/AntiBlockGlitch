package com.earthpol.antiblockglitch;

import com.earthpol.antiblockglitch.events.TownyEventListener;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private static Main instance;
    private static Logger log = Bukkit.getLogger();
    public static final String PREFIX = ChatColor.of("#3fb78d").toString() + ChatColor.BOLD + "E" + ChatColor.of("#57c28a").toString() + ChatColor.BOLD + "a" + ChatColor.of("#6fcd85").toString() + ChatColor.BOLD + "r" + ChatColor.of("#88d880").toString() + ChatColor.BOLD + "t" + ChatColor.of("#a3e27a").toString() + ChatColor.BOLD + "h" + ChatColor.of("#beeb75").toString() + ChatColor.BOLD + "P" + ChatColor.of("#dcf371").toString() + ChatColor.BOLD + "o" + ChatColor.of("#fafa6e").toString() + ChatColor.BOLD + "l" + ChatColor.WHITE + " • " + ChatColor.RESET + "§6";
    public static final String DISCORD = "https://discord.gg/earthpol";
    public static Main getInstance(){ return instance; }

    @Override
    public void onEnable() {
        instance = this;
        log.info(PREFIX + "=====[ AntiBlockGlitch] =====");
        log.info(PREFIX + "Discord: " + DISCORD);
        setupListeners();
        log.info(PREFIX + "AntiBlockGlitch has been enabled.");
    }

    private void setupListeners(){
        getServer().getPluginManager().registerEvents(new TownyEventListener(), instance);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
