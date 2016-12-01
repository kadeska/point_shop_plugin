package me.kadeska.pointshop;

import me.kadeska.pointshop.managers.ScoreManager;
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


/*
*
* DO NOT USE THIS CLASS, I LEFT IT HERE SO YOU COULD SEE WHAT YOU DID.
* I LEFT COMMENTS WHERE SO YOU CAN SEE WHAT YOU DID WRONG.
*
* */


public class Shop implements Listener, CommandExecutor {

	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this cammand!");
			//Return statement is missing right here.
		}
		Player player = (Player) sender;

		//This is redundant because you don't want to keep adding the items to the inventory everytime they execute the command
		myInv1.addItem(ironboots, ironleggings, ironhelmet, ironsword, ironaxe, ironpickaxe, ironspade, ironhoe, paper);

		//This is redundant since this executor is called when it gets the "shop" command.
		if (cmd.getName().equalsIgnoreCase("shop")) {

			//|| player.isOp() is redundant since ops already have all permissions.
			if (player.hasPermission("guishop.use") || player.isOp()) {
				player.openInventory(myInv1);
			} else {
				sender.sendMessage("You do not have permission to use this cammand!");
			}
		}
		return true;
	}

	Inventory myInv1 = Bukkit.createInventory(null, 9, "GUI Shop Page01"); //You should store your inventory in an InventoryManager class instead.

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
				if (ScoreManager.getScore(player) >= 50) {
					ScoreManager.removeScore(player, 50);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);

			}
			if (Clicked.getType() == Material.IRON_LEGGINGS) {
				if (ScoreManager.getScore(player) >= 50) {
					ScoreManager.removeScore(player, 50);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);

			}
			if (Clicked.getType() == Material.IRON_HELMET) {
				if (ScoreManager.getScore(player) >= 50) {
					ScoreManager.removeScore(player, 50);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_SWORD) {
				if (ScoreManager.getScore(player) >= 70) {
					ScoreManager.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_AXE) {
				if (ScoreManager.getScore(player) >= 70) {
					ScoreManager.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_AXE, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_PICKAXE) {
				if (ScoreManager.getScore(player) >= 70) {
					ScoreManager.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_SPADE) {
				if (ScoreManager.getScore(player) >= 70) {
					ScoreManager.removeScore(player, 70);
					player.closeInventory();
					player.getInventory().addItem(new ItemStack(Material.IRON_SPADE, 1));
					player.openInventory(myInv1);
				} else
					player.sendMessage("You do not have enoph points to buy this item!");
				event.setCancelled(true);
			}
			if (Clicked.getType() == Material.IRON_HOE) {
				if (ScoreManager.getScore(player) >= 70) {
					ScoreManager.removeScore(player, 70);
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
