package me.taikun8.essentials.commands;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.TimeUtil;
import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("spawn")){
			if(p.hasPermission("tessentials.spawn")){
				if(!(sender instanceof Player)){
					Util.sendMessage(p, "&cMusisz byc na serwerze");
					return false;
				}
				World w = Bukkit.getWorld(Main.getInst().getConfig().getString("spawn-world"));
				TimeUtil.teleportDelay(p, w.getSpawnLocation());
				
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}
