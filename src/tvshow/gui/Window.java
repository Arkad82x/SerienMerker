package tvshow.gui;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

public class Window extends JFrame{

	private final Dimension size;
	private final Point location;
	
	public Window(String title, Dimension size, Point location){
		//set object variables
		super(title);
		this.size = size;
		this.location = location;
		
		//init Frame
		this.setSize(size);
		this.setLocation(location);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new Window("Serien Merker", new Dimension(800,500), new Point(200,200));
	}
	
}
