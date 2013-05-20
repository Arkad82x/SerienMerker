package tvshow.gui;

import java.awt.Color;
import java.awt.Dimension;
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

	public SeriesShowPanel(final Listener listener, final Dimension d, final Point p) {
		this.setLayout(null);
		this.setBackground(Color.blue);
		this.listener = listener;
		this.addPanel = new AddPanel(listener);

		this.setSize(d);
		this.setLocation(p);

		containerSize = new Dimension((this.getWidth() / 10) * 9, 60);
		addPanel.setSize(containerSize);
		containerList = new LinkedList<SerieContainerPanel>();
		this.add(addPanel);

	}

	public void updateList(final LinkedList<Serie> seriesList) {

		this.containerList = new LinkedList<SerieContainerPanel>();
		for (Serie s : seriesList) {
			containerList.add(new SerieContainerPanel(s, this.listener));
		}
	}

	public void updateGui() {
		this.removeAll();
		this.setBackground(Color.blue);
		this.updateUI();
		Point position = new Point(5, 5);

		for (SerieContainerPanel p : containerList) {
			p.setLocation(position);
			p.setSize(containerSize);
			this.add(p);
			p.setVisible(true);

			position.y += containerSize.height+5;
		}
		this.addPanel.cleanTextField();
		this.addPanel.setVisible(true);
		this.addPanel.setLocation(position);
		this.add(this.addPanel);

	}

	public String getCurrentName() {
		return this.addPanel.getCurrentName();
	}

}
