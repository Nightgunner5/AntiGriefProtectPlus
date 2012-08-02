package net.llamaslayers.bukkit.antigriefprotectplus;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	@Override
	public void onDisable() {
		// TODO: Place any custom disable code here.
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents( this, this );
	}

	@EventHandler
	public void onPlayerJoin( PlayerJoinEvent event ) {
		event.getPlayer().sendMessage( "Welcome, " + event.getPlayer().getDisplayName() + "!" );
	}

}
