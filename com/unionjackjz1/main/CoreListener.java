package com.unionjackjz1.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class CoreListener implements Listener 
{
	@EventHandler(priority=EventPriority.NORMAL)
	public void PlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		if ((player.hasPermission("core.joinnotify"))) {
			if (player.isOnline()) {
				Bukkit.broadcastMessage(ChatColor.DARK_GREEN + player.getName() + ChatColor.GREEN + " has joined the server!");
			}
		}
	}
}