package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Tppos implements CommandExecutor{
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tppos")){
			if(p.hasPermission("tessentials.tppos")){
				if(!(sender instanceof Player)){
					Util.sendMessage(p, "&cMusisz byc na serwerze");
					return false;
				}
				if ((args.length == 0) || (args.length == 2) || (args.length >= 5)){
					Util.sendMessage((Player)sender, "&cUzycie:&a /tppos [player] <x> <y> <z>");
					return false;
				}
			    if (args.length == 4) {
			        Player p1 = Bukkit.getPlayerExact(args[0]);
			        Player player = (Player)sender;
			        if (p == null) 
			        { 
			        	Util.sendMessage(player, "&cTaki gracz nie jest online!");
			            return false; 
			        } 
			        int x = 0;
			        int y = 0;
			        int z = 0;
			        if(Util.isInteger(args[1]) || Util.isInteger(args[2]) || Util.isInteger(args[3])){
			        	x = Integer.parseInt(args[1]);
			            y = Integer.parseInt(args[2]);
			            z = Integer.parseInt(args[3]);
			        }else{
			             Util.sendMessage(player, "&cKoordynaty musza byc liczba!");
			        }

			        Location loc = p.getLocation();
			        loc.setX(x + 0.5D);
			        loc.setY(y + 0.3D);
			        loc.setZ(z + 0.5D);

			        p.teleport(loc, PlayerTeleportEvent.TeleportCause.COMMAND);
			        Util.sendMessage(player, "&7Gracz &c" + p.getName() + "&7 zostal przeteleportowany!");
			        return false;
			    }if (args.length == 3) {

			        int x = 0; 
			        int y = 0; 
			        int z = 0;
			        if(Util.isInteger(args[0]) || Util.isInteger(args[1]) || Util.isInteger(args[2])){
			        	x = Integer.parseInt(args[0]);
			            y = Integer.parseInt(args[1]);
			            z = Integer.parseInt(args[2]);
			        }else{
			             Util.sendMessage(p, "&cKoordynaty musza byc liczba!");
			        }

			        Location loc = p.getLocation();
			        loc.setX(x + 0.5D);
			        loc.setY(y + 0.3D);
			        loc.setZ(z + 0.5D);

			        p.teleport(loc, PlayerTeleportEvent.TeleportCause.COMMAND);
			        Util.sendMessage(p, "&7Teleportacja...");
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
