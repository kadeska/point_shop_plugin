package pointshop.listeners.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import pointshop.managers.ScoreManager;

public class EntityDeath implements Listener {

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {

		//Here we check if the killer is instanceof Player, otherwise code would of broke if the killer was a creeper for example.
		if(!(e.getEntity().getKiller() instanceof Player)) {
			return;
		}

		//We can now safely cast the killer to Player
		Player player = e.getEntity().getKiller();

		// if the entity that died is not a player and the entity killer is a
		// player then add one to score
		if (e.getEntity().getType() != EntityType.PLAYER && e.getEntity().getKiller() instanceof Player) {
			ScoreManager.addScore(player, 1);

		}

		// if the entity that died is a player and the entity killer is a
		// player then remove one from score
		if (e.getEntity().getType() == EntityType.PLAYER && e.getEntity().getKiller() instanceof Player) {
			ScoreManager.removeScore(player, 1);

		}

	}

}
