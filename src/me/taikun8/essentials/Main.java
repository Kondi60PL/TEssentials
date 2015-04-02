package me.taikun8.essentials;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import me.taikun8.essentials.commands.Broadcast;
import me.taikun8.essentials.commands.ChangeLore;
import me.taikun8.essentials.commands.ChangeName;
import me.taikun8.essentials.commands.Chat;
import me.taikun8.essentials.listeners.ChatColor;
import me.taikun8.essentials.listeners.DisableCommand;
import me.taikun8.essentials.listeners.Join;
import me.taikun8.essentials.listeners.Leave;
import me.taikun8.essentials.listeners.PlayerChat;
import me.taikun8.essentials.listeners.SignColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
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
	}
	
	public void onDisable() {}

	public static Main getInst(){
		return instance;
	}
	
    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }
	
	public void onLoad()
	{
		instance = this;
	}
	
	private void registerCommands(){
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("changelore").setExecutor(new ChangeLore());
		getCommand("changename").setExecutor(new ChangeName());
		getCommand("chat").setExecutor(new Chat());
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
