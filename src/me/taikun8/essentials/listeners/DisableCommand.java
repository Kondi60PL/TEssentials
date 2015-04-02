package me.taikun8.essentials.listeners;

import java.util.List;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class DisableCommand implements Listener{

	@EventHandler
	public void onDisableCommand(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		String msg = e.getMessage();
		String[] splittedMsg = msg.split(" ");
		String command = e.getMessage().split(" ")[0];
		String[] pluginCmds = { 
				"/logout", "/unregister", "/logit", "/profile", "/loginhistory", "/accunlock", "/acclock", "/recoverpass", "/changeemail", 
				"/pl", "/plugins", "/?", "/help", "/ver", "/version", "/bukkit", "/bukkit:ver", "/bukkit:version", "/icanhasbukkit",
				"/bukkit:me", "/bukkit:kill", "/me", "/remember", "/funnyguilds", "/fairpvp" };
		HelpTopic htopic = Bukkit.getServer().getHelpMap().getHelpTopic(command);
		if(containsIgnoreCase(pluginCmds, splittedMsg[0])){
			if (htopic == null) {
				e.setCancelled(true);
				for(String s : Main.getInst().getConfig().getStringList("unknown-command-message")){
				Util.sendMessage(p, s);
				}
			}
		}
	}
	
	public static boolean containsIgnoreCase(String[] board, String s){
		String[] arrayOfString = board;
		int j = board.length;
		for(int i = 0; i < j; i++){
			String otherstring = arrayOfString[i];
			if(otherstring.equalsIgnoreCase(s)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean containsIgnoreCase(List<String> board, String s){
		for(String otherString : board){
			if(otherString.equalsIgnoreCase(s)){
				return true;
			}
		}
		return false;
	}
	
	
	
}
