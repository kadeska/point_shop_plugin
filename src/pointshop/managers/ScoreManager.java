package pointshop.managers;

import java.io.File;
import org.bukkit.entity.Player;
import pointshop.Main;
import pointshop.utils.SettingsManager;

public class ScoreManager extends SettingsManager{
	public ScoreManager(File dfile, String playername) {
		super(dfile, playername);
		// TODO Auto-generated constructor stub
	}

	private static Main plugin;
	private SettingsManager settingsManager;
	
	public SettingsManager settingsManager() {
		return settingsManager;
	}
	

	public static void addScore(Player p, int i) {
		int score = plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score");
		if (!plugin.getConfig().contains("Players." + p.getName() + ".UUID." + p.getUniqueId() + ".Score")) {
			plugin.getConfig().set("Players." + p.getName() + ".UUID." + p.getUniqueId() + ".Score", 0);
			plugin.saveConfig();
		} else {
			plugin.getConfig().set("players." + p.getName() + ".UUID." + p.getUniqueId() + ".Score", score + i);
			plugin.saveConfig();
		}
	}

	public static int getScore(Player p) {
		return plugin.getConfig().getInt("Players." + p.getName() + ".UUID." + p.getUniqueId() + ".Score");
	}

	public static void removeScore(Player p, int i) {
		int score = plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score");
		if (!plugin.getConfig().contains("Players." + p.getName() + ".UUID." + p.getUniqueId() + ".Score")) {
			plugin.getConfig().set("Players." + p.getName() + ".UUID." + p.getUniqueId() + ".Score", 0);
			plugin.saveConfig();
		} else {
			plugin.getConfig().set("players." + p.getName() + ".UUID. " + p.getUniqueId() + ".Score", score - i);
			plugin.saveConfig();
		}
	}

	public File getDfile() {
		return settingsManager.dfile;
	}

	//public ScoreManager(Main plugin) {
		//ScoreManager.plugin = plugin;
	//}
}
