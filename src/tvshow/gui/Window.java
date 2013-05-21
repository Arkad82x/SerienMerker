package tvshow.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.ScrollPane;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import tvshow.controler.Controller;
import tvshow.controler.Listener;
import tvshow.model.Serie;

public class Window extends JFrame implements IDisplay {

	private final Dimension size;
	private final Point location;
	
	private final Listener listener;
	private final Controller controller;
	
	private final GlobalPanel globalPanel;

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
		this.setLayout(null);
		
		//init Panel to display Series
		globalPanel = new GlobalPanel(listener, new Dimension(700, 500), new Point(10,10));
		this.add(globalPanel);
		
		updateGui();

	}

	

	@Override
	public void updateGui() {
		// TODO Auto-generated method stub
		
		this.globalPanel.updateGui();
	}

	@Override
	public void updateList(final LinkedList<Serie> seriesList) {
		globalPanel.updateList(seriesList);
	}

	@Override
	public String getCurrentName() {
		return globalPanel.getCurrentName();
	}
	
	//TODO change LinkedList to ArrayList

}
