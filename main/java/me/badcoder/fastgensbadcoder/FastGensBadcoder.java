package me.badcoder.fastgensbadcoder;

import me.badcoder.events.JoinLeave;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class FastGensBadcoder extends JavaPlugin {


    private LuckPerms luckPerms;
    @Override
    public void onEnable(){
        this.luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        Bukkit.getLogger().info("Badcoder's part of FastGens is starting up!");
        getServer().getPluginManager().registerEvents(new JoinLeave(this, this.luckPerms), this);
        Bukkit.getLogger().info("Badcoder's part of FastGens has started up!");
    }

    @Override
    public void onDisable(){
        // Plugin shutdown logic
        Bukkit.getLogger().info("Badcoder's part of FastGens is shutting down! See you next time!");
    }
    public static boolean isPlayerInGroup(Player player, String group) {
        return player.hasPermission("group." + group);
    }
    }