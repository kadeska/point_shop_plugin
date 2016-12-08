package pointshop.listeners.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import pointshop.Main;

public class InventoryClick implements Listener {

	private Main plugin;

	public InventoryClick(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {

		// Here we first check if the correct inventory was clicked.
		if (e.getInventory().getTitle().contains("GUI Shop")) {

			// Here we make sure they are clicking an item and not a empty item
			// or if they are clicking NULL.
			if (e.getCurrentItem().getType() != Material.AIR || e.getCurrentItem() != null) {

				// We can safely cancel the event right here since, we know they
				// are clicking an item inside the inventory "GUI Shop".
				e.setCancelled(true);

				Player player = (Player) e.getWhoClicked();

				// Instead of using all those if statement and make it ugly, we
				// will just use a switch statement.
				switch (e.getCurrentItem().getType()) {

				case IRON_BOOTS:
					if (canBuy(50)) {
						player.closeInventory();
						player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
						player.openInventory(plugin.getInventoryManager().getShopInv());
						pointshop.managers.ScoreManager.removeScore(player, 50);
						break; // We break outside of the statement here so we
								// can safely execute the coder under.
					}
					player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
					break;

				case IRON_LEGGINGS:
					if (canBuy(50)) {
						player.closeInventory();
						player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
						player.openInventory(plugin.getInventoryManager().getShopInv());
						pointshop.managers.ScoreManager.removeScore(player, 50);
						break; // We break outside of the statement here so we
								// can safely execute the coder under.
					}
				case IRON_HELMET:
					if (canBuy(50)) {
						player.closeInventory();
						player.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
						player.openInventory(plugin.getInventoryManager().getShopInv());
						pointshop.managers.ScoreManager.removeScore(player, 50);
						break; // We break outside of the statement here so we
								// can safely execute the coder under.
					}
				case IRON_SWORD:
					if (canBuy(50)) {
						player.closeInventory();
						player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
						player.openInventory(plugin.getInventoryManager().getShopInv());
						pointshop.managers.ScoreManager.removeScore(player, 50);
						break; // We break outside of the statement here so we
								// can safely execute the coder under.
					}
				case IRON_AXE:
					if (canBuy(70)) {
						player.closeInventory();
						player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
						player.openInventory(plugin.getInventoryManager().getShopInv());
						pointshop.managers.ScoreManager.removeScore(player, 70);
						break; // We break outside of the statement here so we
								// can safely execute the coder under.
					}
				case IRON_PICKAXE:
					if (canBuy(40)) {
						player.closeInventory();
						player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
						player.openInventory(plugin.getInventoryManager().getShopInv());
						pointshop.managers.ScoreManager.removeScore(player, 40);
						break; // We break outside of the statement here so we
								// can safely execute the coder under.
					}
				case IRON_SPADE:
					if (canBuy(40)) {
						player.closeInventory();
						player.getInventory().addItem(new ItemStack(Material.IRON_SPADE));
						player.openInventory(plugin.getInventoryManager().getShopInv());
						pointshop.managers.ScoreManager.removeScore(player, 40);
						break; // We break outside of the statement here so we
								// can safely execute the coder under.
					}
				case IRON_HOE:
					if (canBuy(40)) {
						player.closeInventory();
						player.getInventory().addItem(new ItemStack(Material.IRON_HOE));
						player.openInventory(plugin.getInventoryManager().getShopInv());
						pointshop.managers.ScoreManager.removeScore(player, 40);
						break; // We break outside of the statement here so we
								// can safely execute the coder under.
					}

					break;
				default:
					break;

				}
			}
		}
	}

	private boolean canBuy(int cost) {
		if (pointshop.managers.ScoreManager.getScore(null) >= cost) {
			return true;
		}
		return false;
	}
}
