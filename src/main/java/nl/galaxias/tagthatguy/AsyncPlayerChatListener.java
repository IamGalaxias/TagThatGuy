package nl.galaxias.tagthatguy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Galaxias on 12-04-15 (17:51).
 * This file is part of TagThatGuy in the package nl.galaxias.tagthatguy.
 */
public class AsyncPlayerChatListener implements Listener {
    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        for (Player players : Bukkit.getServer().getOnlinePlayers()) {
            String name = players.getName();
            World world = player.getWorld();

            if(event.getMessage().contains(name)) {
                world.playSound(player.getLocation(), Sound.PORTAL_TRIGGER, 10, 1);

                event.getMessage().replaceAll(name, ChatColor.RED + "" + ChatColor.BOLD + name + ChatColor.RESET);
            }
        }
    }
}