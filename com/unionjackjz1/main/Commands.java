package com.unionjackjz1.main;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor 
{
	String[] creative = { "creative", "c" };
	String[] survival = { "survival", "s" };
	String[] adventure = { "adventure", "a" };
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		}
		else if (cmd.getName().equalsIgnoreCase("tp")) {
			Player player = (Player)sender;
			for (int i = 0; i < args.length; i++) {
				args[i] = args[i].toLowerCase();
			}
			if ((player.hasPermission("core.tp")) && 
					(args.length == 0)) {
				player.sendMessage(ChatColor.WHITE + "Teleport to another player \nUssage: /tp <player> [otherplayer]");
			}
			if (args.length == 1){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				if (targetPlayer.isOnline()){
					Location targetPlayerLocation = targetPlayer.getLocation();
					player.teleport(targetPlayerLocation);
					Bukkit.broadcast(ChatColor.GOLD + player.getName() + ChatColor.GOLD + " has teleported to " + targetPlayer.getName(), "core.notify");
				}
				if (!targetPlayer.isOnline()){
					player.sendMessage(ChatColor.RED + "Player must be online!");
				}
				
			}
		}
		
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
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		}
		else if (cmd.getName().equalsIgnoreCase("heal")) {
			Player player = (Player)sender;
			for (int i = 0; i < args.length; i++) {
				args[i] = args[i].toLowerCase();
			}
			if ((player.hasPermission("core.heal")) && 
					(args.length == 0)) {
				player.setHealth(player.getMaxHealth());
				player.setFoodLevel(20);
				Bukkit.broadcast(ChatColor.GOLD + player.getName() + ChatColor.GOLD + " has been healed", "core.notify");	
			}
			if (args.length == 1){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target != null) { 
					target.setHealth(player.getMaxHealth());
					target.setFoodLevel(20);
					Bukkit.broadcast(ChatColor.GOLD + player.getName() + " has forcefully healed " + target.getName(), "core.notify");
				}
			}
		}
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		}
		else if (cmd.getName().equalsIgnoreCase("feed")) {
			Player player = (Player)sender;
			for (int i = 0; i < args.length; i++) {
				args[i] = args[i].toLowerCase();
			}
			if ((player.hasPermission("core.feed")) && 
					(args.length == 0)) {
				player.setFoodLevel(20);
				Bukkit.broadcast(ChatColor.GOLD + player.getName() + ChatColor.GOLD + " has been lifted of hunger", "core.notify");
			}
			if (args.length == 1){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target != null) { 
					target.setFoodLevel(20);
					Bukkit.broadcast(ChatColor.GOLD + player.getName() + " has forcefully fed " + target.getName(), "core.notify");
				}
			}
		}
		return true;
	}
}