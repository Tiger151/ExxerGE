package net.exxer.game.entities.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {
	public static Tile[] tiles = new Tile[256];
	public static Tile grass = new GrassTile(0);//0 is this id
	public static Tile water = new WaterTile(1);
	public static Tile rock = new RockTile(2);
	public static Tile tree = new TreeTile(3);//assigned to something weird... a flower
	//https://www.youtube.com/watch?v=TlleDQFlTxA
	//public static final int TILEWIDTH = 16, TILEHEIGHT = 16; //currently tilesheet is 16x16 doing the following to make them 32x32 
	private final static int SCALE = 2;
	public static final int TILEWIDTH = 32 * SCALE, TILEHEIGHT = 32 * SCALE;
	protected BufferedImage texture;
	protected final int id;
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	public void update(){
		
	}
	public void render(Graphics2D g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH , TILEHEIGHT , null);
		//g.drawString("X:" + x/64 + "Y:"+ y/64 , x, y);
	}
	
	public boolean isSolid(){
		return false;
	}
	public int getID(){
		return id;
	}
}
