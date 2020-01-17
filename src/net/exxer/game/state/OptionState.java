package net.exxer.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;


import net.exxer.game.Handler;

public class OptionState extends ScreenState{
	
	
	private Rectangle backButton = new Rectangle();
	private int backX = (int) (handler.getWidth() * 0.05);
	private int backY = (int) (handler.getHeight() * 0.10) * 4;
	private int backW = (int) (handler.getWidth() * 0.05) + 300;//plus width and height
	private int backH = (int) (handler.getHeight() * 0.07);
	
	
	private boolean backHightlight = false;
	public OptionState(Handler handler) {
		super(handler);
		
		backButton.setBounds(backX, backY, backW, backH);
		handler.getGame().getDisplay().getCanvas().addMouseListener(this);
		handler.getGame().getDisplay().getCanvas().addMouseMotionListener(this);
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics2D g) {//make a class later to simplify this
		g.setFont(new Font("Arial", Font.BOLD, 72));
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		//g.drawImage(Assets.rock, 0, 0, null);
		
	   
		//exit
		if(backHightlight){
			g.setColor(Color.orange);
		}else{
			g.setColor(Color.MAGENTA);
		}
		g.fillRect(backX, backY, 400, 70);
		g.setColor(Color.DARK_GRAY);
		g.drawString("Back", backX, backY + 60);
		//g.setFont(new Font("Arial", Font.BOLD, 20));
		//g.drawString("Version Alpha 0.0.1.0, \u00a9 Exxer, www.Exxer.net" , versionCopyW, versionCopyH);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Click Detected");
		//new game
		/*if(newGameButton.contains(e.getPoint())){//switch states here
			handler.getAudioManager().buttonClick.play();
			System.out.println("Going to game state");
			handler.getGame().getDisplay().getCanvas().removeMouseListener(this);
			handler.getGame().getDisplay().getCanvas().removeMouseMotionListener(this);
			super.setState(handler.getGame().getGameState());
			
		}*/
	
		//exit
		if(backButton.contains(e.getPoint())){//switch states here
			handler.getAudioManager().buttonClick.play();
			//System.out.println("exiting");
			//PUT LOGIC TO NOTIFY LEAVING UNSAVED SETTINGS
	
			handler.getGame().getDisplay().getCanvas().addMouseListener(handler.getGame().getMenuState());
			handler.getGame().getDisplay().getCanvas().addMouseMotionListener(handler.getGame().getMenuState());
			super.setState(handler.getGame().getMenuState());
		}
		
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		if(backButton.contains(e.getPoint())){
			//System.out.println("Hover on Exit");
			backHightlight = true;
		}else{
			backHightlight = false;
		}
	}
}
