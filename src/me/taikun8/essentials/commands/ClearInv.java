package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearInv implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("ci")){
			if(p.hasPermission("tessentials.clearinv")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze!");
					return false;
				}
				if(args.length == 0){
					p.getInventory().clear();
					p.getInventory().setHelmet(null);
					p.getInventory().setChestplate(null);
					p.getInventory().setLeggings(null);
					p.getInventory().setBoots(null);
					p.setHealth(20.0);
					p.setFoodLevel(20);
					p.updateInventory();
					Util.sendMessage(p, "&7Pomyslnie wyczyszczono ekwipunek &c" + p.getName());
					return false;
				}else if (args.length == 1){
					Player p1 = Bukkit.getPlayerExact(args[0]);
					if(!(p1 == null)){
						p1.getInventory().clear();
						p1.getInventory().setHelmet(null);
						p1.getInventory().setChestplate(null);
						p1.getInventory().setLeggings(null);
						p1.getInventory().setBoots(null);
						p1.setHealth(20.0);
						p1.setFoodLevel(20);
						Util.sendMessage(p, "&7Pomyslnie wyczyszczono ekwipuneka &c" + p1.getName());
						return false;
					}
				}
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
			}
		}
		return false;
	}

}
