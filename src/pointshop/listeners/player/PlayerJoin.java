package pointshop.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pointshop.Main;

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
