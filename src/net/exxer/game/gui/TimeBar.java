package net.exxer.game.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import net.exxer.game.logic.Date;

import net.exxer.game.Handler;

public class TimeBar extends GUI{
	private Date date;
	public TimeBar(Handler handler){
		super(handler);
		date = new Date(handler);
		
		
	}
	public void render(Graphics2D g){
		//TODO: add json file to handle GUI elements
		int startX = (int) (handler.getWidth() * 0.15);
		int startY = (int) (handler.getHeight() * 0.8);
		int guiWidth = (int) (handler.getWidth() * 0.85); 
		int guiHeight = (int) (handler.getHeight() * 0.2 );
		g.setColor(Color.WHITE);
		g.fillRect(startX, startY, guiWidth, guiHeight);
		g.setColor(Color.BLACK);
		Font fontNews = new Font("Arial", Font.PLAIN & Font.BOLD,  20);
		g.setFont(fontNews);
		//g.drawString("This is a menu", startX + (int) (guiWidth / 2), startY + (int) (guiHeight /2));
		g.drawString("Day#: " + Integer.toString(date.getDay()), startX + (int)(handler.getWidth() * 0.01) , startY + (int) ((guiHeight / 2)));
		g.drawString((date.getDateName(date.getDay()) + ": " + date.getDateEvent(date.getDay())), startX + (int)(handler.getWidth() * 0.01) , startY + (int) ((guiHeight / 4)));
		Font fontDate = new Font("Arial", Font.PLAIN & Font.BOLD,  30);
		g.setFont(fontDate);
		g.drawString(date.getDateName(date.getDay()), startX + (int) (guiWidth * 0.8), startY + (int) ((guiHeight / 4)));
		g.setStroke(new BasicStroke(5));
		g.drawLine(startX, startY, handler.getWidth(), startY);
		g.drawLine(startX, startY, startX, handler.getHeight());
		g.drawLine(startX + (int) (guiWidth * 0.79), startY, startX + (int) (guiWidth * 0.79), handler.getHeight());
	}
	public void update(){
		
		date.update();
	}
}
