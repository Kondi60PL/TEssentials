package me.taikun8.essentials.commands;

import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Head implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("head")){
			if(p.hasPermission("tessentials.head")){
				if(!(sender instanceof Player)){
					Util.sendMessage(sender, "&cMusisz byc na serwerze!");
					return false;
				}
				if(args.length == 0){
					Util.sendMessage(p, "&cUzycie:&a /head <nick>");
					return false;
				}
				Player p1 = Bukkit.getPlayer(args[0]);
				ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
				SkullMeta sm = (SkullMeta) head.getItemMeta();
				sm.setDisplayName(Util.setHEX("&7Glowa gracza &c" + p1.getName()));
				sm.addEnchant(Enchantment.DURABILITY, 10, true);
				sm.setOwner(p1.getName());
				head.setItemMeta(sm);
				p.getInventory().addItem(head);
				Util.sendMessage(p, "&7Otrzymales glowe gracza &c" + p1.getName());
				return false;
			} else {
				Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy");
			}
		}
		return false;
	}

}
