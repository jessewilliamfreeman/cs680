package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State {
	
	public static final DrawerClosedNotPlaying instance = new DrawerClosedNotPlaying();
	
	public static DrawerClosedNotPlaying getInstance() {
		return instance;
	}
	
	public void openCloseButtonPushed() {
		player.open();
		player.changeState(DrawerOpen.getInstance());
	}
	
	public void playButtonPushed() {
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());
	}
	
	public void stopButtonPushed() {
		
	}
}