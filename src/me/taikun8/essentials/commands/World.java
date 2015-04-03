package me.taikun8.essentials.commands;

import java.util.List;

import me.taikun8.essentials.utils.TimeUtil;
import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class World implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("world")){
			if(p.hasPermission("tessentials.world")){
				if(!(sender instanceof Player)){
					Util.sendMessage(p, "&cMusisz byc na serwerze");
					return false;
				}
				if((args.length == 0) || args.length >=2){
					Util.sendMessage(p, "&cUzynie:&a /world <swiat>");
					Util.sendMessage(p, "&cDostepne swiaty:");
					List<org.bukkit.World> ws = Bukkit.getWorlds();
					for(org.bukkit.World w : ws){
						Util.sendMessage(p, "&c   '" + w.getName() + "'");
					}
					return false;
				}
				org.bukkit.World w = Bukkit.getWorld(args[0]);
				if(w == null){
					Util.sendMessage(p, "&cTaki swiat nie istnieje");
					return false;
				} else {
					TimeUtil.teleportDelay(p, w.getSpawnLocation());
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
