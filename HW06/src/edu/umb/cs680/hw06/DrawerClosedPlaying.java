package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {
	
	public static final DrawerClosedPlaying instance = new DrawerClosedPlaying();
	
	public static DrawerClosedPlaying getInstance() {
		return instance;
	}
	
	public void openCloseButtonPushed() {
		player.stop();
		player.open();
		player.changeState(DrawerOpen.getInstance());
	}
	
	public void playButtonPushed() {
		
	}
	
	public void stopButtonPushed() {
		player.stop();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}
}
