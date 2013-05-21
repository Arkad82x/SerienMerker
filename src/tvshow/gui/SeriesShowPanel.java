package tvshow.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JPanel;

import tvshow.controler.Listener;
import tvshow.model.Serie;

public class SeriesShowPanel extends JPanel {

	
	
	private LinkedList<SerieContainerPanel> containerList;
	private final Listener listener;
	private final AddPanel addPanel;
	private final Dimension containerSize;
	GridBagConstraints c;

	public SeriesShowPanel(final Listener listener, final Dimension d, final Point p) {
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH;
		
		this.setBackground(Color.blue);
		this.listener = listener;
		this.addPanel = new AddPanel(listener);

		this.setSize(d);
		this.setLocation(p);

		containerSize = new Dimension(d.width-20, 80);
		c.weightx = (double)containerSize.width;
		addPanel.setSize(containerSize);
		containerList = new LinkedList<SerieContainerPanel>();
		this.add(addPanel);

	}

	public void updateList(final LinkedList<Serie> seriesList) {

		this.containerList = new LinkedList<SerieContainerPanel>();
		for (Serie s : seriesList) {
			containerList.add(new SerieContainerPanel(s, this.listener, containerSize));
		}
	}

	public void updateGui() {
		c.gridy = 1;
		this.removeAll();
		this.updateUI();
	

		for (SerieContainerPanel p : containerList) {
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridy++;
			this.add(p,c);
			p.setVisible(true);

		
		}
	
		this.addPanel.cleanTextField();
		this.addPanel.setVisible(true);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy++;
		this.add(this.addPanel,c);

	}

	public String getCurrentName() {
		return this.addPanel.getCurrentName();
	}

}
