package me.taikun8.essentials.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class PlayerManager {

	public final static List<Player> onlinePlayers = new ArrayList<Player>();
	
	public static List<Player> getOnlinePlayers(){
		return onlinePlayers;
	}
	
	public static void addPlayer(Player p){
		onlinePlayers.add(p);
	}
	
	public static void removePlayer(Player p){
		onlinePlayers.remove(p);
	}
}
