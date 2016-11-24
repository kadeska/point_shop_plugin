package me.PointShop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Shop {


	public void onEnable() {
		Main.getPlugin().saveConfig();
	}
	
    FileConfiguration config = Main.getPlugin().getConfig();
	
	public  void getConfig() {
		
		
		
		int P1name = config.getInt("P1name:");
		int P2name = config.getInt("P2name:");
		int P3name = config.getInt("P3name:");
		
	}

	public void onCommand(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		String command = event.getMessage();
		if (command.equalsIgnoreCase("shop")) {
			if (player.hasPermission("guishop.use") || player.isOp()) {
				player.openInventory(myInv);

			} else {
				event.setCancelled(true);
			}
		}
	} 

	public static Inventory myInv = Bukkit.createInventory(null, 18, "GUI Shop Page01");

	static {
		// 10 items
		myInv.setItem(0, new ItemStack(Material.IRON_BOOTS, 1)); // 50
		myInv.setItem(1, new ItemStack(Material.IRON_LEGGINGS, 1)); // 50
		myInv.setItem(2, new ItemStack(Material.IRON_CHESTPLATE, 1)); // 50
		myInv.setItem(3, new ItemStack(Material.IRON_HELMET, 1)); // 50
		myInv.setItem(4, new ItemStack(Material.IRON_SWORD, 1)); // 70
		myInv.setItem(5, new ItemStack(Material.IRON_AXE, 1)); // 40
		myInv.setItem(6, new ItemStack(Material.IRON_PICKAXE, 1)); // 40
		myInv.setItem(7, new ItemStack(Material.IRON_SPADE, 1)); // 40
		myInv.setItem(8, new ItemStack(Material.IRON_HOE, 1)); // 40
		myInv.setItem(9, new ItemStack(Material.PAPER, 1)); // go to next page

	}
	

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack Clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();

		if (inventory.getName().equals(myInv.getName())) {
			if (Clicked.getType() == Material.IRON_BOOTS) {
				if (Managers.getScore(player) >= 50) {
					Managers.removeScore(player, 50);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);

			}
			if (Clicked.getType() == Material.IRON_LEGGINGS) {
				if (Managers.getScore(player) >= 50) {
					Managers.removeScore(player, 50);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);

			}
			if (Clicked.getType() == Material.IRON_HELMET) {
				if (Managers.getScore(player) >= 50) {
					Managers.removeScore(player, 50);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_SWORD) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_AXE) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_AXE, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_PICKAXE) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_SPADE) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_SPADE, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_HOE) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_HOE, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);
			}
			if (Clicked.getType() == Material.PAPER) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.PAPER, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);
			}
		} else
			if (!(inventory.getName().equals(myInv.getName()))) {
			event.setCancelled(true);
			player.closeInventory();
			}
		
	}

	public void onDisable() {
		Main.getPlugin().saveConfig();
	}

}
