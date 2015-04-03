package me.taikun8.essentials.listeners;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

import me.confuser.barapi.BarAPI;
import me.taikun8.essentials.Main;
import me.taikun8.essentials.utils.ChatUtil;
import me.taikun8.essentials.utils.Util;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class PlayerChat implements Listener{
	
	public static final Pattern URL_PATTERN = Pattern.compile("((?:(?:https?)://)?[\\w-_\\.]{2,})\\.([a-zA-Z]{2,3}(?:/\\S+)?)");
	
	public static final Pattern IPPATTERN = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|"
			+ "2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	
	public static final Pattern BANNED_WORDS = Pattern.compile(".*(skkf|mchc|xcrafters|ssij|xkleszcz|craftstory|face2face|"
			+ "f2f|2/10|lagi|gale|algi|chuj|chuja|chujek|chuju|chujem|"
			+ "chujnia|chujowy|chujowa|chujowe|cipa|cipe|cipie|dojebac|"
			+ "dojebie|dojebal|dojebala|dojebalem|dojebalam|dojebie|dopieprzac|"
			+ "dopierdalac|dopierdala|dopierdalal|dopierdalala|dopierdoli|dopierdolil|dopierdole|"
			+ "dopierdoli|dopierdalajacy|dopierdolic|dupa|dupie|dupcia|dupeczka|dupy|dupe|huj|hujek|"
			+ "hujnia|huja|huje|hujem|huju|jebac|jebal|jebie|jebia|jebak|jebaka|jebal|jebany|jebane|"
			+ "jebanka|jebanko|jebankiem|jebanymi|jebana|jebanym|jebanej|jebana|jebani|jebanych|jebanymi|"
			+ "jebcie|jebiacy|jebiaca|jebiacego|jebiacej|jebia|jebie|jebliwy|jebnac|jebnal|jebna|jebnela|jebnie|"
			+ "jebnij|jebut|koorwa|korwa|kurestwo|kurew|kurewski|kurewska|kurewskiej|kurewska|kurewsko|kurewstwo|kurwa|"
			+ "kurwaa|kurwami|kurwe|kurwie|kurwiska|kurwo|kurwy|kurwach|kurwami|kurewski|kurwiarz|kurwi�cy|kurwica|kurwic|"
			+ "kurwido�ek|kurwik|kurwiki|kurwiszcze|kurwiszon|kurwiszona|kurwiszonem|kurwiszony|kutas|kutasa|"
			+ "kutasie|kutasem|kutasy|kutasow|kutasach|kutasami|matkojebca|matkojebcy|matkojebca|matkojebcami|"
			+ "matkojebcach|najebac|najebal|najebane|najebany|najebana|najebie|najebia|naopierdalac|naopierdalal|"
			+ "naopierdalala|napierdalac|napierdalajacy|napierdolic|nawpierdalac|nawpierdalal|nawpierdalala|obsrywac|"
			+ "obsrywajacy|odpieprzac|odpieprzy|odpieprzyl|odpieprzyla|odpierdalac|odpierdol|odpierdolil|odpierdolila|"
			+ "odpierdoli|odpierdalajacy|odpierdalajaca|odpierdolic|odpierdoli|opieprzaj�cy|opierdalac|opierdala|opierdalajacy|"
			+ "opierdol|opierdolic|opierdoli|opierdola|piczka|pieprzniety|pieprzony|pierdel|pierdlu|pierdola|pierdolacy|"
			+ "pierdolaca|pierdol|pierdole|pierdolenie|pierdoleniem|pierdoleniu|pierdolec|pierdola|pierdolicie|pierdolic|"
			+ "pierdolil|pierdolila|pierdoli|pierdolniety|pierdolisz|pierdolnac|pierdolnal|pierdolnela|pierdolnie|pierdolnij|"
			+ "pierdolnik|pierdolona|pierdolone|pierdolony|pierdz�cy|pierdziec|pizda|pizde|pizdzie|pizdnac|pizdu|podpierdalac|"
			+ "podpierdala|podpierdalajacypodpierdolic|podpierdoli|pojeb|pojeba|pojebami|pojebani|pojebanego|myhard|mhard|pojebanemu|pojebani|"
			+ "pojebany|pojebanych|pojebanym|pojebanymi|pojebem|pojebac|pojebalo|popierdala|popierdalac|popierdolic|popierdoli|"
			+ "popierdolonego|popierdolonemu|popierdolonym|popierdolone|popierdoleni|popierdolony|porozpierdala|porozpierdalac|"
			+ "poruchac|przejebane|przejebac|przyjebali|przepierdalac|przepierdala|przepierdalajacy|przepierdalajaca|przepierdolic|"
			+ "przyjebac|przyjebie|przyjebala|przyjebal|przypieprzac|przypieprzajacy|przypieprzajaca|przypierdalac|przypierdala|"
			+ "przypierdoli|przypierdalajacy|przypierdolic|qrwa|rozjebac|rozjebie|rozjeba�a|rozpierdalac|rozpierdala|rozpierdolic|"
			+ "rozpierdole|rozpierdoli|rozpierducha|skurwiel|skurwiela|skurwielem|skurwielu|skurwysyn|skurwysynow|skurwysyna|"
			+ "skurwysynem|skurwysynu|skurwysyny|skurwysynski|skurwysynstwo|spieprzac|spieprza|spieprzaj|spieprzajcie|spieprzaja|"
			+ "spieprzajacy|spieprzajaca|spierdalac|spierdala|spierdalal|spierdalalcie|spierdalala|spierdalajacy|spierdolic|spierdoli|"
			+ "spierdol�|spierdola|srac|srajacy|srajac|sraj|sukinsyn|sukinsyny|sukinsynom|sukinsynowi|sukinsynow|ujebac|ujebal|"
			+ "ujebana|ujebany|ujebie|ujeba�a|ujebala|upierdalac|upierdala|upierdoli|upierdolic|upierdoli|upierdola|upierdoleni|"
			+ "wjebac|wjebie|wjebia|wjebiemy|wjebiecie|wkurwiac|wkurwi|wkurwia|wkurwial|wkurwiajacy|wkurwiajaca|wkurwic|"
			+ "wkurwi|wkurwiacie|wkurwiali|wkurwia|wkurwimy|wkurwicie|wkurwiacie|wkurwic|wkurwia|wpierdalac|wpierdalajacy|"
			+ "wpierdol|wpierdolic|wpizdu|wyjebac|wyjebali|wyjebac|wyjebie|wyjebia|wyjebiesz|wyjebie|wyjebiecie|wyjebiemy|"
			+ "wypieprzac|wypieprza|wypieprzal|wypieprzala|wypieprzy|wypieprzyla|wypieprzyl|wypierdal|wypierdalac|wypierdala|"
			+ "wypierdalaj|wypierdalal|wypierdalala|wypierdolic|wypierdoli|wypierdolimy|wypierdolicie|wypierdola|"
			+ "wypierdolili|wypierdolil|wypierdolila|zajebac|zajebie|zajebia|zajebial|zajebiala|zajebali|zajebana|"
			+ "zajebani|zajebane|zajebany|zajebanych|zajebanym|zajebanymi|zajebiste|zajebisty|zajebistych|zajebista|"
			+ "zajebistym|zajebistymi|zajebiscie|zapieprzyc|zapieprzy|zapieprzyl|zapieprzyla|zapieprza|zapieprz|"
			+ "zapieprzymy|zapieprzycie|zapieprzysz|zapierdala|zapierdalac|zapierdalaja|zapierdalaj|zapierdalajcie|"
			+ "zapierdalala|zapierdalali|zapierdalajacy|zapierdolic|zapierdoli|zapierdolil|zapierdolila|zapierdola|"
			+ "zapierniczac|zapierniczajacy|zasrac|zasranym|zasrywajacy|zesrywac|zesrywajac|"
			+ "zjebac|zjebal|zjebala|zjebana|zjebia|zjebali|zjeby+).*");
	private Map<CommandSender, Long> time = new WeakHashMap<CommandSender, Long>();
	
	@EventHandler(priority = EventPriority.LOW)
	public void chatevent(AsyncPlayerChatEvent e){
		String format = Main.getInst().getConfig().getString("chat-format");
		format = format.replace("{PREFIX}", new StringBuilder().append(Main.getChat().getPlayerPrefix(e.getPlayer()))).toString();
	    format = format.replace("{SUFFIX}", Main.getChat().getPlayerSuffix(e.getPlayer()));
	    format = format.replace("{PLAYER}", "%1$s");
	    format = format.replace("{MESSAGE}", "%2$s");
		e.setFormat(Util.setHEX(format));
		Long t = (Long)this.time.get(e.getPlayer());
	    long delay = Main.getInst().getConfig().getLong("slowmode");
	    if ((t != null) && (System.currentTimeMillis() - t.longValue() < delay * 1000)) {
	    	Util.sendMessage(e.getPlayer(), "&cBedziesz mogl napisac za " + delay + "".replace("L", "s"));
	        return;
	    }
		if(!e.getPlayer().hasPermission("tessentials.chat.bypass") || !e.getPlayer().isOp()){
			if(ChatUtil.getChat() == false){
				e.setCancelled(true);
				Util.sendMessage(e.getPlayer(), "&cChat jest obecnie wylaczony!");
				return;
			}
		}
		FileConfiguration cfg = Main.getInst().getConfig();
		if (!e.getPlayer().hasPermission("tessentials.chat.bypass") && (URL_PATTERN.matcher(e.getMessage()).find())) {
			if(cfg.getBoolean("url-block") == true){
				e.setCancelled(true);
				if(Main.getBarAPI() == true){
					BarAPI.setMessage(e.getPlayer(), Util.setHEX("&7TWOJ TEKST ZOSTAL &cZABLOKOWANY"), 10);
				}else{
					e.getPlayer().sendMessage(Util.setHEX("&7Twoj tekst zostal &czablokowany&7!"));
				}
			}
		}
		if (!e.getPlayer().hasPermission("tessentials.chat.bypass") && (IPPATTERN.matcher(e.getMessage()).find())) {
			if(cfg.getBoolean("ip-block") == true){
				e.setCancelled(true);
				if(Main.getBarAPI() == true){
					BarAPI.setMessage(e.getPlayer(), Util.setHEX("&7TWOJ TEKST ZOSTAL &cZABLOKOWANY"), 10);
				}else{
					e.getPlayer().sendMessage(Util.setHEX("&7Twoj tekst zostal &czablokowany&7!"));
				}
			}
		}
		if (!e.getPlayer().hasPermission("tessentials.chat.bypass") && (BANNED_WORDS.matcher(e.getMessage()).find())) {
			if(cfg.getBoolean("words-block") == true){
				e.setCancelled(true);
				if(Main.getBarAPI() == true){
					BarAPI.setMessage(e.getPlayer(), Util.setHEX("&7TWOJ TEKST ZOSTAL &cZABLOKOWANY"), 10);
				}else{
					e.getPlayer().sendMessage(Util.setHEX("&7Twoj tekst zostal &czablokowany&7!"));
				}
			}
		}
			
		e.setMessage(e.getMessage().replace("qEssentials", "&6&lqEssentials&7").replace("qessentials", "&6&lqEssentials&7").replace("qEssentialsa", "&6&lqEssentials&7").replace("qessentialsa", "&6&lqEssentials&7"));
		if (e.getPlayer().hasPermission("qessentials.chat.color")){
			e.setMessage(Util.setHEX(e.getMessage().replace("qEssentials", "&6&lqEssentials&7").replace("qessentials", "&6&lqEssentials&7").replace("qEssentialsa", "&6&lqEssentials&7").replace("qessentialsa", "&6&lqEssentials&7")));
		}
		
	}

}
