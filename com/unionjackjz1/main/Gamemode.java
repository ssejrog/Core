package com.unionjackjz1.main;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor 
{
	String[] creative = { "creative", "c" };
	String[] survival = { "survival", "s" };
	String[] adventure = { "adventure", "a" };
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		}
		else if (cmd.getName().equalsIgnoreCase("gmc")) {
			Player player = (Player)sender;
			for (int i = 0; i < args.length; i++) {
				args[i] = args[i].toLowerCase();
			}
			if ((player.hasPermission("core.gamemode")) && 
					(args.length == 0)) {
				//player.sendMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.AQUA + " gamemode has been set to " + ChatColor.DARK_AQUA + "Creative");
				Bukkit.broadcast(ChatColor.GOLD + player.getName() + ChatColor.GOLD + " gamemode has been set to " + ChatColor.GOLD + "Creative", "core.notify");
				player.setGameMode(GameMode.CREATIVE);

			}
		}
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		}
		else if (cmd.getName().equalsIgnoreCase("gms")) {
			Player player = (Player)sender;
			for (int i = 0; i < args.length; i++) {
				args[i] = args[i].toLowerCase();
			}
			if ((player.hasPermission("core.gamemode")) && 
					(args.length == 0)) {
				//player.sendMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.AQUA + " gamemode has been set to " + ChatColor.DARK_AQUA + "Survival");
				Bukkit.broadcast(ChatColor.GOLD + player.getName() + ChatColor.GOLD + " gamemode has been set to " + ChatColor.GOLD + "Survival", "core.notify");
				player.setGameMode(GameMode.SURVIVAL);

			}
		}
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		}
		else if (cmd.getName().equalsIgnoreCase("gma")) {
			Player player = (Player)sender;
			for (int i = 0; i < args.length; i++) {
				args[i] = args[i].toLowerCase();
			}
			if ((player.hasPermission("core.gamemode")) && 
					(args.length == 0)) {
				//player.sendMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.AQUA + " gamemode has been set to " + ChatColor.DARK_AQUA + "Adventure");
				Bukkit.broadcast(ChatColor.GOLD + player.getName() + ChatColor.GOLD + " gamemode has been set to " + ChatColor.GOLD + "Adventure", "core.notify");
				player.setGameMode(GameMode.ADVENTURE);

			}
		}

		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		} else if (cmd.getName().equalsIgnoreCase("gamemode")) {
			Player player = (Player)sender;
			for (int i = 0; i < args.length; i++) {
				args[i] = args[i].toLowerCase();
			}
			if (player.hasPermission("core.gamemode")) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.WHITE + "Please specifiy a mode \nSurvival [s], Creative [c], Adventure [a]");
				}
				if (Arrays.asList(this.creative).contains(args[0].toLowerCase())) {
					//player.sendMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.AQUA + " gamemode has been set to " + ChatColor.DARK_AQUA + "Creative");
					Bukkit.broadcast(ChatColor.GOLD + player.getName() + ChatColor.GOLD + " gamemode has been set to " + ChatColor.GOLD + "Creative", "core.notify");
					player.setGameMode(GameMode.CREATIVE);
				}
				else if (Arrays.asList(this.survival).contains(args[0].toLowerCase())) {
					//player.sendMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.AQUA + " gamemode has been set to " + ChatColor.DARK_AQUA + "Survival");
					Bukkit.broadcast(ChatColor.GOLD + player.getName() + ChatColor.GOLD + " gamemode has been set to " + ChatColor.GOLD + "Survival", "core.notify");
					player.setGameMode(GameMode.SURVIVAL);
				}
				}
				else if (Arrays.asList(this.adventure).contains(args[0].toLowerCase())) {
					//player.sendMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.AQUA + " gamemode has been set to " + ChatColor.DARK_AQUA + "Adventure");
					Bukkit.broadcast(ChatColor.GOLD + player.getName() + ChatColor.GOLD + " gamemode has been set to " + ChatColor.GOLD + "Adventure", "core.notify");
					player.setGameMode(GameMode.ADVENTURE);
				}
			}	
		return true;
	}
}