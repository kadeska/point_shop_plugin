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
		Player player = (Player) e.getWhoClicked();

		if (!e.getInventory().getTitle().contains("GUI Shop")) {
			e.setCancelled(true);

			if (e.getCurrentItem().getType() == Material.AIR) {
				e.setCancelled(true);

				if (e.getCurrentItem() == null) {
					e.setCancelled(true);

					switch (e.getCurrentItem().getType()) {

					case IRON_BOOTS:
						if (!canBuy(player, 50)) {
							player.closeInventory();
							player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
							player.openInventory(plugin.getInventoryManager().getShopInv());
							pointshop.managers.ScoreManager.removeScore(player, 50);
							break; // We break outside of the statement here so
									// we
									// can safely execute the coder under.
						}
						player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
					case IRON_LEGGINGS:
						if (canBuy(player, 50)) {
							player.closeInventory();
							player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
							player.openInventory(plugin.getInventoryManager().getShopInv());
							pointshop.managers.ScoreManager.removeScore(player, 50);
							break; // We break outside of the statement here so
									// we
									// can safely execute the coder under.
						}
						player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
					case IRON_HELMET:
						if (canBuy(player, 50)) {
							player.closeInventory();
							player.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
							player.openInventory(plugin.getInventoryManager().getShopInv());
							pointshop.managers.ScoreManager.removeScore(player, 50);
							break; // We break outside of the statement here so
									// we
									// can safely execute the coder under.
						}
						player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
					case IRON_SWORD:
						if (canBuy(player, 50)) {
							player.closeInventory();
							player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
							player.openInventory(plugin.getInventoryManager().getShopInv());
							pointshop.managers.ScoreManager.removeScore(player, 50);
							break; // We break outside of the statement here so
									// we
									// can safely execute the coder under.
						}
						player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
					case IRON_AXE:
						if (canBuy(player, 70)) {
							player.closeInventory();
							player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
							player.openInventory(plugin.getInventoryManager().getShopInv());
							pointshop.managers.ScoreManager.removeScore(player, 70);
							break; // We break outside of the statement here so
									// we
									// can safely execute the coder under.
						}
						player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
					case IRON_PICKAXE:
						if (canBuy(player, 40)) {
							player.closeInventory();
							player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
							player.openInventory(plugin.getInventoryManager().getShopInv());
							pointshop.managers.ScoreManager.removeScore(player, 40);
							break; // We break outside of the statement here so
									// we
									// can safely execute the coder under.
						}
						player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
					case IRON_SPADE:
						if (canBuy(player, 40)) {
							player.closeInventory();
							player.getInventory().addItem(new ItemStack(Material.IRON_SPADE));
							player.openInventory(plugin.getInventoryManager().getShopInv());
							pointshop.managers.ScoreManager.removeScore(player, 40);
							break; // We break outside of the statement here so
									// we
									// can safely execute the coder under.
						}
						player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
					case IRON_HOE:
						if (canBuy(player, 40)) {
							player.closeInventory();
							player.getInventory().addItem(new ItemStack(Material.IRON_HOE));
							player.openInventory(plugin.getInventoryManager().getShopInv());
							pointshop.managers.ScoreManager.removeScore(player, 40);
							break; // We break outside of the statement here so
									// we
									// can safely execute the coder under.
						}
						player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
					default:
						break;

					}
				}
			}
		}
	}

	private boolean canBuy(Player player, int cost) {
		if (pointshop.managers.ScoreManager.getScore(player) >= cost) {
			return true;
		}
		return false;
	}
}
