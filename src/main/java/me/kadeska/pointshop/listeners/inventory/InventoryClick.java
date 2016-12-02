package me.kadeska.pointshop.listeners.inventory;

import me.kadeska.pointshop.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

    private Main plugin;
    public InventoryClick(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {

        //Here we first check if the correct inventory was clicked.
        if(e.getInventory().getTitle().contains("GUI Shop")) {

            //Here we make sure they are clicking an item and not a empty item or if they are clicking NULL.
            if(e.getCurrentItem().getType() != Material.AIR || e.getCurrentItem() != null) {

                //We can safely cancel the event right here since, we know they are clicking an item inside the inventory "GUI Shop".
                e.setCancelled(true);

                Player player = (Player) e.getWhoClicked();

                //Instead of using all those if statement and make it ugly, we will just use a switch statement.
                switch (e.getCurrentItem().getType()) {

                    case IRON_BOOTS:
                        /*Temp value til I setup the player points*/
                        if(canBuy(5 , 10)) {
                            player.closeInventory();
                            player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
                            player.openInventory(plugin.getInventoryManager().getShopInv());
                            //TODO: remove points from player
                            break; //We break outside of the statement here so we can safely execute the coder under.
                        }
                        player.sendMessage(ChatColor.RED + "You do not have enough points to buy this item");
                        break;

                    case IRON_LEGGINGS:

                        break;

                }
            }

        }
    }

    private boolean canBuy(int playerPoints, int cost) {
        if(playerPoints >= cost) {
            return true;
        }
        return false;
    }
}
