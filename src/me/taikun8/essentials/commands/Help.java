package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.HelpUtil;
import me.taikun8.essentials.utils.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("help")){
			if(!(sender instanceof Player)){
				Util.sendMessage(sender, "&cMusisz byc na serwerze");
				return false;
			}
			if(args.length == 0){
				HelpUtil.sendHelp(1, p);
			}else if (args.length == 1)
			{
				if(Util.isInteger(args[0])){
					if(args[0].equalsIgnoreCase("1"))
					{
						HelpUtil.sendHelp(1, p);
						return false;
					}
					if(args[0].equalsIgnoreCase("2"))
					{
						HelpUtil.sendHelp(2, p);
						return false;
					}
					if(args[0].equalsIgnoreCase("3"))
					{
						HelpUtil.sendHelp(3, p);
						return false;
					}
					else if ((!args[0].equalsIgnoreCase("1")) || (!args[0].equalsIgnoreCase("2") || (!args[0].equalsIgnoreCase("3"))))
					{
						Util.sendMessage(p, "&cNie znaleziono strony o numerze &7" + args[0].toString() + "&c!");
						return false;
					}
				}else{
					Util.sendMessage(p, "&cStrona musi byc liczba!");
				}
			}
		}
		return false;
	}

}
