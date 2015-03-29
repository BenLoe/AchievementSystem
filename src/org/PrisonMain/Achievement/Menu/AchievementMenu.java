package org.PrisonMain.Achievement.Menu;

import java.util.ArrayList;
import java.util.List;

import org.Prison.Friends.FriendAPI;
import org.PrisonMain.Achievement.AchievementAPI;
import org.PrisonMain.Achievement.Files;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum AchievementMenu {
	
	READING_THE_MANUAL(10),
	
	DONT_TELL_ANYONE(11),

	STEPPING_UP(12),
	
	POPULAR(13),

	THE_VOTING_KING(14),
	
	ULTIMATE_KILLSTREAK(15),
	
	SAVING_UP(16),
	
	GETTING_LUCKY(20),
	
	SMARTEST_GUY_AROUND(21),

	SUPREME_MINER(22),
	
	LIVING_THE_FANCY_LIFE(23),
	
	LIVING_THE_EXTRA_FANCY_LIFE(24);
	
	
	public final int Slot;
	
	private AchievementMenu(int i){
		this.Slot = i;
	}
	
	public static Inventory getInventoryFor(Inventory inv, Player p){
		for (AchievementMenu m : values()){
			inv.setItem(m.Slot, m.getItemFor(p));
		}
		return inv;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getItemFor(Player p){
		switch(this){
		case POPULAR:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(AchievementMenu.POPULAR, p.getName())){
				DisplayName = ChatColor.GREEN + "Popular";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Popular";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Make at least 10 friends.");
			int friends = FriendAPI.getFriendList(p.getName()).size();
			if (AchievementAPI.isCompleted(AchievementMenu.POPULAR, p.getName())){
				friends = 10;
			}
			lore.add("§7Progress: §b" + friends + "§7/§b10");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.GREEN + "5000$");
			lore.add(ChatColor.AQUA + "200 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case SUPREME_MINER:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(AchievementMenu.SUPREME_MINER, p.getName())){
				DisplayName = ChatColor.GREEN + "Supreme Miner";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Supreme Miner";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Mine 50,000 blocks in the mines.");
			int broken = 0;
			if (Files.config().contains("Players." + p.getName() + ".Blocks")){
				broken = Files.config().getInt("Players." + p.getName() + ".Blocks");
			}
			if (AchievementAPI.isCompleted(AchievementMenu.SUPREME_MINER, p.getName())){
				broken = 50000;
			}
			lore.add("§7Progress: §b" + broken + "§7/§b50000");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.GREEN + "500,000$");
			lore.add(ChatColor.AQUA + "5000 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case READING_THE_MANUAL:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(AchievementMenu.READING_THE_MANUAL, p.getName())){
				DisplayName = ChatColor.GREEN + "Reading the Manual";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Reading the Manual";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Take the welcome tutorial.");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.YELLOW + "2 Ancient Pickaxes");
			lore.add(ChatColor.GREEN + "2000$");
			lore.add(ChatColor.AQUA + "300 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case LIVING_THE_FANCY_LIFE:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(AchievementMenu.LIVING_THE_FANCY_LIFE, p.getName())){
				DisplayName = ChatColor.GREEN + "Living the Fancy Life";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Living the Fancy Life";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Purchase the §3§lVIP §frank on our website.");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.AQUA + "5000 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case THE_VOTING_KING:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(AchievementMenu.THE_VOTING_KING, p.getName())){
				DisplayName = ChatColor.GREEN + "The Voting King";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "The Voting King";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Vote for the server 50 times.");
			int progress = 0;
			if (org.Prison.Main.Files.config().contains("Players." + p.getName() + ".Votes")){
				int old =org.Prison.Main.Files.config().getInt("Players." + p.getName() + ".Votes");
				progress = old;
			}
			if (AchievementAPI.isCompleted(AchievementMenu.THE_VOTING_KING, p.getName())){
				progress = 50;
			}
			lore.add("§7Progress: §b" + progress + "§7/§b50");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.GREEN + "10,000$");
			lore.add(ChatColor.AQUA + "2000 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case STEPPING_UP:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(AchievementMenu.STEPPING_UP, p.getName())){
				DisplayName = ChatColor.GREEN + "Stepping Up";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Stepping Up";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Rankup from A to B.");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.GREEN + "5000$");
			lore.add(ChatColor.AQUA + "400 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case SAVING_UP:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(AchievementMenu.SAVING_UP, p.getName())){
				DisplayName = ChatColor.GREEN + "Saving Up";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Saving Up";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Save up 1,000,000$.");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.GREEN + "100,000$");
			lore.add(ChatColor.AQUA + "2000 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case DONT_TELL_ANYONE:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(AchievementMenu.DONT_TELL_ANYONE, p.getName())){
				DisplayName = ChatColor.GREEN + "Pssssst, Don't Tell Anyone";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Pssssst, Don't Tell Anyone";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Personal message one of your friends.");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.GREEN + "1000$");
			lore.add(ChatColor.AQUA + "300 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case SMARTEST_GUY_AROUND:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(AchievementMenu.SMARTEST_GUY_AROUND, p.getName())){
				DisplayName = ChatColor.GREEN + "Smartest Guy Around";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Smartest Guy Around";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Max out your intelectual level.");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.GREEN + "100,000$");
			lore.add(ChatColor.AQUA + "2500 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case GETTING_LUCKY:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(this, p.getName())){
				DisplayName = ChatColor.GREEN + "Getting Lucky";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Getting Lucky";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Get lucky and find a Ultra tool.");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.GREEN + "10,000$");
			lore.add(ChatColor.AQUA + "1500 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case LIVING_THE_EXTRA_FANCY_LIFE:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(this, p.getName())){
				DisplayName = ChatColor.GREEN + "Living the Extra Fancy Life";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Living the Extra Fancy Life";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Purchase the §a§lELITE §frank on our website.");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.AQUA + "8000 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		case ULTIMATE_KILLSTREAK:{
			ItemStack item = new ItemStack(Material.AIR);
			String DisplayName = "";
			List<String> lore = new ArrayList<String>();
			if (AchievementAPI.isCompleted(this, p.getName())){
				DisplayName = ChatColor.GREEN + "Ultimate Killstreak";
				lore.add("§a§lCompleted!");
				item = new ItemStack(373, 1, (short) 8261);
			}else{
				DisplayName = ChatColor.RED + "Ultimate Killstreak";
				item = new ItemStack(Material.GLASS_BOTTLE);
			}
			lore.add(" ");
			lore.add(ChatColor.WHITE + "Get a killstreak of 15 in PvP.");
			lore.add(" ");
			lore.add("§f§lReward: ");
			lore.add(ChatColor.GREEN + "10,000$");
			lore.add(ChatColor.AQUA + "1500 Crystals");
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName(DisplayName);
			itemm.setLore(lore);
			item.setItemMeta(itemm);
			return item;
		}
		}
		return new ItemStack(Material.AIR);
	}
	
}
