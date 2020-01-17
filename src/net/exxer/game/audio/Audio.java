package net.exxer.game.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import net.exxer.game.Handler;

public class Audio{
	private Clip audioClip;
	private AudioInputStream aIn;
	private Handler handler;
	private String path;
	public Audio(Handler handler, String path) {
		this.handler = handler;
		this.path = path;
	}
	public void play() {
		try {
			aIn = AudioSystem.getAudioInputStream(new File(path));
			audioClip = AudioSystem.getClip();
			audioClip.open(aIn);
			//audioClip.addLineListener(this);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		audioClip.start();
	}
	public void close() throws IOException {
		audioClip.close();
		aIn.close();
	}
	public void stop(){
		audioClip.stop();
	}
}