package me.PointShop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Shop {

	public void onEnable() {
		Main.getPlugin().saveDefaultConfig();
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

	public void InventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack Clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();

		if (inventory.getName().equals(myInv.getName())) {
			if (Clicked.getType() == Material.IRON_BOOTS) {
				if (Managers.getScore(player) == 50) {
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));
					player.openInventory(myInv);
				} else
					// player.spigot().sendMessage(new TextComponent( "You do
					// not have enough points! you need 50 points to buy this
					// item!"));
					event.setCancelled(true);

			}
			if (Clicked.getType() == Material.WOOD) {
				event.setCancelled(true);
				player.closeInventory();
				player.getInventory().addItem(new ItemStack(Material.WOOD, 1));
				player.openInventory(myInv);

			}

		}
	}

	public void onDisable() {
		Main.getPlugin().saveDefaultConfig();
	}

}
