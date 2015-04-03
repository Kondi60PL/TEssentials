package me.taikun8.essentials.utils;

import me.taikun8.essentials.Main;

import org.bukkit.entity.Player;


public class HelpUtil {
	
	public static void sendHelp(int page, Player p){
		if(page == 1){
			Util.sendMessage(p, "&6Twoje dostepne komendy: &c1/3");
			if(p.hasPermission("tessentials.reload")) Util.sendMessage(p, "&c  /treload &8- &7Przeladowanie pluginu");
			if(p.hasPermission("tessentials.helpop")) Util.sendMessage(p, "&c  /helpop <tekst> &8- &7Szybki kontakt z administracja");
			if(p.hasPermission("tessentials.help")) Util.sendMessage(p, "&c  /help <strona> &8- &7Spis twoich komend");
			if(p.hasPermission("tessentials.enchant")) Util.sendMessage(p, "&c  /enchant <enchant> <level> &8- &7Enchantowanie przedmiotow");
			if(p.hasPermission("tessentials.clearinv")) Util.sendMessage(p, "&c  /ci &8- &7Czyszczenie ekwipunku");
			if(p.hasPermission("tessentials.changename")) Util.sendMessage(p, "&c  /changename <tekst["+Main.getInst().getConfig().getString("changeitem-remove")+"]> &8- &7Zmiana nazwy przedmiotu");
			if(p.hasPermission("tessentials.changelore")) Util.sendMessage(p, "&c  /changelore <tekst["+Main.getInst().getConfig().getString("changeitem-remove")+"]> &8- &7Zmiana opisu przedmiotu");
			if(p.hasPermission("tessentials.head")) Util.sendMessage(p, "&c  /head <nick> &8- &7Daje glowe gracza");
			if(p.hasPermission("tessentials.back")) Util.sendMessage(p, "&c  /back &8- &7Teleportacja w ostatnie miejsce");
		}else if(page == 2){
			Util.sendMessage(p, "&6Twoje dostepne komendy: &c2/3");
			if(p.hasPermission("tessentials.gamemode")) Util.sendMessage(p, "&c  /gm <tryb> &8- &7Zmiana trybu gry"); 
			if(p.hasPermission("tessentials.motd")) Util.sendMessage(p, "&c  /motdset <motd> &8- &7Dynamiczna zmiana motd"); 
			if(p.hasPermission("tessentials.time")) Util.sendMessage(p, "&c  /time <day/night> &8- &7Zmiana czasu swiata"); 
			if(p.hasPermission("tessentials.weather")) Util.sendMessage(p, "&c  /weather <thunder/sun> &8- &7Zmiana pogody swiata"); 
			if(p.hasPermission("tessentials.teleport")) Util.sendMessage(p, "&c  /tp <graczall> <nick> &8- &7Teleportowanie graczy"); 
			if(p.hasPermission("tessentials.whois")) Util.sendMessage(p, "&c  /whois [nick] &8- &7Informacje na temat gracza"); 
			if(p.hasPermission("tessentials.heal")) Util.sendMessage(p, "&c  /heal [nick] &8- &7Ulecza gracza");
			if(p.hasPermission("tessentials.tppos")) Util.sendMessage(p, "&c  /tppos [nick] <x> <y> <z> &8- &7Teleportacja w okreslone koordynaty"); 
			if(p.hasPermission("tessentials.invsee")) Util.sendMessage(p, "&c  /invsee <nick> &8- &7Otwiera ekwipunek gracza");
		}else if (page == 3){
			Util.sendMessage(p, "&6Twoje dostepne komendy: &c3/3");
			if(p.hasPermission("tessentials.setspawn")) Util.sendMessage(p, "&c  /setspawn &8- &7Ustawia globalny spawn");
			if(p.hasPermission("tessentials.spawn")) Util.sendMessage(p, "&c  /spawn &8- &7Teleportuje na spawn");
			if(p.hasPermission("tessentials.msg")) Util.sendMessage(p, "&c  /msg <nick> <tekst> &8- &7Komunikacja z graczem");
			if(p.hasPermission("tessentials.reply")) Util.sendMessage(p, "&c  /reply <tekst> &8- &7Odpowiedz na wiadomosc");
			//if(p.hasPermission("tessentials.ban")) Util.sendMessage(p, "&c  /ban <nick> <powod> &8- &7Banuje gracza na zawsze");
			if(p.hasPermission("tessentials.chat")) Util.sendMessage(p, "&c  /chat <off/on/clear>&8- &7Manipulacja czatem");
			if(p.hasPermission("tessentials.fly")) Util.sendMessage(p, "&c  /fly <on/off> <nick> &8- &7Wlaczanie/wylaczanie fly");
			if(p.hasPermission("tessentials.world")) Util.sendMessage(p, "&c  /world <swiat> &8- &7Teleportacja na rozne swiaty");
			if(p.hasPermission("tessentials.invsee")) Util.sendMessage(p, "&c  /invsee <nick> &8- &7Otwiera ekwipunek gracza");
		}

	}

}