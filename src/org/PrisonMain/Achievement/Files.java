package org.PrisonMain.Achievement;

import org.bukkit.configuration.file.FileConfiguration;


public class Files {
	public static Main plugin;
	public Files(Main instance){
		plugin = instance;
	}
	
	public static FileConfiguration config(){
		return plugin.getConfig();
	}
	
	public static void saveConfig(){
		plugin.saveConfig();
	}
	
}
