package net.exxer.game.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	public SpriteSheet(BufferedImage sh){
		this.sheet = sh;
	}
	public BufferedImage crop(int x, int y, int w, int h){
		return sheet.getSubimage(x, y, w, h);
	}
}
