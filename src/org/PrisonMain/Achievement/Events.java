package org.PrisonMain.Achievement;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

import org.PrisonMain.Achievement.Menu.AchievementMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class Events implements Listener{
		public static Main plugin;
		public Events(Main instance){
			plugin = instance;
		}
		public static HashMap<UUID,Integer> blocks = new HashMap<>();
		
	@EventHandler (ignoreCancelled = true)
	public void breakBlock(BlockBreakEvent event){
		Player p = event.getPlayer();
		UUID uuid = p.getUniqueId();
		if (blocks.isEmpty()){
			blocks.put(p.getUniqueId(), 1);
			Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable(){
				public void run(){
					for (Entry<UUID, Integer> e: blocks.entrySet()){
						UUID uuid = e.getKey();
						int i = e.getValue();
						if (Files.config().contains("Players." + uuid + ".Blocks")){
							int old = Files.config().getInt("Players." + uuid + ".Blocks");
							Files.config().set("Players." + uuid + ".Blocks", old + i);
							if (Bukkit.getPlayer(uuid) != null){
								if ((old + i) >= 50000){
								AchievementAPI.completeAchievement(Bukkit.getPlayer(uuid), AchievementMenu.SUPREME_MINER);
								}
							}
						}else{
							Files.config().set("Players." + uuid + ".Blocks", i);
						}
					}
					Files.saveConfig();
					blocks.clear();
				}
			}, 5 * 20l);
		}else{
			if (blocks.containsKey(p.getUniqueId())){
				int i = blocks.get(p.getUniqueId());
				blocks.put(p.getUniqueId(), i + 1);
			}else{
				blocks.put(p.getUniqueId(), 1);
			}
		}
	}
	
}