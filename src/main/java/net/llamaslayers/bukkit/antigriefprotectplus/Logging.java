package net.llamaslayers.bukkit.antigriefprotectplus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

class Logging implements Listener {
	private final File logdir;
	private final Logger logger;

	Logging( Main plugin ) {
		logdir = new File( plugin.getDataFolder(), "logs" );
		logdir.mkdirs();
		logger = plugin.getLogger();
	}

	@EventHandler
	public void onBlockPlace( BlockPlaceEvent event ) {
		log( "A block was placed", event.getPlayer(), event.getBlockPlaced().getLocation(), event.getBlockPlaced().getType() );
	}

	@EventHandler
	public void onBlockBreak( BlockBreakEvent event ) {
		log( "A block was broken", event.getPlayer(), event.getBlock().getLocation(), event.getBlock().getType() );
	}

	private void log( String message, Object... args ) {
		try {
			FileOutputStream file = new FileOutputStream( new File( logdir, String.format( "log-%tF.log", System.currentTimeMillis() ) ), true );

			file.write( String.format( "%tF %tT %s \n", System.currentTimeMillis(), System.nanoTime(), message, args ).getBytes() );

			// Don't forget to close the file!
			file.close();
		} catch ( IOException ex ) {
			logger.info( "IOException" );
		}
	}

}
