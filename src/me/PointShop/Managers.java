package me.PointShop;

import org.bukkit.entity.Player;

public class Managers {

	public static void addScore(Player p, int i) {
		if (!Main.getPlugin().getConfig().contains("Players." + p.getName() + p.getUniqueId())) {
			Main.getPlugin().getConfig().set("Players." + p.getName() + p.getUniqueId() + ".Score", i++);
			Main.getPlugin().saveConfig();
		} else {
			Main.getPlugin().getConfig().set("players." + p.getName() + p.getUniqueId() + ".Score", 1);
		}
	}

	public static int getScore(Player p) {
		return Main.getPlugin().getConfig().getInt("Players." + p.getUniqueId() + ".Score");
	}

	public static void removeScore(Player p, int i) {
		if (!Main.getPlugin().getConfig().contains("Players." + p.getName() + p.getUniqueId())) {
			Main.getPlugin().getConfig().set("Players." + p.getName() + p.getUniqueId() + ".Score", i--);
			Main.getPlugin().saveConfig();
		} else {
			Main.getPlugin().getConfig().set("players." + p.getName() + p.getUniqueId() + ".Score", 0);
		}
	}

}
