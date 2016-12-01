package me.kadeska.pointshop.managers;

import me.kadeska.pointshop.Main;
import org.bukkit.entity.Player;

public class ScoreManager {

	private Main plugin;
	public ScoreManager(Main plugin) {
		this.plugin = plugin; //Accessing the instance of the Main class
	}

	/*
	All of it does not need to be static as it results in static abuse.
	 */

	public void addScore(Player p, int i) {
		if (!plugin.getConfig().contains("Players." + p.getName() + p.getUniqueId())) {
			plugin.getConfig().set("Players." + p.getName() + p.getUniqueId() + ".Score", i++);
			plugin.saveConfig();
		} else {
			plugin.getConfig().set("players." + p.getName() + p.getUniqueId() + ".Score", 1);
		}
	}

	public int getScore(Player p) {
		return plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score");
	}

	public void removeScore(Player p, int i) {
		if (!plugin.getConfig().contains("Players." + p.getName() + p.getUniqueId())) {
			plugin.getConfig().set("Players." + p.getName() + p.getUniqueId() + ".Score", i--);
			plugin.saveConfig();
		} else {
			plugin.getConfig().set("players." + p.getName() + p.getUniqueId() + ".Score", 0);
		}
	}

}
