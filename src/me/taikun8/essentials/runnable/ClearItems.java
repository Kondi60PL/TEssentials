package me.taikun8.essentials.runnable;

import java.util.List;

import me.taikun8.essentials.Main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

public class ClearItems implements Runnable{

	public void run(){
		Bukkit.getScheduler().runTaskLater(Main.getInst(), (Runnable)new Runnable(){
			public void run(){
				String wname = Main.getInst().getConfig().getString("clear-world");
				World w = Bukkit.getServer().getWorld(wname);
			List<Entity> entList = w.getEntities();
			Bukkit.broadcast(Main.getInst().getConfig().getString("clear-cleared"), "tessentials.clearmsg");
			for(Entity current : entList){
				if(current instanceof Item){
					current.remove();
				}
			}
			}
		}, Main.getInst().getConfig().getLong("clear-delay-1") * 20);
	}
}
