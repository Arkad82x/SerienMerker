package tvshow.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import tvshow.controler.Controller;
import tvshow.controler.Listener;
import tvshow.model.Serie;

public class Window extends JFrame implements IDisplay {

	private final Dimension size;
	private final Point location;

	private LinkedList<Serie> seriesList;
	private SeriesShowPanel showPanel;
	
	private final Listener listener;
	private final Controller controller;

	public Window(String title, Dimension size, Point location) {
		// set object variables
		super(title);
		this.size = size;
		this.location = location;
		controller = new Controller(this);
		listener = new Listener(controller);

		// init Frame
		this.setSize(size);
		this.setLocation(location);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		//init Panel to display Series
		showPanel = new SeriesShowPanel(listener, new Dimension(size.width/10*8, size.height/10*8)
		, new Point(this.getWidth()/8,this.getHeight()/10));
		showPanel.setVisible(true);
		
		
		
		//add Panels
		this.add(showPanel, BorderLayout.CENTER);
		
		updateGui();

	}

	public static void main(String[] args) {
		new Window("Serien Merker", new Dimension(1000, 600),
				new Point(100, 50));
	}

	@Override
	public void updateGui() {
		// TODO Auto-generated method stub
		
		this.showPanel.updateGui();
	}

	@Override
	public void updateList(final LinkedList<Serie> seriesList) {
		showPanel.updateList(seriesList);
	}

	@Override
	public String getCurrentName() {
		return showPanel.getCurrentName();
	}
	
	//TODO change LinkedList to ArrayList

}
