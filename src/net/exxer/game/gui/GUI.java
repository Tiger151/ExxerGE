package net.exxer.game.gui;

import java.awt.Graphics2D;

import net.exxer.game.Handler;

public abstract class GUI {
	protected Handler handler;
	public GUI(Handler handler) {
		this.handler = handler;
	}
	public abstract void update();
	public abstract void render(Graphics2D g);
}
