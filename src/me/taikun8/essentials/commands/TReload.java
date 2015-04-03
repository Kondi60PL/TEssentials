package me.taikun8.essentials.commands;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.LogUtil;
import me.taikun8.essentials.utils.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TReload implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("trelaod")){
			if(sender.hasPermission("tessentials.reload")){
				Util.sendMessage(sender, "&7Trwa przeladowywanie pluginu &cTEssentials v0.3 Alpha&7!");
				LogUtil.info("Trwa przeladowywanie pluginu TEssentials v0.3 Alpha!");
				Main.getInst().reloadConfig();
				Util.sendMessage(sender, "&7Pomyslnie przeladowano plugin &cTEssentials v0.3 Alpha&7!");
				LogUtil.info("Pomyslnie przeladowano plugin TEssentials v0.3 Alpha!");
			} else {
				Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy");
				return false;
			}
		}
		return false;
	}

}
