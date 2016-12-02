package me.kadeska.pointshop.commands;

import me.kadeska.pointshop.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class ShopCmd implements CommandExecutor {

    private Main plugin;
    public ShopCmd(Main plugin) {
        this.plugin = plugin; //Accessing Main class instance
    }

    //if (cmd.getName().equalsIgnoreCase("shop")) is redundant since this executor is called when it gets the "shop" command.

    @EventHandler
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to use this cammand!");
            return true; //Added the return value, so we can safely cast the CommandSender to a Player.
        }

        Player player = (Player) sender;

        //|| player.isOp() is redundant since ops already have all permissions.
        if(!player.hasPermission("guishop.use")) {

            player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");

            return true; //We return here so we can safely run what is under.
        }

        //Here we get our inventory that we stored in a Inventory Field.
        player.openInventory(plugin.getInventoryManager().getShopInv());

        return true;
    }
}
