package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invsee implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("spawn")){
			if(p.hasPermission("tessentials.spawn")){
				if(!(sender instanceof Player)){
					Util.sendMessage(p, "&cMusisz byc na serwerze");
					return false;
				}
				if(args.length == 0){
					Util.sendMessage(p, "&cUzycie:&a /invsee <nick>");
					return false;
				}else if (args.length == 1){
					Player pl = Bukkit.getPlayerExact(args[0]);
					if(!(pl == null)){
						p.openInventory(pl.getInventory());
						return false;
					}else{
						Util.sendMessage(p, "&cTen gracz nie jest online!");
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
