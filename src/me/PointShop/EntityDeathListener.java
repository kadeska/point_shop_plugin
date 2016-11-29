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

		// if the entity that died is not a player and the entity killer is a
		// player then add one to score
		if (e.getEntity().getType() != EntityType.PLAYER && e.getEntity().getKiller() instanceof Player) {
			Managers.addScore(p, 1);

		}

		// if the entity that died is a player and the entity killer is a
		// player then remove one from score
		if (e.getEntity().getType() == EntityType.PLAYER && e.getEntity().getKiller() instanceof Player) {
			Managers.removeScore(p, 1);

		}

	}

}
