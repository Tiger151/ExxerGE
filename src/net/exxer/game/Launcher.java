package net.exxer.game;

public class Launcher {

	public static void main(String[] args) {
		boolean min = true, mid = false, max = false;
		if(min){
			Game game = new Game(1600,900, "Tank Building Simulator");
			game.start();
		}else if(mid){
			Game game = new Game(1920,1080, "Tank Building Simulator");
			game.start();
		}else if(max){
			Game game = new Game(3840,2160, "Tank Building Simulator");
			game.start();
		}
	}
}
