package me.PointShop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Shop implements Listener, CommandExecutor {

	public void onEnable() {
		Main.getPlugin().saveConfig();
	}

	public void onDisable() {
		Main.getPlugin().saveConfig();
	}

	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this cammand!");
			return false;
		}
		Player player = (Player) sender;
		myInv1.addItem(ironboots, ironleggings, ironhelmet, ironsword, ironaxe, ironpickaxe, ironspade, ironhoe, paper);

		if (cmd.getName().equalsIgnoreCase("shop")) {
			if (player.hasPermission("guishop.use") || player.isOp()) {
				player.openInventory(myInv1);
				return true;

			} else {
				sender.sendMessage("You do not have permisstion to use this cammand!");

			}
		}
		return true;
	}

	Inventory myInv1 = Bukkit.createInventory(null, 9, "GUI Shop Page01");

	// 8 items
	ItemStack ironboots = new ItemStack(Material.IRON_BOOTS, 1); // 50 points
	ItemStack ironleggings = new ItemStack(Material.IRON_LEGGINGS, 1); // 50 points
	ItemStack ironhelmet = new ItemStack(Material.IRON_HELMET, 1); // 50 points
	ItemStack ironsword = new ItemStack(Material.IRON_SWORD, 1); // 50 points
	ItemStack ironaxe = new ItemStack(Material.IRON_AXE, 1); // 70 points
	ItemStack ironpickaxe = new ItemStack(Material.IRON_PICKAXE, 1); // 40 points
	ItemStack ironspade = new ItemStack(Material.IRON_SPADE, 1); // 40 points
	ItemStack ironhoe = new ItemStack(Material.IRON_HOE, 1); // 40 points
	ItemStack paper = new ItemStack(Material.PAPER, 1); // go to next page

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack Clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();

		if (inventory.getName().equals(myInv1.getName())) {
			if (Clicked.getType() == Material.IRON_BOOTS) {
				if (Managers.getScore(player) >= 50) {
					Managers.removeScore(player, 50);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);

			}
			if (Clicked.getType() == Material.IRON_LEGGINGS) {
				if (Managers.getScore(player) >= 50) {
					Managers.removeScore(player, 50);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);

			}
			if (Clicked.getType() == Material.IRON_HELMET) {
				if (Managers.getScore(player) >= 50) {
					Managers.removeScore(player, 50);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_SWORD) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_AXE) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_AXE, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_PICKAXE) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_SPADE) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_SPADE, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_HOE) {
				if (Managers.getScore(player) >= 70) {
					Managers.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_HOE, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.PAPER) {
				player.closeInventory();
				// player.openInventory(myInv2);
			} else
				player.sendMessage(ChatColor.RED + "error");
			event.setCancelled(true);

		} else if (!(inventory.getName().equals(myInv1.getName()))) {
			event.setCancelled(true);
		}

	}

}
