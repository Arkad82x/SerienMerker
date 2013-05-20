package tvshow.gui;

import java.awt.Color;
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
	private final JLabel seriesNameLabel;
	private final JLabel currentEpisodeLabel;
	private final JLabel currentSeasonLabel;

	public SerieContainerPanel(final Serie serie,final Listener listener){
		//TODO labels für episode + season
		super();

		this.setBackground(Color.yellow);

		this.serie = serie;
		this.setLayout(new FlowLayout());

		//init buttons and label
		this.incrementEpisodeButton = new JButton("+");
		this.decrementEpisodeButton = new JButton("-");
		this.incrementSeasonButton = new JButton("+");
		this.decrementSeasonButton = new JButton("-");
		this.seriesNameLabel = new JLabel(serie.getName());
		this.currentEpisodeLabel = new JLabel("" + serie.getEpisode());
		this.currentSeasonLabel = new JLabel("" + serie.getSeason());

		//add Actionlisteners
		this.incrementEpisodeButton.addActionListener(listener);
		this.decrementEpisodeButton.addActionListener(listener);
		this.incrementSeasonButton.addActionListener(listener);
		this.decrementSeasonButton.addActionListener(listener);

		//addActioncommands
		this.incrementEpisodeButton.setActionCommand(listener.INCREMENTEPISODE + "," + serie.getID());
		this.decrementEpisodeButton.setActionCommand(listener.DECREMENTEPISODE + "," + serie.getID());
		this.incrementSeasonButton.setActionCommand(listener.INCREMENTSEASON + "," + serie.getID());
		this.decrementSeasonButton.setActionCommand(listener.DECREMENTSEASON + "," + serie.getID());

		///add components to Panel
		this.add(seriesNameLabel);

		this.add(incrementEpisodeButton);
		this.add(decrementEpisodeButton);
		this.add(currentEpisodeLabel);

		this.add(incrementSeasonButton);
		this.add(decrementSeasonButton);
		this.add(currentSeasonLabel);

	}

}
