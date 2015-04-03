package me.taikun8.essentials;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import me.taikun8.essentials.commands.Back;
import me.taikun8.essentials.commands.Broadcast;
import me.taikun8.essentials.commands.ChangeLore;
import me.taikun8.essentials.commands.ChangeName;
import me.taikun8.essentials.commands.Chatt;
import me.taikun8.essentials.commands.ClearInv;
import me.taikun8.essentials.commands.Enchant;
import me.taikun8.essentials.commands.Fly;
import me.taikun8.essentials.commands.Gamemode;
import me.taikun8.essentials.commands.Head;
import me.taikun8.essentials.commands.Heal;
import me.taikun8.essentials.commands.Help;
import me.taikun8.essentials.commands.Helpop;
import me.taikun8.essentials.commands.Invsee;
import me.taikun8.essentials.commands.Message;
import me.taikun8.essentials.commands.Motd;
import me.taikun8.essentials.commands.Reply;
import me.taikun8.essentials.commands.SetSpawn;
import me.taikun8.essentials.commands.Spawn;
import me.taikun8.essentials.commands.TReload;
import me.taikun8.essentials.commands.Teleport;
import me.taikun8.essentials.commands.Time;
import me.taikun8.essentials.commands.Tppos;
import me.taikun8.essentials.commands.Weather;
import me.taikun8.essentials.commands.Whois;
import me.taikun8.essentials.commands.World;
import me.taikun8.essentials.listeners.ChatColor;
import me.taikun8.essentials.listeners.DisableCommand;
import me.taikun8.essentials.listeners.Join;
import me.taikun8.essentials.listeners.Leave;
import me.taikun8.essentials.listeners.PlayerChat;
import me.taikun8.essentials.listeners.SignColor;
import me.taikun8.essentials.runnable.ClearItems;
import net.milkbowl.vault.chat.Chat;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static Main instance;
	private static CommandMap cmdMap;
	private final List<Command> cmds = new ArrayList<Command>();
	private static Chat chat = null;
	
	public void onEnable(){
		instance = this;
		saveDefaultConfig();
		registerEvents();
		registerCommands();
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new ClearItems(), 0L, Main.getInst().getConfig().getLong("clear-delay-2") * 20);
	
		ItemStack ender = new ItemStack(Material.ENDER_CHEST, 1);
		@SuppressWarnings("deprecation")
		ShapedRecipe enderchest = new ShapedRecipe(ender).shape(new String[] {
				"AAA",
				"ABA",
				"AAA"})
				.setIngredient('A', Material.OBSIDIAN, 3)
				.setIngredient('B', Material.ENDER_PEARL, 2);
			Main.getInst().getServer().addRecipe(enderchest);
	
	}
	
	public void onDisable() {}

	public static Main getInst(){
		return instance;
	}
	
	public void onLoad()
	{
		instance = this;
	}
	
	private void registerCommands(){
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("changelore").setExecutor(new ChangeLore());
		getCommand("changename").setExecutor(new ChangeName());
		getCommand("chat").setExecutor(new Chatt());
		getCommand("ci").setExecutor(new ClearInv());
		getCommand("enchant").setExecutor(new Enchant());
		getCommand("fly").setExecutor(new Fly());
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("head").setExecutor(new Head());
		getCommand("heal").setExecutor(new Heal());
		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("tp").setExecutor(new Teleport());
		getCommand("treload").setExecutor(new TReload());
		getCommand("helpop").setExecutor(new Helpop());
		getCommand("help").setExecutor(new Help());
		getCommand("msg").setExecutor(new Message());
		getCommand("back").setExecutor(new Back());
		getCommand("whois").setExecutor(new Whois());
		getCommand("invsee").setExecutor(new Invsee());
		getCommand("reply").setExecutor(new Reply());
		getCommand("world").setExecutor(new World());
		getCommand("motd").setExecutor(new Motd());
		getCommand("time").setExecutor(new Time());
		getCommand("weather").setExecutor(new Weather());
		getCommand("tppos").setExecutor(new Tppos());
		
	}
	
	private void registerEvents(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Leave(), this);
		pm.registerEvents(new SignColor(), this);
		pm.registerEvents(new ChatColor(), this);
		pm.registerEvents(new DisableCommand(), this);
		pm.registerEvents(new PlayerChat(), this);
	}
	
	public static boolean getBarAPI(){
		if(Main.getInst().getConfig().getBoolean("barapi") == true){
			return true;
		}else{
			return false;
		}
	}
    @SuppressWarnings("unused")
	private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }
	public static Chat getChat(){
		return chat;
	}
	
	protected boolean registerCommand(Command command)
	{
	  if (cmdMap == null) {
	     try {
	        Field field = SimplePluginManager.class.getDeclaredField("commandMap");
	        field.setAccessible(true);
	        cmdMap = (CommandMap)field.get(Bukkit.getServer().getPluginManager());
	     }
	     catch (Exception e) {
	        e.printStackTrace();
	        return false;
	     }
	 }

	 this.cmds.add(command);
	 cmdMap.register("", command);
	 return true;
	 }
}
