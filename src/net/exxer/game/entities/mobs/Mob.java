package net.exxer.game.entities.mobs;

import net.exxer.game.Handler;
import net.exxer.game.entities.Entity;
import net.exxer.game.entities.tiles.Tile;

public abstract class Mob extends Entity{
	public static final int SCALE = 2;
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_MOB_W	 = 32 * SCALE, DEFAULT_MOB_HEIGHT = 32 * SCALE;
	//include attributes to mobs here
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public Mob(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move(){
		moveX();
		moveY();
	}
	
	public void moveX(){
		if(xMove > 0){//move right GOOD
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collsionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collsionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT )){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}else if(xMove < 0){//move left GOOD
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEHEIGHT;
			if(!collsionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collsionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT )){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	public void moveY(){
		if(yMove < 0){//up GOOD
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if(!collsionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && !collsionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}else if(yMove > 0){//down GOOD
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collsionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && !collsionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	protected boolean collsionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();	
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
