package net.exxer.game.gfx;

import net.exxer.game.Handler;
import net.exxer.game.entities.Entity;
import net.exxer.game.entities.tiles.Tile;

public class GameCamera {
	private Handler handler;
	private float xOff, yOff;
	public GameCamera(Handler handler, float xOff, float yOff){
		this.xOff = xOff;
		this.yOff = yOff;
		this.handler = handler;
	}
	
	public void checkVoid(){
		if(xOff < 0){
			xOff = 0;
		}else if(xOff > handler.getWorld().getWidth() * Tile.TILEWIDTH  - handler.getWidth()){
			xOff = (handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth());
		}
		if(yOff < 0){
			yOff = 0;
		}else if(yOff > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
			yOff = (float) (handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight());
		}
	}
	
	public void centerOnEntity(Entity e){
		xOff = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOff = e.getY() - handler.getHeight() /2 + e.getHeight() / 2;
		checkVoid();
	}
	
	public void move(float xAmt, float yAmt){
		xOff += xAmt;
		yOff += yAmt;
		checkVoid();
	}
	
	public float getxOff() {
		return xOff;
	}
	public void setxOff(float xOff) {
		this.xOff = xOff;
		//checkVoid();
	}
	public float getyOff() {
		return yOff;
	}
	public void setyOff(float yOff) {
		this.yOff = yOff;
		//checkVoid();
	}
}
