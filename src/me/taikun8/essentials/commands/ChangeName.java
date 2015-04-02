package me.taikun8.essentials.commands;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.Util;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChangeName implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("changename")){
			if(p.hasPermission("tessentials.changename")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze!");
					return false;
				}
				if(args.length == 0){
					Util.sendMessage(p, "&cUzycie:&a /changename <tekst>");
					return false;
				}
				if(p.getInventory().getItemInHand().getType() == Material.AIR){
					Util.sendMessage(p, "&cMusisz trzymac przedmiot aby zmienic mu nazwe!");
					return false;
				} else {
					StringBuilder mb = new StringBuilder();
					for(String a : args){
						if(mb.length() > 0){
							mb.append(" ");
						}
						mb.append(a);
					}
					ItemStack item = p.getInventory().getItemInHand();
					ItemMeta meta = item.getItemMeta();
						if (mb.toString().equalsIgnoreCase(Main.getInst().getConfig().getString("changeitem-remove"))){
							meta.setDisplayName(null);
						}else{
							meta.setDisplayName(Util.setHEX(mb.toString()));
						}
						item.setItemMeta(meta);
						Util.sendMessage(p, "&7Poprawnie zmieniono nazwe na: &c" + Util.setHEX(mb.toString().replace(Main.getInst().getConfig().getString("changeitem-remove"), "&cwyczyszczono nazwe!")));
					}
			}
		}
		return false;
	}
	
	

}
