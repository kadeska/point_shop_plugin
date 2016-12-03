package pointshop.managers;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import pointshop.Main;

public class InventoryManager {

    private Main plugin;
    public InventoryManager(Main plugin) {
        this.plugin = plugin;
        initiateShopInv(); //This will be ran onEnable
    }

    //This is our shop inventory, we will create it onEnable so we don't always create an inventory everytime someone types /shop, that will make so it requires less power.
    private Inventory shopInv;

    //This is where we will create the inventory.
    private void initiateShopInv() {
        shopInv = plugin.getServer().createInventory(null, 9, "GUI Shop");
        
        //puting the amount value of the itemStack to 1 is redundant since default value is 1.
        // 8 items
        ItemStack ironBoots = new ItemStack(Material.IRON_BOOTS); // 50 points
        ItemStack ironLeggings = new ItemStack(Material.IRON_LEGGINGS); // 50 points
        ItemStack ironHelmet = new ItemStack(Material.IRON_HELMET); // 50 points
        ItemStack ironSword = new ItemStack(Material.IRON_SWORD); // 50 points
        ItemStack ironAxe = new ItemStack(Material.IRON_AXE); // 70 points
        ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE); // 40 points
        ItemStack ironSpade = new ItemStack(Material.IRON_SPADE); // 40 points
        ItemStack ironHoe = new ItemStack(Material.IRON_HOE); // 40 points

        //I commented this one out as I did not see any other pages.
        //ItemStack paper = new ItemStack(Material.PAPER, 1); // go to next page

        //Now let's add all our itemStack to the shopInv.
        shopInv.addItem(ironBoots, ironLeggings, ironHelmet, ironSword, ironAxe, ironPickaxe, ironSpade, ironHoe);
    }

    //This is a getter -> shopInv.
    public Inventory getShopInv() {
        return shopInv;
    }

}
