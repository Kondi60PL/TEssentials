package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.BackUtil;
import me.taikun8.essentials.utils.TimeUtil;
import me.taikun8.essentials.utils.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Back implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("back")){
			if(p.hasPermission("tessentials.back")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze");
					return false;
				}
				if(BackUtil.getLastLocation(p) == null){
					Util.sendMessage(p, "&7Powrot nie moze byc zrealizowany z powodu braku ostatniej lokalizacji!");
					return false;
				}
				TimeUtil.teleportDelay(p, BackUtil.getLastLocation(p));
				Util.sendMessage(p, "&7Teleportacja...");
				return false;
				
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}