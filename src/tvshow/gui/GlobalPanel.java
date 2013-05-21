package tvshow.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tvshow.controler.Listener;
import tvshow.model.Serie;

public class GlobalPanel extends JPanel{

	JScrollPane scroll;
	SeriesShowPanel showPanel;
	
	public GlobalPanel(Listener listener, Dimension d, Point p){
		this.setSize(d);
		this.setLocation(p);
		this.setVisible(true);
		this.setBackground(Color.cyan);
		
		
		showPanel = new SeriesShowPanel(listener, new Dimension(d.width-20, d.height-20), new Point(10,10));
		
		scroll = new JScrollPane(showPanel);
		
		scroll.setPreferredSize(new Dimension(d.width-20,d.height-20));
		this.add(scroll);
		
		
	}
	
	public void updateGui(){
	
		showPanel.updateGui();
	}
	
	public void updateList(LinkedList<Serie> list){
		showPanel.updateList(list);
	}
	
	public String getCurrentName(){
		return showPanel.getCurrentName();
	}
	
}
