package me.PointShop;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		if (!Main.getPlugin().getConfig().contains("Players." + p.getName())) {
			Main.getPlugin().getConfig().set("players." + p.getName() + ".Score", 0);
			Main.getPlugin().saveConfig();

		}
	}

}
