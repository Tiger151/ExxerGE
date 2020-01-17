package net.exxer.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int w = 32, h = 32;
	public static BufferedImage sixteen, thirty_two, grass, tree, water, rock, blackBaller;
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/TileSet.png"));
		//debug tiles
		sixteen = sheet.crop((w * 11), (h * 11), w, h);
		blackBaller = sheet.crop((w * 2), (h * 14), w, h);
		//thirty_two = sheet.crop(16, 0, 32, 32);
		//game tiles
		grass = sheet.crop(0, h, w, h);//could do something like width * 3 or height * 2
		tree = sheet.crop((w * 2), (h * 7), w, h);
		water = sheet.crop((w * 2), (h * 11), w, h);
		rock = sheet.crop((w * 6), (h * 10), w, h);// -1 because of missaligning
	
	}
}
