package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("broadcast")){
			if(p.hasPermission("tessentials.broadcast")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "§cMusisz byc na serwerze!");
					return false;
				}
				if(args.length == 1){
					Util.sendMessage(p, "§cUzycie: §a/broadcast <tekst>");
					return false;
				}
				    StringBuilder mb = new StringBuilder();
				    for (String a : args) {
				        if (mb.length() > 0) {
				            mb.append(" ");
				        }
				        mb.append(a);
				    }
				    Bukkit.broadcastMessage(Util.setHEX("&8[&4Ogloszenie&8]&a" + mb.toString()));
			}
		}
		return false;
	}

}
