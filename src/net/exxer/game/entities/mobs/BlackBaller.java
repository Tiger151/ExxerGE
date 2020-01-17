package net.exxer.game.entities.mobs;

import java.awt.Graphics2D;
import java.util.Random;

import net.exxer.game.Handler;
import net.exxer.game.entities.tiles.Tile;
import net.exxer.game.gfx.Assets;

public class BlackBaller extends Mob{

	public BlackBaller(Handler handler, float x, float y) {
		super(handler, x, y, Mob.DEFAULT_MOB_W, Mob.DEFAULT_MOB_HEIGHT);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32 * SCALE;
		bounds.height = 32 * SCALE;
	}

	@Override
	public void update() {
		Random rnd = new Random();
		//int shouldMove = 0;//test for randomization
		xMove = rnd.nextInt(3) + 1;
		yMove = rnd.nextInt(3) + 1;
		move();
		
	}

	@Override
	public void render(Graphics2D g) {
		
		g.drawImage(Assets.blackBaller, (int) (x - handler.getGameCamera().getxOff()), (int) (y- handler.getGameCamera().getyOff()), width, height, null);
		//g.drawImage(Assets.blackBaller, 10, 10, width, height, null); <<________________This makes a hud
		
	}

}
