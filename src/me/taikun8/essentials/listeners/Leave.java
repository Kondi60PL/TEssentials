package me.taikun8.essentials.listeners;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.PlayerManager;
import me.taikun8.essentials.utils.Util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener{
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		String f = Main.getInst().getConfig().getString("leave-format");
		if(f.isEmpty()){
			e.setQuitMessage(null);
		} else {
			e.setQuitMessage(Util.setHEX(f.replace("{PLAYER}", e.getPlayer().getName())));
		}
		PlayerManager.removePlayer(e.getPlayer());
	}

}
