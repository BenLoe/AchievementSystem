package org.PrisonMain.Achievement;

import org.PrisonMain.Achievement.Menu.AchievementMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Events implements Listener{
		public static Main plugin;
		public Events(Main instance){
			plugin = instance;
		}
		
	@EventHandler (ignoreCancelled = true)
	public void breakBlock(BlockBreakEvent event){
		Player p = event.getPlayer();
		if (Files.config().contains("Players." + p.getName() + ".Blocks")){
			int old = Files.config().getInt("Players." + p.getName() + ".Blocks");
			Files.config().set("Players." + p.getName() + ".Blocks", old + 1);
			Files.saveConfig();
			if ((old + 1) >= 50000){
				AchievementAPI.completeAchievement(p, AchievementMenu.SUPREME_MINER);
			}
		}else{
			Files.config().set("Players." + p.getName() + ".Blocks", 1);
			Files.saveConfig();
		}
	}
}