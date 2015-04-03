package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tp")){
			if(p.hasPermission("tessentials.tp")){
				if(!(sender instanceof Player)){
					Util.sendMessage(p, "&cMusisz byc na serwerze");
					return false;
				}
				if(args.length == 0 || (args.length > 2)){
					Util.sendMessage(p, "&cUzycie:&a /tp <nick/all> <nick2>");
					return false;
				}
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("all")){
						if(p.hasPermission("qessentials.teleport.all")){
							for (Player online : Bukkit.getOnlinePlayers()){
								online.teleport(p.getLocation());
								Util.sendMessage(online, "&7Zostales przeteleportowany do &c" + p.getName());
							}
							Util.sendMessage(p, "&7Przeteleportowales wszystkich graczy do siebie!");
							return false;
						}else{
							Util.sendMessage(p, "&cNie masz uprawnien do wykonania tej czynnosci! &7(qessentials.teleport.all)");
							return false;
						}
					}else{
						Player tpTo = Bukkit.getPlayerExact(args[0]);
						if(!(tpTo == null)){
							p.teleport(tpTo);
							Util.sendMessage(p, "&7Zostales przeteleportowany do &c" + tpTo.getName());
						}else{
							Util.sendMessage(p, "&cTaki gracz nie jest online!");
						}
					}
				}
				if(args.length == 2){
					Player tpFrom = Bukkit.getPlayerExact(args[0]);
					Player tpTo = Bukkit.getPlayerExact(args[1]);
					if (!(tpFrom == null) || !(tpTo == null)){
						tpFrom.teleport(tpTo.getLocation());
						Util.sendMessage(tpFrom, "&7Zostales przeteleportowany do &c" + tpTo.getName());
						Util.sendMessage(p, "&7Gracz &c" + tpFrom.getName() + " &7zostal przeteleportowany do &c" + tpTo.getName());
					}else{
						Util.sendMessage(p, "&cKtorys gracz nie jest online!");
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
