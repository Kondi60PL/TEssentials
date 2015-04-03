package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		World w = Bukkit.getWorld(p.getWorld().getName());
		if(cmd.getName().equalsIgnoreCase("time")){
			if(sender.hasPermission("tessentials.time")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze");
					return false;
				}
				if(args.length == 0){
					Util.sendMessage(sender, "&cUzycie:&a /time <day/night>");
					return false;
				} else if(args.length == 1){
					if(args[0].equalsIgnoreCase("day")){
						w.setTime(2500L);
						Util.sendMessage(p, "&7Ustawiono czas na &cday");
						return false;
					}else if (args[0].equalsIgnoreCase("night")){
						w.setTime(14500L);
						Util.sendMessage(p, "&7Ustawiono czas na &cnight");
						return false;
					}
				}
			} else {
				Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}
