package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.EnchantUtil;
import me.taikun8.essentials.utils.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Enchant implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("enchant")){
			if(p.hasPermission("tessentials.enchant")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze!");
					return false;
				}
				if(args.length == 1 || (args.length == 2)){
					ItemStack item = p.getItemInHand();
				    String enchantName = args[0];
				    Enchantment enchant = EnchantUtil.get(enchantName);
				    if (enchant == null) {
				        Util.sendMessage(p, "&cTakie zaklecie nie istnieje!");
				        return false;
				    }
				    int level = enchant.getMaxLevel();
				    if (args.length == 2) {
				    	if(Util.isInteger(args[1])){
				    		level = Integer.parseInt(args[1]);
				    	}else{
				    		Util.sendMessage(p, "&cPoziom musi byc liczba!");
				    		return false;
				    	}
				    }
				    item.addUnsafeEnchantment(enchant, level);
				    Util.sendMessage(p, "&7Nalozono enchant &c" + enchant.getName().toLowerCase().replace("_", " ") + " (" + level + ")" + " &7na przedmiot w Twojej rece!");
				} else {
					Util.sendMessage(p, "&cUzycie:&a /enchant <zaklecie>");
					return false;
				}
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
			}
		}
		return false;
	}

}
