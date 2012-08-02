package net.llamaslayers.bukkit.antigriefprotectplus;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		FileConfiguration config = getConfig();

		config.addDefault( "tnt_protection", true );
		if ( config.getBoolean( "tnt_protection" ) ) {
			getServer().getPluginManager().registerEvents( new TNTProtection(), this );
			getLogger().info( "TNT Protection module enabled" );
		}

		config.addDefault( "mob_management", true );
		if ( config.getBoolean( "mob_management" ) ) {
			getServer().getPluginManager().registerEvents( new MobManagement(), this );
			getLogger().info( "Mob Management module enabled" );
		}

		config.addDefault( "logging", true );
		if ( config.getBoolean( "logging" ) ) {
			getServer().getPluginManager().registerEvents( new Logging(), this );
			getLogger().info( "Logging module enabled" );
		}

		// Save the configuration so if any options were missing the defaults
		// will be filled in.
		saveConfig();
	}
}
