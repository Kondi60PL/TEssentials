package me.taikun8.essentials.listeners;

import me.taikun8.essentials.utils.Util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignColor implements Listener{
	
	@EventHandler
	public void onSignColor(SignChangeEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("tessentials.sign")){
			for(int i = 0; i <= 3; i++){
				String s = Util.setHEX(e.getLine(i));
				e.setLine(i, s.replaceAll("§", "&"));
			}
		}
	}
}
