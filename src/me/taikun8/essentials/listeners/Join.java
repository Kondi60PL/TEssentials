package me.taikun8.essentials.listeners;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.PlayerManager;
import me.taikun8.essentials.utils.Util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		String f = Main.getInst().getConfig().getString("join-format");
		if(f.isEmpty()){
			e.setJoinMessage(null);
		} else {
			e.setJoinMessage(Util.setHEX(f.replace("{PLAYER}", e.getPlayer().getName())));
		}
		PlayerManager.addPlayer(e.getPlayer());
	}

}
