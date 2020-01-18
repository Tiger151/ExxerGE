package net.exxer.game;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import net.exxer.game.audio.AudioManager;
import net.exxer.game.display.Display;
import net.exxer.game.gfx.Assets;
import net.exxer.game.gfx.GameCamera;
import net.exxer.game.input.KeyManager;
import net.exxer.game.state.GameState;
import net.exxer.game.state.MenuState;
import net.exxer.game.state.OptionState;
import net.exxer.game.state.ScreenState;

public class Game implements Runnable{
	private Display display;
	private int width, height;
	public String title;
	private Thread thread;
	//private GraphicsEngine ge;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics2D g;
	//states(screens)
	private ScreenState gameState;
	private ScreenState menuState;
	private ScreenState optionState;
	//inputs
	private KeyManager keyManager;
	//private MouseManager mouseManager;//disabled and switched to using handling mouse per state
	//camera
	private GameCamera gameCamera;
	//Handler
	private Handler handler;
	private AudioManager audioManager;
	
	public Game(int w, int h, String tit){
		width = w;
		height = h;
		title = tit;
		keyManager = new KeyManager(handler);
		//mouseManager = new MouseManager();
	}
	
	private void update(){
		//mouseManager
		keyManager.Update();
		if(ScreenState.getState() != null){
			ScreenState.getState().update();
		}
	}
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		if(ScreenState.getState() != null){
			ScreenState.getState().render(g);
		}
		bs.show();
		g.dispose();
	}
	private void init(){
		display = new Display(width, height, title, "/textures/tank.png");
		display.getFrame().addKeyListener(keyManager);
		
		
		//display.getCanvas().addMouseListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		audioManager = new AudioManager(handler);
		gameCamera = new GameCamera(handler, 0, 0);
		menuState = new MenuState(handler);
		gameState = new GameState(handler);
		optionState = new OptionState(handler);
		
		audioManager.loadAll();
		
		//ge = new GraphicsEngine(handler, display,  width, height);
		//ge.start();
		
		ScreenState.setState(menuState);//switch state here <<<--------------------------------
	}
	@Override
	public void run() {
		init();
		/*long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		//requestFocus();// gets rid of annoying clicking first 
		while(running){
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update();
				//updates++;
				delta--;
				//render();
				frames++;
			}
			//disabled to keep updates and rendering the same
				ge.rTick();
				//render(); //<<---DISAPLED FOR GE TESTING
				//frames++;
				updates++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				display.setTitle("@ 2D Engine" + " | UPS: " + updates + " FPS: " + frames);
				updates = 0;
				frames = 0;
			}
		}*/
		long initialTime = System.nanoTime();
		final double timeU = 1000000000 / 240;//adjust this value
		final double timeF = 1000000000 / 60;
		double deltaU = 0, deltaF = 0;
		int frames = 0, ticks = 0;
		long timer = System.currentTimeMillis();
		    while (running) {
		        long currentTime = System.nanoTime();
		        deltaU += (currentTime - initialTime) / timeU;
		        deltaF += (currentTime - initialTime) / timeF;
		        initialTime = currentTime;
		        if (deltaU >= 1) {
		            update();
		            ticks++;
		            deltaU--;
		        }
		        if (deltaF >= 1) {
		            render();
		            frames++;
		            deltaF--;
		        }
		        if (System.currentTimeMillis() - timer > 1000) {
		            //if (RENDER_TIME) { //change to parameter
		                System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
		                display.setTitle(String.format("@ 2D Engine | UPS: %s FPS: %s", ticks, frames));
		            //}
		            frames = 0;
		            ticks = 0;
		            timer += 1000;
		        }
		    }
		stop();
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		
		//graphicsThread = new Thread(ge);
		thread.start();

		//graphicsThread.start();
		//System.out.println(graphicsThread.isAlive());
	}
	public synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
			
			//graphicsThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	public GameCamera getGameCamera(){
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public Display getDisplay(){
		return display;
	}
	public ScreenState getGameState(){
		return gameState;
	}
	public ScreenState getMenuState(){
		return menuState;
	}
	public ScreenState getOptionState(){
		return optionState;
	}
	public AudioManager getAudioManager(){
		return audioManager;
	}
	
	public boolean isRunning() {
		return running;
	}
	//public MouseManager getMouseManager(){
	//	return mouseManager;
	//}
}