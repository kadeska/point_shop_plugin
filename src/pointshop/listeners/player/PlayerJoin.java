package pointshop.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pointshop.Main;
import pointshop.utils.SettingsManager;

public class PlayerJoin implements Listener {

	private Main plugin;
	public PlayerJoin(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Player p = e.getPlayer();
		String playername = p.getName();
		
		SettingsManager.loadPlayerdata(playername, p);
		
		
	}

}
