package com.unionjackjz1.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor 
{
	
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