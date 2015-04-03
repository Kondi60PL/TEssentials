package me.taikun8.essentials.commands;


import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor{	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		int spawnX = p.getLocation().getBlockX();
		int spawnY = p.getLocation().getBlockY();
		int spawnZ = p.getLocation().getBlockZ();
		World w = Bukkit.getWorld(Main.getInst().getConfig().getString("spawn-world"));
		
		if(cmd.getName().equalsIgnoreCase("setspawn")){
			if(p.hasPermission("tessentials.setspawn")){
				if(!(sender instanceof Player)){
					Util.sendMessage(p, "&cMusisz byc na serwerze");
					return false;
				}
				w.setSpawnLocation(spawnX, spawnY, spawnZ);
				Util.sendMessage(p, "&7Pomyslnie ustawiles miejsce SPAWNa");
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}
