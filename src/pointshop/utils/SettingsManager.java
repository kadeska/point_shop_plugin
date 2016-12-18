package pointshop.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingsManager {

	Plugin p;

	FileConfiguration config;
	public File cfile;

	FileConfiguration data;
	public File dfile;

	public void setup() {
		data = YamlConfiguration.loadConfiguration(dfile);

		cfile = new File(p.getDataFolder(), "config.yml");
		dfile = new File(p.getDataFolder(), "data.yml");

		config = p.getConfig();
		// config.options().copyDefaults(true);
		// saveConfig();

		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();

		}

		if (!dfile.exists()) {
			try {
				dfile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data.yml!");
			}
		}
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
		}
	}

	public void saveConfig() {
		try {
			config.save(cfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
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
}