package edu.umb.cs680.hw06;

public class DrawerOpen implements State {
	
	public static final DrawerOpen instance = new DrawerOpen();
	
	public static DrawerOpen getInstance() {
		return instance;
	}
	
	public void openCloseButtonPushed() {
		player.close();
		player.changeState(DrawerClosedNotPlaying.getInstance());
		
	}
	
	public void playButtonPushed() {
		player.close();
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());
	}
	
	public void stopButtonPushed() {
		
	}
}
