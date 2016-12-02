package me.kadeska.pointshop.listeners.player;

import me.kadeska.pointshop.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	private Main plugin;
	public PlayerJoin(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		if (!plugin.getConfig().contains("Players." + p.getName())) {
			plugin.getConfig().set("players." + p.getName() + ".Score", 0);
			plugin.saveConfig();

		}
	}

}
