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
import pointshop.utils.SettingsManager;
import pointshop.commands.ShopCmd;

public class Main extends JavaPlugin {

	private PluginManager pm = getServer().getPluginManager();

	private ScoreManager scoreManager;
	private InventoryManager inventoryManager;
	private SettingsManager settingsManager;

	// Must indicate that we are overriding the method "onEnable" from the super
	// class.
	@Override
	public void onEnable() {
		settingsManager.setup();
		initiateManagers();
		registerListeners();

		saveDefaultConfig();
		getCommand("shop").setExecutor(new ShopCmd(this));

		ConsoleCommandSender console = getServer().getConsoleSender();
		console.sendMessage(ChatColor.GREEN + "GUI Shop has been enabled");

	}

	@Override
	public void onDisable() {
		settingsManager.saveData();
		settingsManager.saveConfig();

		saveConfig();

		ConsoleCommandSender console = getServer().getConsoleSender();

		console.sendMessage(ChatColor.GREEN + "GUI Shop has been disabled");

	}

	private void registerListeners() {
		pm.registerEvents(new InventoryClick(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new ShopCmd(this), this);
		pm.registerEvents(new EntityDeath(), this);

	}

	// In this method we will initiate all our managers.
	private void initiateManagers() {
		//scoreManager = new ScoreManager(this); // 'this' means this class
		inventoryManager = new InventoryManager(this);
	}

	// This is where we will make our getter methods to get our managers and use
	// their methods.
	public ScoreManager getScoreManager() {
		return scoreManager;
	}

	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}

	public SettingsManager getSettingsManager() {
		return settingsManager;
	}

	

}
