package com.unionjackjz1.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Plugin plugin;

	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {

		for (Listener listener : listeners) {

			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}
		public void onEnable() {
			plugin = this;

			registerEvents(this, new CoreListener());

			Bukkit.getServer().getLogger().info("Loading Core...");
			Bukkit.getServer().getLogger().info("Core successfully loaded.");

			getCommand("tp").setExecutor(new Teleport());
			
			getCommand("gmc").setExecutor(new Gamemode());
			getCommand("gms").setExecutor(new Gamemode());
			getCommand("gma").setExecutor(new Gamemode());
			getCommand("gamemode").setExecutor(new Gamemode());
			
			getCommand("heal").setExecutor(new Teleport());
			getCommand("feed").setExecutor(new Teleport());
		}

		public void onDisable() {
			plugin = null;
			Bukkit.getServer().getLogger().info("Stopping Core...");
		}

		public static Plugin getPlugin() {
			return plugin;
		}
}