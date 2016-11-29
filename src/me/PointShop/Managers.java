package me.PointShop;

import org.bukkit.entity.Player;

public class Managers {

	public static void addScore(Player p, int i) {
		if (!Main.getPlugin().getConfig().contains("Players." + p.getName())) {
			Main.getPlugin().getConfig().set("Players." + p.getName() + ".Score", 0);
			Main.getPlugin().saveConfig();
		} else {
			Main.getPlugin().getConfig().set("players." + p.getName() + ".Score", i++);
		}
	}

	public static int getScore(Player p) {
		return Main.getPlugin().getConfig().getInt("Players." + p.getName() + ".Score");
	}

	public static void removeScore(Player p, int i) {
		if (!Main.getPlugin().getConfig().contains("Players." + p.getName())) {
			Main.getPlugin().getConfig().set("Players." + p.getName() + ".Score", 0);
			Main.getPlugin().saveConfig();
		} else {
			Main.getPlugin().getConfig().set("players." + p.getName() + ".Score", i--);
		}
	}

}
