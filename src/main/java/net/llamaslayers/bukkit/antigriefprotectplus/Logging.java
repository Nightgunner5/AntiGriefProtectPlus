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
		log( new String( "A block was placed" ), event.getPlayer(), event.getBlockPlaced().getLocation(), event.getBlockPlaced().getType() );
	}

	@EventHandler
	public void onBlockBreak( BlockBreakEvent event ) {
		log( new String( "A block was broken" ), event.getPlayer(), event.getBlock().getLocation(), event.getBlock().getType() );
	}

	private void log( String message, Object... args ) {
		try {
			String logName = new String();
			logName += new String( String.format( "%s-", "log" ) );
			logName += new String( String.format( new String( "%tF" ), System.currentTimeMillis() ) );
			logName += new String( String.format( ".%s", "log" ) );
			FileOutputStream file = new FileOutputStream( new File( logdir, logName ), true );

			String toWrite = new String();
			toWrite += new String( String.format( "%tF", System.currentTimeMillis() ) );
			toWrite += new String( String.format( "%s", " " ) );
			toWrite += new String( String.format( "%tT", System.nanoTime() ) );
			toWrite += new String( String.format( " ", " " ) );
			toWrite += new String( String.format( "%s", message, args ) );

			for ( byte b : toWrite.getBytes() ) {
				file.write( b );
			}

			// Don't forget to close the file!
			file.close();
		} catch ( IOException ex ) {
			logger.info( "IOException" );
		}
	}

}
