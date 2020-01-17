package net.exxer.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;


import net.exxer.game.Handler;

public class MenuState extends ScreenState{
	private Rectangle newGameButton = new Rectangle();
	private int ngX = (int) (handler.getWidth() * 0.05);
	private int ngY = (int) (handler.getHeight() * 0.10);
	private int ngW = (int) (handler.getWidth() * 0.05) + 300;//plus width and height
	private int ngH = (int) (handler.getHeight() * 0.07);
	
	private Rectangle loadGameButton = new Rectangle();
	private int lgX = (int) (handler.getWidth() * 0.05);
	private int lgY = (int) (handler.getHeight() * 0.10) * 2;
	private int lgW = (int) (handler.getWidth() * 0.05) + 300;//plus width and height
	private int lgH = (int) (handler.getHeight() * 0.07);
	
	private Rectangle optionsButton = new Rectangle();
	private int oX = (int) (handler.getWidth() * 0.05);
	private int oY = (int) (handler.getHeight() * 0.10) * 3;
	private int oW = (int) (handler.getWidth() * 0.05) + 300;//plus width and height
	private int oH = (int) (handler.getHeight() * 0.07);
	
	private Rectangle exitButton = new Rectangle();
	private int eX = (int) (handler.getWidth() * 0.05);
	private int eY = (int) (handler.getHeight() * 0.10) * 4;
	private int eW = (int) (handler.getWidth() * 0.05) + 300;//plus width and height
	private int eH = (int) (handler.getHeight() * 0.07);
	
	private int versionCopyH = (int) (handler.getHeight() * 0.90);
	private int versionCopyW = (int) (handler.getWidth() * 0.10);
	private int disclaimer = (int) (handler.getHeight() * 0.95);
	
	private boolean newGameHighlight = false;
	private boolean loadGameHighlight = false;
	private boolean optionsHighlight = false;
	private boolean exitHighlight = false;
	public MenuState(Handler handler) {
		super(handler);
		newGameButton.setBounds(ngX, ngY, ngW, ngH);
		loadGameButton.setBounds(lgX, lgY, lgW, lgH);
		optionsButton.setBounds(oX, oY, oW, oH);
		exitButton.setBounds(eX, eY, eW, eH);
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
		
	   //new game
		if(newGameHighlight){
			g.setColor(Color.WHITE);
			g.fillRect(ngX, ngY, 400, 70);
			g.setColor(Color.BLACK);
			if(handler.isPaused()) {
				g.drawString("Resume", ngX, ngY + 60);
			}else {
				g.drawString("New Game", ngX, ngY + 60);
			}
		}else{
			g.setColor(Color.BLACK);
			g.fillRect(ngX, ngY, 400, 70);
			g.setColor(Color.WHITE);
			if(handler.isPaused()) {
				g.drawString("Resume", ngX, ngY + 60);
			}else {
				g.drawString("New Game", ngX, ngY + 60);
			}
		}
		
		
		//load game
		if(loadGameHighlight){
			g.setColor(Color.orange);
		}else{
			g.setColor(Color.MAGENTA);
		}
		g.fillRect(lgX, lgY, 400, 70);
		g.setColor(Color.DARK_GRAY);
		g.drawString("Load Game", lgX, lgY + 60);
		//options
		if(optionsHighlight){
			g.setColor(Color.orange);
		}else{
			g.setColor(Color.MAGENTA);
		}
		g.fillRect(oX, oY, 400, 70);
		g.setColor(Color.DARK_GRAY);
		g.drawString("Options", oX, oY + 60);
		//exit
		if(exitHighlight){
			g.setColor(Color.orange);
		}else{
			g.setColor(Color.MAGENTA);
		}
		g.fillRect(eX, eY, 400, 70);
		g.setColor(Color.DARK_GRAY);
		g.drawString("Exit", eX, eY + 60);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Version Alpha 0.0.2.0, \u00a9 Exxer, www.Exxer.net" , versionCopyW, versionCopyH);
		g.drawString("Tank Icon: www.ibrandify.com | JSON parser: www.json.org/license.html" , versionCopyW, disclaimer);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Click Detected");
		//new game
		if(newGameButton.contains(e.getPoint())){//switch states here
			handler.getAudioManager().buttonClick.play();
			//System.out.println("Going to game state");
			newGameHighlight = false;
			handler.setPaused(false);
			handler.getGame().getDisplay().getCanvas().removeMouseListener(this);
			handler.getGame().getDisplay().getCanvas().removeMouseMotionListener(this);
			super.setState(handler.getGame().getGameState());
			
		}
		//load game
		if(loadGameButton.contains(e.getPoint())){
			handler.getAudioManager().buttonClick.play();
			loadGameHighlight = false;
		}
		//options
		if(optionsButton.contains(e.getPoint())){
			handler.getAudioManager().buttonClick.play();
			//System.out.println("Going to game state");
			optionsHighlight = false;
			handler.getGame().getDisplay().getCanvas().removeMouseListener(this);
			handler.getGame().getDisplay().getCanvas().removeMouseMotionListener(this);
			super.setState(handler.getGame().getOptionState());
		}
		//exit
		if(exitButton.contains(e.getPoint())){//switch states here
			handler.getAudioManager().buttonClick.play();
			exitHighlight = false;
			//System.out.println("exiting");
			handler.getGame().getDisplay().getFrame().dispatchEvent(new WindowEvent(handler.getGame().getDisplay().getFrame(), WindowEvent.WINDOW_CLOSING));
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
		if(newGameButton.contains(e.getPoint())){
			//System.out.println("Hover on New Game");
			newGameHighlight = true;
		}else{
			newGameHighlight = false;
		}
		if(loadGameButton.contains(e.getPoint())){
			//System.out.println("Hover on Load Game");
			loadGameHighlight = true;
		}else{
			loadGameHighlight = false;
		}
		if(optionsButton.contains(e.getPoint())){
			//System.out.println("Hover on Options");
			optionsHighlight = true;
		}else{
			optionsHighlight = false;
		}
		if(exitButton.contains(e.getPoint())){
			//System.out.println("Hover on Exit");
			exitHighlight = true;
		}else{
			exitHighlight = false;
		}
	}
}
