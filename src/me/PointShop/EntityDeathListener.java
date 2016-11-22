package me.PointShop;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathListener implements Listener {

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {

		Player p = e.getEntity().getKiller();

		if (e.getEntity().getType() != EntityType.PLAYER) {
			if (e.getEntity().getKiller() instanceof Player) {
				Managers.addScore(p, 1);
			}
		}

	}

}
