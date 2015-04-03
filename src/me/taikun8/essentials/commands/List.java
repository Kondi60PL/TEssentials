package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class List implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("list")){
			if(sender.hasPermission("tessentials.list")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze");
					return false;
				}
				Player[] plrs = Bukkit.getOnlinePlayers();
				String s = "";
				for(int i = 0; i < plrs.length; i++){
					s += ChatColor.AQUA + ", " + ChatColor.GRAY + plrs[i].getName();
				}
				Util.sendMessage(sender, "&7Aktualnie online:\n" + s.replaceFirst(", ", " "));
			} else {
				Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}
