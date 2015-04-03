package me.taikun8.essentials.commands;


import java.util.HashMap;

import me.taikun8.essentials.utils.Util;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message implements CommandExecutor{
	
	private static final HashMap<CommandSender, Player> lastPlayer = new HashMap<CommandSender, Player>();
	public static HashMap<CommandSender, Player> getLastPlayer()
	{
	    return lastPlayer;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("msg")){
			if(sender.hasPermission("tessentials.msg")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze");
					return false;
				}
			    if (args.length < 2) 
			    {
			        Util.sendMessage(p, "&cPrawidlowe uzycie: /msg <nick> <text>");
			        return false;
			    }
			    Player msgTo = Bukkit.getPlayerExact(args[0]);
			    if(msgTo == null)
			    {
			    	Util.sendMessage(p, "&cTen gracz jest aktualnie offline!");
			    	return false;
			    }
			    String message = ChatColor.stripColor(Util.setHEX(StringUtils.join(args, " ", 1, args.length)));
			    lastPlayer.put(p, msgTo);
			    lastPlayer.put(msgTo, p);
			    Util.sendMessage(p, "&7[&6Ja &8-> &6" + msgTo.getName() + "&7] &f" + message);
			    Util.sendMessage(msgTo, "&7[&6" + p.getName() + "&8-> &6Ja&7] &f" + message);
			    
			    
			    
				
			} else {
				Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}
