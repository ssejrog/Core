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

			getCommand("tp").setExecutor(new Commands());
			getCommand("gmc").setExecutor(new Commands());
			getCommand("gms").setExecutor(new Commands());
			getCommand("gma").setExecutor(new Commands());
			getCommand("gamemode").setExecutor(new Commands());
			getCommand("heal").setExecutor(new Commands());
			getCommand("feed").setExecutor(new Commands());
		}

		public void onDisable() {
			plugin = null;
			Bukkit.getServer().getLogger().info("Stopping Core...");
		}

		public static Plugin getPlugin() {
			return plugin;
		}
}