package me.taikun8.essentials.utils;

import java.util.ArrayList;
import java.util.List;

import me.taikun8.essentials.Main;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TimeUtil implements Listener{
	
	public final static List<Player> list = new ArrayList<Player>();
	
	public static void teleportDelay(final Player player, final Location loc)
	{
		if(player.hasPermission("tessentials.teleport.bypass")){
			BackUtil.setLastLocation(player, player.getLocation());
			player.teleport(loc);
			Util.sendMessage(player, "&7Teleportacja...");
			return;
		}
		list.add(player);
		Util.sendMessage(player, "&7Zaczekaj &c" + Main.getInst().getConfig().getLong("tp-delay") + " sekund!".replace("L", ""));
		Main.getInst().getServer().getScheduler().runTaskLater(Main.getInst(), new Runnable() {
		    public void run() {
		    	if(list.contains(player)){
		    	   BackUtil.setLastLocation(player, player.getLocation());
			       player.teleport(loc);
			       list.remove(player);
			       Util.sendMessage(player, "&7Teleportacja...");
			       Main.getInst().getServer().getScheduler().cancelAllTasks();
		    	}
		    }
		}, Main.getInst().getConfig().getLong("tp-delay") * 20); 
	}

	
	@EventHandler(priority = EventPriority.LOW)
	public void onmove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(list.contains(p)){
			list.remove(p);
			Util.sendMessage(p, "&cTeleportacja zostala przerwana!");
		}
		
	}
}