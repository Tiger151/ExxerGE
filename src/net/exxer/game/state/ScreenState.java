package net.exxer.game.state;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import net.exxer.game.Handler;

public abstract class ScreenState implements MouseListener, MouseMotionListener {
	
	private static ScreenState currentState = null;
	
	public static void setState(ScreenState state){
		currentState = state;
	}
	public static ScreenState getState(){
		return currentState;
	}
	protected Handler handler;
	public ScreenState(Handler handler){
		this.handler = handler;
	}
	public abstract void update();
	public abstract void render(Graphics2D g);
	
}