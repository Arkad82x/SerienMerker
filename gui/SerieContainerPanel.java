package tvshow.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tvshow.controler.Listener;
import tvshow.model.Serie;

public class SerieContainerPanel extends JPanel{

	private final Serie serie;
	private final JButton incrementEpisodeButton;
	private final JButton decrementEpisodeButton;
	private final JButton incrementSeasonButton;
	private final JButton decrementSeasonButton;
	private final JButton deleteButton;
	private final JLabel seriesNameLabel;
	private final JLabel currentEpisodeLabel;
	private final JLabel currentSeasonLabel;

	public SerieContainerPanel(final Serie serie,final Listener listener, final Dimension size){
		//TODO labels für episode + season
		super();
		this.setSize(size);
		this.setBackground(Color.yellow);

		this.serie = serie;
		this.setLayout(new FlowLayout());

		//init buttons and label
		this.incrementEpisodeButton = new JButton("+");
		this.decrementEpisodeButton = new JButton("-");
		this.incrementSeasonButton = new JButton("+");
		this.decrementSeasonButton = new JButton("-");
		this.deleteButton = new JButton("Delete");
		this.seriesNameLabel = new JLabel(serie.getName());
		this.currentEpisodeLabel = new JLabel("" + serie.getEpisode());
		this.currentSeasonLabel = new JLabel("" + serie.getSeason());

		//add Actionlisteners
		this.incrementEpisodeButton.addActionListener(listener);
		this.decrementEpisodeButton.addActionListener(listener);
		this.incrementSeasonButton.addActionListener(listener);
		this.decrementSeasonButton.addActionListener(listener);
		this.deleteButton.addActionListener(listener);

		//addActioncommands
		this.incrementEpisodeButton.setActionCommand(Listener.INCREMENTEPISODE + "," + serie.getID());
		this.decrementEpisodeButton.setActionCommand(Listener.DECREMENTEPISODE + "," + serie.getID());
		this.incrementSeasonButton.setActionCommand(Listener.INCREMENTSEASON + "," + serie.getID());
		this.decrementSeasonButton.setActionCommand(Listener.DECREMENTSEASON + "," + serie.getID());
		this.deleteButton.setActionCommand(Listener.DELETESERIES + "," + serie.getID());
		
		///add components to Panel
		this.add(seriesNameLabel);

		this.add(incrementEpisodeButton);
		this.add(decrementEpisodeButton);
		this.add(currentEpisodeLabel);

		this.add(incrementSeasonButton);
		this.add(decrementSeasonButton);
		this.add(currentSeasonLabel);
		
		this.add(deleteButton);

	}

}
