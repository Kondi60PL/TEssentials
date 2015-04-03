package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reply implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("reply")){
			if(p.hasPermission("tessentials.reply")){
				if(!(sender instanceof Player)){
					Util.sendMessage(p, "&cMusisz byc na serwerze");
					return false;
				}
			    if (args.length < 1) 
			    {
			        Util.sendMessage(p, "&cUzycie:&a /reply <text>");
			        return false;
			    }
			    Player msgLast = Message.getLastPlayer().get(p);
			    if (msgLast == null)
			    {
			    	Util.sendMessage(p, "&cNie masz komu odpisac!");
			    	return false;
			    }
			    Player lastPlayer = Bukkit.getPlayerExact(msgLast.getName());
			    if (lastPlayer == null)
			    {
			    	Util.sendMessage(p, "&cGracz nie jest online!");
			    	return false;
			    }
			    StringBuilder message = new StringBuilder();
			    for (String a : args) {
			        if (message.length() > 0) {
			            message.append(" ");
			        }
			        message.append(a);
			    }
			    Message.getLastPlayer().put(p, lastPlayer);
			    Message.getLastPlayer().put(lastPlayer, p);
			    Util.sendMessage(p, "&7[&6Ja &8-> &6" + lastPlayer.getName() + "&7] &f" + message);
			    Util.sendMessage(lastPlayer, "&7[&6" + p.getName() + "&8-> &6Ja&7] &f" + message);
				
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}
