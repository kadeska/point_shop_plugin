package pointshop.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingsManager {

	private YamlConfiguration SettingsManager;
	private String Playername;

	FileConfiguration data;
	FileConfiguration config;

	public File cfile;
	public File dfile;

	Plugin p;
	
	public static HashMap<Player, File> playerDataMap = new HashMap<Player, File>();
	

	public SettingsManager(File dfile, String playername) {
		SettingsManager = new YamlConfiguration();
		Playername = playername;

	}
	
	

	public boolean setup() {
		data = YamlConfiguration.loadConfiguration(dfile);

		cfile = new File(p.getDataFolder(), "config.yml");
		dfile = new File(p.getDataFolder(), "data.yml");

		config = p.getConfig();
		config.options().copyDefaults(true);
		saveConfig();

		try {
			if (!dfile.exists()) {
				dfile.createNewFile();
				p.getLogger().info("New Playerdata file created for " + Playername);
				
			}

			if (!p.getDataFolder().exists()) {
				p.getDataFolder().mkdir();
			}

		} catch (IOException e) {
			p.getLogger().severe(ChatColor.RED + "Could not create data.yml!");
			//Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data.yml!");
			e.getMessage();
		}
		return true;
	}
	
	

	public FileConfiguration getData() {
		return data;
	}

	public FileConfiguration getConfig() {
		return config;
	}

	public void saveData() {
		try {
			data.save(dfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save data.yml!");
			e.printStackTrace();
		}
	}

	public void saveConfig() {
		try {
			config.save(cfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
			e.printStackTrace();
		}
	}

	public void reloadData() {
		data = YamlConfiguration.loadConfiguration(dfile);
	}

	public void reloadConfig() {
		config = YamlConfiguration.loadConfiguration(cfile);
	}

	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
	
	public static void loadPlayerdata(String playername, Player p) {
		File dir = new File(Bukkit.getPluginManager().getPlugin("GUIshop").getDataFolder() + "/playerdata");
		if (!dir.exists())
			dir.mkdir();
		File file = new File(dir, playername + ".yml");
		SettingsManager playerdata = new SettingsManager(file, playername);
		if (!playerdata.setup()) {
			throw new IllegalStateException("The player data file for player " + playername + " was not loaded correctly.");
			
		}else{
			playerDataMap.put(p, file);
			
		}

	

	}
}