package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Whois implements CommandExecutor{

	public static String getOperator(Player p){
		if(p.isOp() || p.hasPermission("'*'")){
			return Util.setHEX("&aTak");
		}
		return Util.setHEX("&cNie");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("whois")){
			if(p.hasPermission("tessentials.whois")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze");
					return false;
				}
					if(args.length == 0){
						Util.sendMessage(p, "&7Informacje o graczu &c" + p.getName() + "&7:");
						Util.sendMessage(p, "&7  IP: &c" + p.getAddress().getHostString());
						Util.sendMessage(p, "&7  Admin: &c" + getOperator(p));
						Util.sendMessage(p, "&7  Gamemode: &c" + p.getGameMode().toString());
						Util.sendMessage(p, "&7  Jedzenie: &c" + p.getFoodLevel() + "/20");
						Util.sendMessage(p, "&7  Polozenie: &cx: " + p.getLocation().getBlockX()
						+ ", y: " + p.getLocation().getBlockY()
						+ ", z: " + p.getLocation().getBlockZ()
						+ ", world: " + p.getLocation().getWorld());
						return false;
					}else if (args.length == 1){
						Player p1 = Bukkit.getPlayerExact(args[0]);
						if(!(p1 == null)){
							Util.sendMessage(p, "&7Informacje o graczu &c" + p1.getName() + "&7:");
							Util.sendMessage(p, "&7  IP: &c" + p1.getAddress().getHostString());
							Util.sendMessage(p, "&7  Admin: &c" + getOperator(p1));
							Util.sendMessage(p, "&7  Gamemode: &c" + p1.getGameMode().toString());
							Util.sendMessage(p, "&7  Jedzenie: &c" + p1.getFoodLevel() + "/20");
							Util.sendMessage(p, "&7  Polozenie: &cx: " + p1.getLocation().getBlockX()
							+ ", y: " + p1.getLocation().getBlockY()
							+ ", z: " + p1.getLocation().getBlockZ()
							+ ", world: " + p1.getLocation().getWorld());
							return false;
						}else{
							Util.sendMessage(p, "&cTaki gracz nie jest online!");
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
