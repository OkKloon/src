package me.badcoder.events;

import me.badcoder.fastgensbadcoder.FastGensBadcoder;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.cacheddata.CachedMetaData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Arrays;

public class JoinLeave implements Listener
{
    private final FastGensBadcoder plugin;
    private final LuckPerms luckPerms;
    public JoinLeave(FastGensBadcoder plugin, LuckPerms luckPerms){
this.plugin = plugin;
this.luckPerms = luckPerms;
    }
    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        CachedMetaData metaData = this.luckPerms.getPlayerAdapter(Player.class).getMetaData(player);
        // Get their suffix
        String suffix = metaData.getSuffix();

        if (suffix == null) {
            e.setJoinMessage("§7[§a+§7]" + " §7" + player.getDisplayName());
        }
else if (player.hasPlayedBefore() && suffix != null ) {
            String suffixSimplified = ChatColor.translateAlternateColorCodes('&', suffix);
            String join = "§f[§a+§f]" + " §f" + player.getDisplayName() + "" + suffixSimplified;
            e.setJoinMessage(join);
        } else {
            int count = (int) Arrays.stream(Bukkit.getOfflinePlayers()).count();
            String firstJoin = "§b§lFast§3§lGens §8: §b " + player.getDisplayName() +
                    " §fjoined the server for the first time!§3 #" + count;
            e.setJoinMessage(firstJoin);
        }
    }
    @EventHandler
     void onPlayerLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        CachedMetaData metaData = this.luckPerms.getPlayerAdapter(Player.class).getMetaData(player);
        // Get their suffix
        String suffix = metaData.getSuffix();
      // prefix

        if (suffix==null) {
            e.setQuitMessage("§7[§c-§7]" + " §7" + player.getDisplayName());
        } else {
            String suffixSimplified = ChatColor.translateAlternateColorCodes('&', suffix);

        //send leave msg
        String leave = "§f[§c-§f]"  +  player.getDisplayName() + "" + suffixSimplified;
                e.setQuitMessage(leave);
    }
    }
}