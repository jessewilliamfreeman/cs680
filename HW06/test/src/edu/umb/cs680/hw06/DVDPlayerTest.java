package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

class DVDPlayerTest {

	@Test
	public void DrawerOpenAndOpenCloseButtonPushed() {
		DVDPlayer             player      = DVDPlayer.getInstance();
		ByteArrayOutputStream baos        = new ByteArrayOutputStream();
		PrintStream           printStream = new PrintStream(baos);
		
		player.setPrintStream(printStream);
		player.changeState(DrawerOpen.getInstance());
		
		String expected = "Open/Close Button Pushed..."
				+ System.lineSeparator()
				+ "Closing DVDPlayer..."
				+ System.lineSeparator();
		
		player.openCloseButtonPushed();
		// Reseting to System.out
		player.setPrintStream(System.out);
		
		assertEquals(expected, baos.toString());
	}
	
	@Test
	public void DrawerOpenAndPlayButtonPushed() {
		DVDPlayer             player      = DVDPlayer.getInstance();
		ByteArrayOutputStream baos        = new ByteArrayOutputStream();
		PrintStream           printStream = new PrintStream(baos);
		
		player.setPrintStream(printStream);
		player.changeState(DrawerOpen.getInstance());
		
		String expected = "Play Button Pushed..."
				+ System.lineSeparator()
				+ "Closing DVDPlayer..."
				+ System.lineSeparator()
				+ "Playing DVD..."
				+ System.lineSeparator();
		
		player.playButtonPushed();
		// Reseting to System.out
		player.setPrintStream(System.out);
		
		assertEquals(expected, baos.toString());
	}
	
	@Test
	public void DrawerOpenAndStopButtonPushed() {
		DVDPlayer             player      = DVDPlayer.getInstance();
		ByteArrayOutputStream baos        = new ByteArrayOutputStream();
		PrintStream           printStream = new PrintStream(baos);
		
		player.setPrintStream(printStream);
		player.changeState(DrawerOpen.getInstance());
		
		String expected = "Stop Button Pushed..."
				+ System.lineSeparator();
		
		player.stopButtonPushed();
		// Reseting to System.out
		player.setPrintStream(System.out);
		
		assertEquals(expected, baos.toString());
	}
	
	@Test
	public void DrawerClosedPlayingAndOpenCloseButtonPushed() {
		DVDPlayer             player      = DVDPlayer.getInstance();
		ByteArrayOutputStream baos        = new ByteArrayOutputStream();
		PrintStream           printStream = new PrintStream(baos);
		
		player.setPrintStream(printStream);
		player.changeState(DrawerClosedPlaying.getInstance());
		
		String expected = "Open/Close Button Pushed..."
				+ System.lineSeparator()
				+ "Stopping DVD..."
				+ System.lineSeparator()
				+ "Opening DVDPlayer..."
				+ System.lineSeparator();
		
		player.openCloseButtonPushed();
		// Reseting to System.out
		player.setPrintStream(System.out);
		
		assertEquals(expected, baos.toString());
	}
	
	@Test
	public void DrawerClosedPlayingAndPlayButtonPushed() {
		DVDPlayer             player      = DVDPlayer.getInstance();
		ByteArrayOutputStream baos        = new ByteArrayOutputStream();
		PrintStream           printStream = new PrintStream(baos);
		
		player.setPrintStream(printStream);
		player.changeState(DrawerClosedPlaying.getInstance());
		
		String expected = "Play Button Pushed..."
				+ System.lineSeparator();
		
		player.playButtonPushed();
		// Reseting to System.out
		player.setPrintStream(System.out);
		
		assertEquals(expected, baos.toString());
	}
	
	@Test
	public void DrawerClosedPlayingAndStopButtonPushed() {
		DVDPlayer             player      = DVDPlayer.getInstance();
		ByteArrayOutputStream baos        = new ByteArrayOutputStream();
		PrintStream           printStream = new PrintStream(baos);
		
		player.setPrintStream(printStream);
		player.changeState(DrawerClosedPlaying.getInstance());
		
		String expected = "Stop Button Pushed..."
				+ System.lineSeparator()
				+ "Stopping DVD..."
				+ System.lineSeparator();
		
		player.stopButtonPushed();
		// Reseting to System.out
		player.setPrintStream(System.out);
		
		assertEquals(expected, baos.toString());
	}
	
	@Test
	public void DrawerClosedNotPlayingAndOpenCloseButtonPushed() {
		DVDPlayer             player      = DVDPlayer.getInstance();
		ByteArrayOutputStream baos        = new ByteArrayOutputStream();
		PrintStream           printStream = new PrintStream(baos);
		
		player.setPrintStream(printStream);
		player.changeState(DrawerClosedNotPlaying.getInstance());
		
		String expected = "Open/Close Button Pushed..."
				+ System.lineSeparator()
				+ "Opening DVDPlayer..."
				+ System.lineSeparator();
		
		player.openCloseButtonPushed();
		// Reseting to System.out
		player.setPrintStream(System.out);
		
		assertEquals(expected, baos.toString());
	}
	
	@Test
	public void DrawerClosedNotPlayingAndPlayButtonPushed() {
		DVDPlayer             player      = DVDPlayer.getInstance();
		ByteArrayOutputStream baos        = new ByteArrayOutputStream();
		PrintStream           printStream = new PrintStream(baos);
		
		player.setPrintStream(printStream);
		player.changeState(DrawerClosedNotPlaying.getInstance());
		
		String expected = "Play Button Pushed..."
				+ System.lineSeparator()
				+ "Playing DVD..."
				+ System.lineSeparator();
		
		player.playButtonPushed();
		// Reseting to System.out
		player.setPrintStream(System.out);
		
		assertEquals(expected, baos.toString());
	}
	
	@Test
	public void DrawerClosedNotPlayingAndStopButtonPushed() {
		DVDPlayer             player      = DVDPlayer.getInstance();
		ByteArrayOutputStream baos        = new ByteArrayOutputStream();
		PrintStream           printStream = new PrintStream(baos);
		
		player.setPrintStream(printStream);
		player.changeState(DrawerClosedNotPlaying.getInstance());
		
		String expected = "Stop Button Pushed..."
				+ System.lineSeparator();
		
		player.stopButtonPushed();
		// Reseting to System.out
		player.setPrintStream(System.out);
		
		assertEquals(expected, baos.toString());
	}

}
