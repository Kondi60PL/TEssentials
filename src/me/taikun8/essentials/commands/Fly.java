package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("fly")){
			if(p.hasPermission("tessentials.fly")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze!");
					return false;
				}
				if(args.length == 1){
					
					if(args[0].equalsIgnoreCase("on")){
						p.setAllowFlight(true);
						p.setFlying(true);
						Util.sendMessage(p, "&7Pomyslnie &cwlaczyles &7latanie.");
						return false;
					} else if(args[0].equalsIgnoreCase("off")){
						p.setAllowFlight(false);
						p.setFlying(false);
						Util.sendMessage(p, "&7Pomyslnie &cwylaczyles &7latanie.");
						return false;
					}
				} else if(args.length == 2){
					Player p1 = Bukkit.getPlayerExact(args[1]);
					if(p1 == null){
						Util.sendMessage(p, "&cNie ma takiego gracza na serwerza!");
						return false;
					}
					if(args[0].equalsIgnoreCase("on")){
						p1.setAllowFlight(true);
						p1.setFlying(true);
						Util.sendMessage(p, "&7Pomyslnie &cwlaczyles &7latanie &c" + p1.getName());
						return false;
					}else if (args[0].equalsIgnoreCase("off")){
						p1.setAllowFlight(false);
						p1.setFlying(false);
						Util.sendMessage(p, "&7Pomyslnie &cwylaczyles &7latanie &c" + p1.getName());
						return false;
					}
				} else {
					Util.sendMessage(p, "&cUzycie:&a /fly <on/off> <nick>");
					return false;
				}
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}
