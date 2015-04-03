package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("gamemode")){
			if(p.hasPermission("tessentials.gamemdoe")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze!");
					return false;
				}
				if (args.length == 0) {
					Util.sendMessage(p, "&cUzycie:&a /gm <tryb>");
					return false;
				}
				try {
					int mode = Integer.parseInt(args[0]);
					@SuppressWarnings("deprecation")
					GameMode gm = GameMode.getByValue(mode);
					if (gm == null) {
						Util.sendMessage(p, "&cNie znaleziono takiego trybu!");
						return false;
					}
					p.setGameMode(gm);
					Util.sendMessage(p, "&7Tryb gry zostal zmieniony!");
					return false;
				}
				catch (NumberFormatException e) {
					GameMode gm = GameMode.valueOf(args[0].toUpperCase());
					if (gm == null) {
						Util.sendMessage(p, "&cNie znaleziono takiego trybu!");
						return false;
					}
					p.setGameMode(gm);
					Util.sendMessage(p, "&7Tryb gry zostal zmieniony!");
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
