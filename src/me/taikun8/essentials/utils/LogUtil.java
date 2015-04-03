package me.taikun8.essentials.utils;

import java.io.PrintStream;

import me.taikun8.essentials.Main;

import org.bukkit.configuration.file.FileConfiguration;


public class LogUtil {

	private static LogUtil instance;
	
	private static PrintStream l = System.out;
	private static String name = Main.getInst().getDescription().getName();
	private static String prefixInfo = "[" + name + "] ";
	private static String prefixWarn = "[" + name + " / WARNING] ";
	private static String prefixError = "[" + name + " / ERROR] ";
	private static String prefixCritical = "[" + name + " / CRITICAL ERROR] ";
	private static String prefixDebug = "[" + name + " / DEBUG] ";
	private static FileConfiguration cfg = Main.getInst().getConfig();
	
	public static LogUtil getLogger(){
		return instance;
	}
	
	public static void info(String info){
		l.println(prefixInfo+info);
	}
	public static void warn(String warn){
		l.println(prefixWarn+warn);
	}
	public static void error(String error){
		l.println(prefixError+error);
	}
	public static void critical(String critical){
		l.println(prefixCritical+critical);
	}
	public static void debug(String debug){
		if(cfg.getBoolean("config.debug") == true){
			l.println(prefixDebug+debug);
		}
	}
 
}
