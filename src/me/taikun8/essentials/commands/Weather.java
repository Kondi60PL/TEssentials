package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		World w = Bukkit.getWorld(p.getWorld().getName());
		if(cmd.getName().equalsIgnoreCase("weather")){
			if(p.hasPermission("tessentials.weather")){
				if(!(sender instanceof Player)){
					Util.sendMessage(p, "&cMusisz byc na serwerze");
					return false;
				}
				if(args.length == 0){
					Util.sendMessage(p, "&cUzycie:&a /weather <sun/thunder>");
					return false;
				}else if (args.length == 1){
					if(args[0].equalsIgnoreCase("sun")){
						w.setStorm(false);
						Util.sendMessage(p, "&7Ustawiono pogode swiata na &csun");
						return false;
					}else if (args[0].equalsIgnoreCase("thunder")){
						w.setStorm(true);
						Util.sendMessage(p, "&7Ustawiono pogode swiata na &cthunder");
						return false;
					}
				}
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}
