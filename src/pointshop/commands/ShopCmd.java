package pointshop.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import pointshop.Main;

public class ShopCmd implements CommandExecutor, Listener{

	private Main plugin;

	public ShopCmd(Main plugin) {
		this.plugin = plugin; // Accessing Main class instance
	}


	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("shop")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You must be a player to use this cammand!");
				return false;
			}

			Player player = (Player) sender;

			if (!player.hasPermission("guishop.use")) {

				player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");

				return true;
			}

			// Here we get our inventory that we stored in a Inventory Field.
			player.openInventory(plugin.getInventoryManager().getShopInv());

		}
		return true;
	}
}
