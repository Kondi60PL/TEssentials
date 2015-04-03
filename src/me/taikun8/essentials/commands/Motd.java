package me.taikun8.essentials.commands;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Motd implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("motd")){
			if(p.hasPermission("tessentials.motd")){
				if(!(sender instanceof Player)){
					Util.sendMessage(p, "&cMusisz byc na serwerze");
					return false;
				}
				if (args.length > 0) {
					StringBuilder sb = new StringBuilder();
					
					for (String arg : args) {
						sb.append(arg).append(" ");
					}
					String motd = sb.toString()
							.replace("/n", "{n}")
							.replace("§", "&");
					Main.getInst().getConfig().set("server-motd", motd);
					Main.getInst().saveConfig();
					Util.sendMessage(p, "&7Nowe MOTD: &c" + motd);
					return false;
				} else {
					Util.sendMessage(p, "&cUzycie:&a /motd <tekst>");
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
