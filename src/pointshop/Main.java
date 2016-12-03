package pointshop;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pointshop.listeners.entity.EntityDeath;
import pointshop.listeners.inventory.InventoryClick;
import pointshop.listeners.player.PlayerJoin;
import pointshop.managers.InventoryManager;
import pointshop.managers.ScoreManager;
import pointshop.commands.ShopCmd;

/*

I REMADE A BUNCH OF STUFF ON THE PLUGIN, YOU CAN GO SEE IN THE "SHOP" CLASS I LEFT COMMENTS IN THERE SO YOU COULD SEE WHAT YOU DID WRONG
I SUGGEST YOU LOOK INTO OBJECT ORIENTING PROGRAMMING
MAYBE TRY TO READ A BOOK ON JAVA, THAT'S WHAT I PERSONALLY DID

 */


public class Main extends JavaPlugin {

	private PluginManager pm = getServer().getPluginManager();

	private ScoreManager scoreManager;
	private InventoryManager inventoryManager;

	//Must indicate that we are overriding the method "onEnable" from the super class.
	@Override
	public void onEnable() {
		initiateManagers();
		registerListeners();




		saveDefaultConfig();
		getCommand("shop").setExecutor(new ShopCmd(null));

		/* This is redundant since the server already says that the plugin has been enabled.

		ConsoleCommandSender console = getServer().getConsoleSender();
		console.sendMessage(ChatColor.RED + "GUI Shop has been enabled");
		*/

	}

	@Override
	public void onDisable() {
		saveConfig();

		ConsoleCommandSender console = getServer().getConsoleSender();

		console.sendMessage(ChatColor.RED + "GUI Shop has been disabled");

	}

	//Does not need to be public
	private void registerListeners() {
		pm.registerEvents(new InventoryClick(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new ShopCmd(null), this);
		pm.registerEvents(new EntityDeath(), this);

	}

	//In this method we will initiate all our managers.
	private void initiateManagers() {
		scoreManager = new ScoreManager(this); //'this' means this class
		inventoryManager = new InventoryManager(this);
	}

	//This is where we will make our getter methods to get our managers and use their methods.
	public ScoreManager getScoreManager() {
		return scoreManager;
	}

	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}





}
