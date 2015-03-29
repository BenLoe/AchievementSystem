package org.PrisonMain.Achievement;

import java.util.ArrayList;
import java.util.List;

import org.Prison.Main.Currency.CrystalAPI;
import org.Prison.Main.Currency.MoneyAPI;
import org.Prison.Main.Options.OptionAPI;
import org.Prison.Main.Options.OptionType;
import org.PrisonMain.Achievement.Menu.AchievementMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AchievementAPI {

	public static boolean isCompleted(AchievementMenu m, String name){
		if (getCompletedList(name).contains(m.name())){
			
			return true;
		}else{
			return false;
		}
	}
	
	public static List<String> getCompletedList(String name){
		if(Files.config().contains("Players." + name + ".Completed")){
			return Files.config().getStringList("Players." + name + ".Completed");
		}else{
			return new  ArrayList<String>();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void completeAchievement(Player p, AchievementMenu m){
		if (!isCompleted(m, p.getName())){
			List<String> newcompleted = getCompletedList(p.getName());
			newcompleted.add(m.name());
			Files.config().set("Players." + p.getName() + ".Completed", newcompleted);
			Files.saveConfig();
			if (OptionAPI.isEnabled(OptionType.ACHIEVEMENTS, p.getName())){
				p.sendMessage("§b§l§m-----------§b§l[§f§lAchievement Completed§b§l]§b§l§m-----------");
				p.sendMessage("   ");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
				switch(m){
				case DONT_TELL_ANYONE:{
					p.sendMessage(ChatColor.GREEN + "Pssssst, Don't Tell Anyone");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Personal message one of your friends.");
					p.sendMessage("   ");
					p.sendMessage("§a§l+ 1000$");
					p.sendMessage("§b§l+ 300 Crystals");
					MoneyAPI.addMoney(p, 1000);
					CrystalAPI.addCrystals(p.getName(), 300);
					
				}
				break;
				case POPULAR:{
					p.sendMessage(ChatColor.GREEN + "Popular");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Make at least 10 friends.");
					p.sendMessage("   ");
					p.sendMessage("§a§l+ 2000$");
					p.sendMessage("§b§l+ 500 Crystals");
					MoneyAPI.addMoney(p, 2000);
					CrystalAPI.addCrystals(p.getName(), 500);
				}
				break;
				case LIVING_THE_FANCY_LIFE:{
					p.sendMessage(ChatColor.GREEN + "Living the Fancy Life");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Purchase the §3§lVIP §frank on our website.");
					p.sendMessage("   ");
					p.sendMessage("§b§l+ 5000 Crystals");
					CrystalAPI.addCrystals(p.getName(), 5000);
				}
				break;
				case GETTING_LUCKY:{
					p.sendMessage(ChatColor.GREEN + "Getting Lucky");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Get lucky and find a Ultra tool.");
					p.sendMessage("   ");
					p.sendMessage("§a§l+ 10,000$");
					p.sendMessage("§b§l+ 1500 Crystals");
					CrystalAPI.addCrystals(p.getName(), 1500);
					MoneyAPI.addMoney(p, 10000);
				}
				break;
				case LIVING_THE_EXTRA_FANCY_LIFE:{
					p.sendMessage(ChatColor.GREEN + "Living the Extra Fancy Life");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Purchase the §a§lELITE §frank on our website.");
					p.sendMessage("   ");
					p.sendMessage("§b§l+ 8000 Crystals");
					CrystalAPI.addCrystals(p.getName(), 8000);
				}
				break;
				case READING_THE_MANUAL:{
					p.sendMessage(ChatColor.GREEN + "Reading the Manual");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Take the welcome tutorial.");
					p.sendMessage("   ");
					p.sendMessage("§e§l+ 2 Ancient Pickaxes");
					p.sendMessage("§a§l+ 2000$");
					p.sendMessage("§b§l+ 300 Crystals");
					CrystalAPI.addCrystals(p.getName(), 300);
					MoneyAPI.addMoney(p, 2000);
					ItemStack ancient = new ItemStack(Material.STONE_PICKAXE);
					ItemMeta ancientm = ancient.getItemMeta();
					ancientm.setDisplayName(ChatColor.YELLOW + "Ancient Pickaxe");
					List<String> lore = new ArrayList<String>();
					lore.add(ChatColor.GRAY + "Give this to the Identifier to see what");
					lore.add(ChatColor.GRAY + "type of pickaxe lies within.");
					ancientm.setLore(lore);
					ancient.setItemMeta(ancientm);
					p.getInventory().addItem(ancient);
					p.getInventory().addItem(ancient);
					p.updateInventory();
				}
				break;
				case SAVING_UP:{
					p.sendMessage(ChatColor.GREEN + "Saving Up");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Save up 1,000,000$.");
					p.sendMessage("   ");
					p.sendMessage("§a§l+ 100,000$");
					p.sendMessage("§b§l+ 2000 Crystals");
					CrystalAPI.addCrystals(p.getName(), 2000);
					MoneyAPI.addMoney(p, 100000);
				}
				break;
				case SMARTEST_GUY_AROUND:{
					p.sendMessage(ChatColor.GREEN + "Smartest Guy Around");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Max out your intelectual level.");
					p.sendMessage("   ");
					p.sendMessage("§a§l+ 100,000$");
					p.sendMessage("§b§l+ 2500 Crystals");
					CrystalAPI.addCrystals(p.getName(), 2500);
					MoneyAPI.addMoney(p, 100000);
				}
				break;
				case THE_VOTING_KING:{
					p.sendMessage(ChatColor.GREEN + "The Voting King");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Vote for the server 50 times.");
					p.sendMessage("   ");
					p.sendMessage("§a§l+ 10,000$");
					p.sendMessage("§b§l+ 2000 Crystals");
					CrystalAPI.addCrystals(p.getName(), 2000);
					MoneyAPI.addMoney(p, 10000);
				}
				break;
				case SUPREME_MINER:{
					p.sendMessage(ChatColor.GREEN + "Supreme Miner");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Mine 50000 blocks in the mine.");
					p.sendMessage("   ");
					p.sendMessage("§a§l+ 500,000$");
					p.sendMessage("§b§l+ 5000 Crystals");
					CrystalAPI.addCrystals(p.getName(), 5000);
					MoneyAPI.addMoney(p, 500000);
				}
				break;
				case STEPPING_UP:{
					p.sendMessage(ChatColor.GREEN + "Stepping Up");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Rankup for the first time.");
					p.sendMessage("   ");
					p.sendMessage("§a§l+ 5000$");
					p.sendMessage("§b§l+ 400 Crystals");
					CrystalAPI.addCrystals(p.getName(), 400);
					MoneyAPI.addMoney(p, 5000);
				}
				break;
				case ULTIMATE_KILLSTREAK:{
					p.sendMessage(ChatColor.GREEN + "Ultimate Killstreak");
					p.sendMessage("   ");
					p.sendMessage(ChatColor.WHITE + "Get a killstreak of 15 in PvP.");
					p.sendMessage("   ");
					p.sendMessage("§a§l+ 10,000$");
					p.sendMessage("§b§l+ 1500 Crystals");
					CrystalAPI.addCrystals(p.getName(), 1500);
					MoneyAPI.addMoney(p, 10000);
				}
			}
				p.sendMessage("   ");
				p.sendMessage("§b§l§m-------------------------------------------");
		}
	}
	}
}
