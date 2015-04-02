package me.taikun8.essentials.utils;

import java.util.ArrayList;
import java.util.List;

import me.taikun8.essentials.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerManager {

	public final static List<Player> onlinePlayers = new ArrayList<Player>();
	
	public static List<Player> getOnlinePlayers(){
		return onlinePlayers;
	}
	
	public static void addPlayer(Player p){
		onlinePlayers.add(p);
		if(!p.hasPlayedBefore()){
			if(Main.getInst().getConfig().getBoolean("") == true){
				Inventory pi = p.getInventory();
				pi.addItem(new ItemStack(Material.COOKED_BEEF, 64));
				pi.addItem(new ItemStack(Material.COOKED_BEEF, 64));
				pi.addItem(new ItemStack(Material.STONE_PICKAXE, 1));
				pi.addItem(new ItemStack(Material.ENDER_CHEST, 1));
			}
		}
	}
	
	public static void removePlayer(Player p){
		onlinePlayers.remove(p);
	}
}
