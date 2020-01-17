package net.exxer.game.entities.mobs;

import java.awt.Color;
import java.awt.Graphics2D;

import net.exxer.game.Handler;
import net.exxer.game.gfx.Assets;
import net.exxer.game.gui.Inventory;
import net.exxer.game.state.ScreenState;

public class Player extends Mob{
	private Inventory inventory;
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Mob.DEFAULT_MOB_W, Mob.DEFAULT_MOB_HEIGHT);
		//hit marker or aka bound box all bases off of 32x32 for ex 12+20 = 32 so it looks equal
		bounds.x = 12;
		bounds.y = 6;
		bounds.width = 20 * SCALE;
		bounds.height = 26 * SCALE;
		inventory = new Inventory(handler);
	}

	@Override
	public void update(){
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		if(handler.isPlayerInvShown()){
			inventory.update();
		}
	}
	
	private void getInput(){
		xMove =0;
		yMove = 0;
		//<<<<<---------------------------------------------Shut Off the WASD here!!!!!!!
		/*if(handler.getKeyManager().up){
			yMove = -speed;
		}
		if(handler.getKeyManager().down){
			yMove = speed;
		}
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
		if(handler.getKeyManager().right){
			xMove = speed;
		}*/
		if(handler.getKeyManager().escape){
			//System.out.println((int)(handler.getGameCamera().getxOff() * handler.getGameCamera().getyOff()));
			//esc menu here
			
			//temp back to main menu
			ScreenState.setState(handler.getGame().getMenuState());
			handler.setPaused(true);
			handler.getGame().getDisplay().getCanvas().addMouseListener(handler.getGame().getMenuState());
			handler.getGame().getDisplay().getCanvas().addMouseMotionListener(handler.getGame().getMenuState());
			
		}
		if(handler.getKeyManager().i){
			boolean isOpen = true;
			if(isOpen){
				handler.closePlayerInv();
				isOpen = false;
			}else{
				handler.openPlayerInv();
				isOpen = true;
			}	
		}
		
		if(handler.getKeyManager().pause) {
			handler.togglePause();
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(Assets.sixteen, (int) (x - handler.getGameCamera().getxOff()), (int) (y- handler.getGameCamera().getyOff()), width, height, null);
		g.setColor(Color.CYAN);//use to see hit marker or aka bound box DEBUG MODE 
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOff()), (int) (y + bounds.y - handler.getGameCamera().getyOff()), bounds.width, bounds.height);
		if(handler.isPlayerInvShown()){
			inventory.render(g);
		}
		//- game.getGameCamera().getxOff()  this is used to center the camera on the player
	}

}
