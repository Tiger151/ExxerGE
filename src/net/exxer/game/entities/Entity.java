package net.exxer.game.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import net.exxer.game.Handler;

public abstract class Entity {
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	private final int SCALE = 2;
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public abstract void update();
	
	public abstract void render(Graphics2D g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
