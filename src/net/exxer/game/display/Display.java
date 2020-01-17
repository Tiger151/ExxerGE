package net.exxer.game.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import net.exxer.game.gfx.ImageLoader;


public class Display {
	private JFrame frame = new JFrame();
	private int width, height;
	private String title;
	private Canvas canvas;
	private String iconPath;
	
	public Display(int w, int h, String tit, String iconPath){
		title = tit;
		width = w;
		height = h;
		this.iconPath = iconPath;
		beginDisplay();
	}
	private void beginDisplay(){ 
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.setIconImage(new ImageIcon(ImageLoader.loadImage(iconPath)).getImage());
		frame.pack();
	}
	public Canvas getCanvas(){
		return canvas;
	}
	public void setTitle(String fps_ups){
		frame.setTitle(String.format("title : %s", fps_ups));
	}
	public JFrame getFrame(){
		return frame;
	}
}
