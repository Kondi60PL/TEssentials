package me.taikun8.essentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColor implements Listener{
	
	@EventHandler
	public void onChatColor(AsyncPlayerChatEvent e){
		e.setMessage(e.getMessage().replaceAll("§", "&"));
	}

}
