package me.PointShop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

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

	public static Inventory myInv = Bukkit.createInventory(null, 27, "GUI Shop");

	static {
		// 10 items
		myInv.setItem(0, new ItemStack(Material.WOOL, 1));
		myInv.setItem(1, new ItemStack(Material.WOOD, 1));
		myInv.setItem(2, new ItemStack(Material.WOOD, 1));
		myInv.setItem(3, new ItemStack(Material.WOOD, 1));
		myInv.setItem(4, new ItemStack(Material.WOOD, 1));
		myInv.setItem(5, new ItemStack(Material.WOOD, 1));
		myInv.setItem(6, new ItemStack(Material.WOOD, 1));
		myInv.setItem(7, new ItemStack(Material.WOOD, 1));
		myInv.setItem(8, new ItemStack(Material.WOOD, 1));
		myInv.setItem(9, new ItemStack(Material.WOOD, 1));
		// + 10 items
		myInv.setItem(10, new ItemStack(Material.WOOL, 1));
		myInv.setItem(11, new ItemStack(Material.WOOD, 1));
		myInv.setItem(12, new ItemStack(Material.WOOD, 1));
		myInv.setItem(13, new ItemStack(Material.WOOD, 1));
		myInv.setItem(14, new ItemStack(Material.WOOD, 1));
		myInv.setItem(15, new ItemStack(Material.WOOD, 1));
		myInv.setItem(16, new ItemStack(Material.WOOD, 1));
		myInv.setItem(17, new ItemStack(Material.WOOD, 1));
		myInv.setItem(18, new ItemStack(Material.WOOD, 1));
		myInv.setItem(19, new ItemStack(Material.WOOD, 1));
		// + 10 items
		/*
		 * myInv.setItem(20, new ItemStack(Material.WOOL, 1)); myInv.setItem(21,
		 * new ItemStack(Material.WOOD, 1)); myInv.setItem(22, new
		 * ItemStack(Material.WOOD, 1)); myInv.setItem(23, new
		 * ItemStack(Material.WOOD, 1)); myInv.setItem(24, new
		 * ItemStack(Material.WOOD, 1)); myInv.setItem(25, new
		 * ItemStack(Material.WOOD, 1)); myInv.setItem(26, new
		 * ItemStack(Material.WOOD, 1)); myInv.setItem(27, new
		 * ItemStack(Material.WOOD, 1)); myInv.setItem(28, new
		 * ItemStack(Material.WOOD, 1)); myInv.setItem(29, new
		 * ItemStack(Material.WOOD, 1));
		 */
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
			if (Clicked.getType() == Material.WOOL) {
				event.setCancelled(true);
				player.closeInventory();
				player.getInventory().addItem(new ItemStack(Material.WOOL, 1));
				player.openInventory(myInv);

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
