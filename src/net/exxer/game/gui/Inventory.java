package net.exxer.game.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import net.exxer.game.Handler;

public class Inventory extends GUI{
	public Inventory(Handler handler){
		super(handler);
	}
	public void render(Graphics2D g){ 
		int startX = (int) (handler.getWidth() * 0.2);
		int startY = (int) (handler.getHeight() * 0.2);
		int guiWidth = (int) (handler.getWidth() *0.6); 
		int guiHeight = (int) (handler.getHeight() *0.6);
		g.setColor(Color.WHITE);
		g.fillRect(startX, startY, guiWidth, guiHeight);
		g.setColor(Color.BLACK);
		g.drawString("This is a menu", startX + (int) (guiWidth / 2), startY + (int) (guiHeight /2));
	}
	public void update(){
		
	}
}
