package net.exxer.game;

import net.exxer.game.audio.AudioManager;
import net.exxer.game.gfx.GameCamera;
import net.exxer.game.input.KeyManager;
import net.exxer.game.logic.Date;
import net.exxer.game.state.ScreenState;
import net.exxer.game.worlds.World;

public class Handler {
	private Game game;
	private World world;
	private boolean isShowPlayerInv;
	private boolean paused;
	
	
	public Handler(Game game){
		this.game = game;
		isShowPlayerInv = false;
		
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	public AudioManager getAudioManager(){
		return game.getAudioManager();
	}
	//public MouseManagerDISABLED getMouseManager(){
	//	return game.getMouseManager();
//	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	public boolean isPlayerInvShown(){
		return isShowPlayerInv;
	}
	public void openPlayerInv(){
		isShowPlayerInv = true;
	}
	public void closePlayerInv(){
		isShowPlayerInv = false;
	}

	public boolean isPaused() {
		return paused;
	}

	public void togglePause() {
		if(paused) {
			paused = false;
		}else{
			paused = true;
		}
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
