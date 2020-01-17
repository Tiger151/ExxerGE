package net.exxer.game.input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import net.exxer.game.Handler;
public class KeyManager implements KeyListener{
	private boolean useWASD = false;
	private boolean[] keys;
	public boolean up, down, right, left, escape, i, pause;
	private Handler handler;
	public KeyManager(Handler handler){
		keys = new boolean[256];
		this.handler = handler;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;//Interesting
		//System.out.println("Pressed"); //DEBUG LOG
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void Update(){
		if(useWASD){//OPTIONS
			up = keys[KeyEvent.VK_W];
			down = keys[KeyEvent.VK_S];
			left = keys[KeyEvent.VK_A];
			right = keys[KeyEvent.VK_D];
		}else{
			up = keys[KeyEvent.VK_UP];
			down = keys[KeyEvent.VK_DOWN];
			left = keys[KeyEvent.VK_LEFT];
			right = keys[KeyEvent.VK_RIGHT];
		}
		escape = keys[KeyEvent.VK_ESCAPE];
		i = keys[KeyEvent.VK_I];
		pause = keys[KeyEvent.VK_PAUSE];
	}
	

}
