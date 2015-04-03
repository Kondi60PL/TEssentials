package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("heal")){
			if(p.hasPermission("tessentials.heal")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze!");
					return false;
				}
				if(args.length == 0){
					p.setHealth(20.0);
					p.setFoodLevel(20);
					Util.sendMessage(p, "&7Pomyslnie uleczyles &c" + p.getName());
					return false;
					
				}else if (args.length == 1){
					Player p1 = Bukkit.getPlayerExact(args[0]);
					if(!(p1 == null)){
						p1.setHealth(20.0);
						p1.setFoodLevel(20);
						Util.sendMessage(p, "&7Pomyslnie uleczyles &c" + p1.getName());
						return false;
					}else{
						Util.sendMessage(p, "&cTaki gracz nie jest online!");
					}
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
			}
			}
		return false;
		}
	return false;
	}
}
