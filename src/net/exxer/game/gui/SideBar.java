package net.exxer.game.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import net.exxer.game.Handler;

public class SideBar extends GUI{
	
	private Rectangle buildButton = new Rectangle();
	private int buildX = handler.getWidth();//(int) (handler.getWidth() * 0.05);
	private int buildY = handler.getWidth();//(int) (handler.getHeight() * 0.10) * 2;
	private int buildW = (int) (handler.getWidth() * 0.05) + 300;//plus width and height
	private int buildH = (int) (handler.getHeight() * 0.07);
	private boolean buildHighlight = false;
	
	public SideBar(Handler handler) {
		super(handler);
		System.out.println(handler.getWidth());
	}
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int) (handler.getWidth() * 0.15), handler.getHeight());
		//Build
		if(buildHighlight){
			g.setColor(Color.orange);
		}else{
			g.setColor(Color.MAGENTA);
		}
		g.fillRect(buildX, buildY, 400, 70);
		g.setColor(Color.DARK_GRAY);
		g.drawString("Load Game", buildX, buildY + 60);
	}
	public void update() {
		
	}
}
