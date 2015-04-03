package me.taikun8.essentials.commands;

import java.util.ArrayList;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.Util;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChangeLore implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("changelore")){
			if(p.hasPermission("tessentials.changelore")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "§cMusisz byc na serwerze!");
					return false;
				}
				if(args.length == 0){
					Util.sendMessage(p, "&cUzycie:&a /changelore <tekst>");
					return false;
				}
				if(p.getInventory().getItemInHand().getType() == Material.AIR){
					Util.sendMessage(p, "&cMusisz trzymac przedmiot aby dodac mu opis!");
					return false;
			   } else {
				   StringBuilder mb = new StringBuilder();
				   for (String a : args) {
					   if (mb.length() > 0) {
						   mb.append(" ");
						   }
				        mb.append(a);
				   }
				    ItemStack item = p.getInventory().getItemInHand();
				    ItemMeta meta = item.getItemMeta();
				    ArrayList<String> lore = new ArrayList<String>();
				    if (mb.toString().equalsIgnoreCase(Main.getInst().getConfig().getString("changeitem-remove"))){
				    	meta.setLore(null);
				    }else{
				    	lore.add(Util.setHEX(mb.toString()));
				    	meta.setLore(lore);
				    }
				    item.setItemMeta(meta);
				    Util.sendMessage(p, "&7Poprawnie ustawiono opis: &c" + Util.setHEX(mb.toString().replace(Main.getInst().getConfig().getString("changeitem-remove"), "&cwyczyszczono opis!")));
				}
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
			}
		}
		return false;
	}

}
