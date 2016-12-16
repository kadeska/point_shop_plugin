package pointshop.managers;

import org.bukkit.entity.Player;
import pointshop.Main;

public class ScoreManager {

	private static Main plugin;

	public ScoreManager(Main plugin) {
		this.plugin = plugin;
	}

	public static void addScore(Player p, int i) {
		int score = plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score");
		if (!plugin.getConfig().contains("Players." + p.getName() + ".UUID" + p.getUniqueId() + ".Score")) {
			plugin.getConfig().set("Players." + p.getName() + ".UUID" + p.getUniqueId() + ".Score", 0);
			plugin.saveConfig();
		} else {
			plugin.getConfig().set("players." + p.getName() + ".UUID" + p.getUniqueId() + ".Score", score + i);
			plugin.saveConfig();
		}
	}

	public static int getScore(Player p) {
		return plugin.getConfig().getInt("Players." + p.getName() + ".UUID" + p.getUniqueId() + ".Score");
	}

	public static void removeScore(Player p, int i) {
		int score = plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score");
		if (!plugin.getConfig().contains("Players." + p.getName() + ".UUID" + p.getUniqueId() + ".Score")) {
			plugin.getConfig().set("Players." + p.getName() + ".UUID" + p.getUniqueId() + ".Score", 0);
			plugin.saveConfig();
		} else {
			plugin.getConfig().set("players." + p.getName() + ".UUID" + p.getUniqueId() + ".Score", score - i);
			plugin.saveConfig();
		}
	}

}
