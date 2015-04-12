package nl.galaxias.tagthatguy;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Galaxias on 12-04-15 (17:50).
 * This file is part of TagThatGuy in the package nl.galaxias.tagthatguy.
 */
public class TagThatGuy extends JavaPlugin {
    private static Plugin plugin;

    public void onEnable() {
        plugin = this;

        registerEvents(this, new AsyncPlayerChatListener());
    }

    public void onDisable() {
        plugin = null;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}