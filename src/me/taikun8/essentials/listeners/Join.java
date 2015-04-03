package me.taikun8.essentials.listeners;

import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.PlayerManager;
import me.taikun8.essentials.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Join implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String f = Main.getInst().getConfig().getString("join-format");
		if(f.isEmpty()){
			e.setJoinMessage(null);
		} else {
			e.setJoinMessage(Util.setHEX(f.replace("{PLAYER}", e.getPlayer().getName())));
		}
		PlayerManager.addPlayer(e.getPlayer());
		
//----------------------------------------------------
		
		if(!p.hasPlayedBefore()){
			ItemStack stonepickaxe = new ItemStack(Material.STONE_PICKAXE);
			ItemStack cookedbeef = new ItemStack(Material.COOKED_BEEF, 128);
			ItemStack enderchest = new ItemStack(Material.ENDER_CHEST);
			ItemStack boat = new ItemStack(Material.BOAT, 2);
			p.getInventory().addItem(new ItemStack[] { stonepickaxe });
			p.getInventory().addItem(new ItemStack[] { cookedbeef });
			p.getInventory().addItem(new ItemStack[] { enderchest });
			p.getInventory().addItem(new ItemStack[] { boat });
	}
		
		@SuppressWarnings("unused")
		int players = Bukkit.getOnlinePlayers().length;
		int licznik = 0;
		int offline = 0;
		int online = 0;
		offline = Bukkit.getOfflinePlayers().length;
		online = Bukkit.getOnlinePlayers().length;
		licznik = offline + online;
		Util.sendMessage(p, " &7&m-------------&2&l NASZHC&7&l.PL &7&m-------------");
		Util.sendMessage(p, "  &7» §aWitaj: &3" + p.getName() + ",");
		Util.sendMessage(p, "  &7» §aGraczy online: &3" + Bukkit.getOnlinePlayers().length + "/" + Main.getInst().getConfig().getInt("config.slots") + ",");
		p.sendMessage(new StringBuilder("  §7 §aUnikalnych odwiedzin: §3").append(licznik).toString() + ",");
		Util.sendMessage(p, "  &7» §aTS3: §3NaszHc.pl");
		Util.sendMessage(p, "  &7» §aFacebook: §3http://fb.com/NaszHc");
		Util.sendMessage(p, "  &7» §aWWW: §3http://naszhc.pl.");
		Util.sendMessage(p, " &7&m-----------------------------------");
	}

}
