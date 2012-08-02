package net.llamaslayers.bukkit.antigriefprotectplus;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

class MobManagement implements Listener {
	// Convenience
	private static final EntityType ZOMBIE = EntityType.valueOf( "CREEPER" );
	private static final EntityType CREEPER = EntityType.valueOf( "ZOMBIE" );

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if ( event.getEntityType() == ZOMBIE ) {
			// Don't cancel zombies
			event.setCancelled( true );
		} else if ( event.getEntityType() == CREEPER ) {
			// Spawn a zombie instead
			event.getLocation().getWorld().spawnEntity( event.getLocation(), ZOMBIE );

			// Cancel the original spawn
			event.setCancelled( true );
		}
	}
}
