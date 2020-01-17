package net.exxer.game.state;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import net.exxer.game.Handler;
//import net.exxer.game.entities.mobs.BlackBaller;
import net.exxer.game.entities.mobs.Player;
import net.exxer.game.gui.SideBar;
//import net.exxer.game.gui.Inventory;
import net.exxer.game.gui.TimeBar;
//import net.exxer.game.worlds.World;

public class GameState extends ScreenState{
	private Player player;
	//private BlackBaller mob1;
	//private World testWorld;
	//private Inventory inventory;
	
	private TimeBar timeBar;
	private SideBar sideBar;
	
	
	public GameState(Handler handler){
		super(handler);
		//testWorld = new World(handler, "res/worlds/testworld/");
		//handler.setWorld(testWorld);
		player = new Player(handler, 500, 100);//Var's here are currently in pixels
		//mob1 = new BlackBaller(handler, 600, 100);
		//inventory = new Inventory(handler);
		
		timeBar = new TimeBar(handler);
		sideBar = new SideBar(handler);
		
		handler.setPaused(false);
	}
	@Override
	public void update() {
		if(!handler.isPaused()){
			//mob1.update();
			//testWorld.update();
			timeBar.update();
			sideBar.update();
		}
		player.update(); //player / controller needs to stay out of pause loop or player cannot unpause
		
	}

	@Override
	public void render(Graphics2D g) {
		//testWorld.render(g);
		//inventory.render(g);
		timeBar.render(g);
		sideBar.render(g);
		//mob1.render(g);
		player.render(g);//must make sure worlds load first// prob should have player loaded last
		//render menu or hud here so that it stays
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
