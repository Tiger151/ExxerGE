package net.exxer.game;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import net.exxer.game.display.Display;
import net.exxer.game.state.ScreenState;

public class GraphicsEngine implements Runnable{
	private boolean tick = false;
	private BufferStrategy bs;
	private Graphics2D g;
	private Display display;
	private int w, h;
	private Thread thread;
	Handler handler;
	public GraphicsEngine(Handler handler, Display display, int w, int h) {
		this.handler = handler;
		this.display = display;
	    this.w = w;
	    this.h = h;
	}
	
	@Override
	public void run() {
		System.out.println("GE thread running");
		/*long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		//requestFocus();// gets rid of annoying clicking first 
		while(Game.isRunning()){
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				delta--;
				frames++;
				
			}
			render();
				updates++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//display.setTitle("@ 2D Engine" + " | UPS: " + updates + " FPS: " + frames);
				updates = 0;
				frames = 0;
			}
		}*/
		
		while(handler.getGame().isRunning()) {
			if(tick){
				render();
			}
			System.out.println("HHEH");
		}
		
	}
	
	private void render(){
		//System.out.println("GE thread rendering");
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		g.clearRect(0, 0, w, h);
		if(ScreenState.getState() != null){
			ScreenState.getState().render(g);
		}
		bs.show();
		g.dispose();
	}

	public void start() {
		//System.out.println("GE thread starting");
		if(thread == null) {
			thread = new Thread(this, "Graphics");
			thread.start();
		}
	}
	
	public void rTick() {
		tick = true;
	}
	
}
