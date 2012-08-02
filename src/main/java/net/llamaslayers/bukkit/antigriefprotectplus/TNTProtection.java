package net.llamaslayers.bukkit.antigriefprotectplus;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class TNTProtection implements Listener {
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if ( event.getBlock().getType() == Material.TNT ) {
			// Do not allow TNT
			event.setCancelled( true );
		}
	}
}
