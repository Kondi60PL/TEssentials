package me.taikun8.essentials.commands;

import java.util.Map;
import java.util.WeakHashMap;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Helpop implements CommandExecutor{

	private Map<CommandSender, Long> time = new WeakHashMap<CommandSender, Long>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("helpop")){
			if(p.hasPermission("tessentials.helpop")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze");
					return false;
				}
			    Long t = (Long)this.time.get(sender);
			    long delay = Main.getInst().getConfig().getLong("helpop-delay");
			    if ((t != null) && (System.currentTimeMillis() - t.longValue() < delay * 1000)) {
			    	Util.sendMessage((Player)sender, "&7Musisz poczekac &c"+delay+"s &7aby ponownie wyslac helpop!".replace("L", "s"));
			        return false;
			    }
			    if (args.length == 0) {
			    	Util.sendMessage((Player)sender, "&cPoprawne uzycie: /helpop <tekst>");
			        return false;
			    }
			    this.time.put(sender, Long.valueOf(System.currentTimeMillis()));
			    StringBuilder mb = new StringBuilder();
			    for (String a : args) {
			        if (mb.length() > 0) {
			            mb.append(" ");
			        }
			        mb.append(a);
			    }
			    String msg = Main.getInst().getConfig().getString("helpop-format").replace("{MESSAGE}", mb.toString()).replace("{PLAYER}", sender.getName());
			    Bukkit.getConsoleSender().sendMessage(Util.setHEX(msg));
			    if(p.isOp()){
			    	if(p.isOnline()){
				        if (p.hasPermission("tessentials.helpop.see")){
				          p.sendMessage(Util.setHEX(msg));
				        }
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
