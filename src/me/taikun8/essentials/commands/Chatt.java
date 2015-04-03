package me.taikun8.essentials.commands;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.ChatUtil;
import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Chatt implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("chat")){
			if(p.hasPermission("tessentials.chat")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze!");
					return false;
				}
				if((args.length == 0) || (args.length >= 2)){
					Util.sendMessage(p, "&cUzycie:&a /chat <cc/on/off>");
					return false;
				} else {
					if(args.length == 1){
						if(args[0].equalsIgnoreCase("on")){
							if(ChatUtil.getChat() == false){
								ChatUtil.setChat("on");
								Bukkit.broadcastMessage(Main.getInst().getConfig().getString("chat-on").replace("{PLAYER}", p.getName()));
							}
						}
						if(args[0].equalsIgnoreCase("off")){
							if(ChatUtil.getChat() == true){
								ChatUtil.setChat("off");
								Bukkit.broadcastMessage(Main.getInst().getConfig().getString("chat-off").replace("{PLAYER}", p.getName()));
							}
						}
						if(args[0].equalsIgnoreCase("cc")){
							ChatUtil.clearChat();
							Bukkit.broadcastMessage(Main.getInst().getConfig().getString("chat-clear").replace("{PLAYER}", p.getName()));
							return false;
						}else{
							Util.sendMessage(p, "&cUzycie:&a /chat <cc/on/off>");
							return false;
						}
					}
				}
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
			}
		}
		return false;
	}

}
