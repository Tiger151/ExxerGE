package net.exxer.game.worlds;

import java.awt.Graphics2D;

import org.json.JSONObject;

import net.exxer.game.Handler;
import net.exxer.game.entities.tiles.Tile;
import net.exxer.game.utils.Utils;

public class World {
	private Handler handler;
	private int width , height;
	private int spX, spY;
	private int [][] tiles;
	
	public World(Handler handler, String path){
		loadWorld(path);
		this.handler = handler;
	}
	
	public void update(){
		
	}
	
	public void render(Graphics2D g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOff() / Tile.TILEWIDTH );
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOff() + handler.getWidth()) / Tile.TILEWIDTH) +1;//debug for loading
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOff() / Tile.TILEHEIGHT );
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOff() + handler.getHeight()) / Tile.TILEHEIGHT) + 1;//debug for loading

		for(int y = yStart; y < yEnd;y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOff()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOff()));
			}
		}
	}
	
	public Tile getTile(int x, int y){
		//System.out.println("------------------------------------------- ");
		if(x < 0 || y < 0 || x >= width || y >= height){
			return Tile.grass;//make a void tile
		}
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null){
			return Tile.water;
		}else{
			//System.out.println(t.getID());
			return t;
		}
		
	}
	
	private void loadWorld(String path){//make path instead a file name so that it can reference both files 
		//System.out.println(path);
		JSONObject prop = new JSONObject(Utils.loadFileAsString(path + "world.json"));//make part of supers
		width = Utils.parseInt(prop.getJSONObject("map").getString("xdimen"));
		height = Utils.parseInt(prop.getJSONObject("map").getString("ydimen"));
		spX = Utils.parseInt(prop.getJSONObject("mobs").getJSONObject("player").getString("xstart"));
		spY = Utils.parseInt(prop.getJSONObject("mobs").getJSONObject("player").getString("ystart"));
		String file = Utils.loadFileAsString(path + "world.csv");
		String[] tokens = file.split(",");
		tiles = new int[width][height];
		for(int y = 0; y < height ; y++){
			for(int x = 0; x < width ; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width)]);
				//System.out.println("x: " + x + "y: " + y  + " Type:" +tiles[x][y]);
			}
		}
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}