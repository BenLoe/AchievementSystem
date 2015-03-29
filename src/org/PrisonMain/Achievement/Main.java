package org.PrisonMain.Achievement;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	Files files = new Files(this);
	Events events = new Events(this);
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new Events(this), this);
		saveDefaultConfig();
	}
}
