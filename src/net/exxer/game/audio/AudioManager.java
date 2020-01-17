package net.exxer.game.audio;

import net.exxer.game.Handler;

public class AudioManager {
	private Handler handler;
	public Audio buttonClick;
	public AudioManager(Handler handler){
		this.handler = handler;
	}
	public void loadAll(){
		buttonClick = new Audio(handler, "res/audio/button_hover.wav");
		//load audio files needed
	}
	public void load(String load){
		//load a needed file
	}
	public void close(String close){
		//close files not needed
	}
	public void closeAll(){
		//close all files
	}
	//list Audio objects as sound files and play when given to do so
}
