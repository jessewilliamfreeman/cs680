package edu.umb.cs680.hw06;

import java.io.PrintStream;

public class DVDPlayer {
	
	private State state;
	private static final DVDPlayer instance = new DVDPlayer();
	
	// for testing
	private PrintStream printStream;
	
	private DVDPlayer() {
		this.printStream = System.out;
		this.state       = DrawerClosedNotPlaying.getInstance();
	}
	
	public static DVDPlayer getInstance() {

		return instance;
	}
			
	public void openCloseButtonPushed() {
		printStream.println("Open/Close Button Pushed...");
		state.openCloseButtonPushed();
	}
	
	public void playButtonPushed() {
		printStream.println("Play Button Pushed...");
		state.playButtonPushed();
	}
	
	public void stopButtonPushed() {
		printStream.println("Stop Button Pushed...");
		state.stopButtonPushed();
	}
	
	public void changeState(State state) {
		this.state = state;
	}
	
	public void open() {
		printStream.println("Opening DVDPlayer...");
	}
	
	public void close() {
		printStream.println("Closing DVDPlayer...");
	}
	
	public void play() {
		printStream.println("Playing DVD...");
	}
	
	public void stop() {
		printStream.println("Stopping DVD...");
	}
	
	// for testing
	protected void setPrintStream(PrintStream printStream) {
		this.printStream = printStream;
	}
}
