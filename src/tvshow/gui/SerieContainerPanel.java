package tvshow.gui;

import java.awt.Dimension;
import java.awt.Point;

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
	
	public SerieContainerPanel(final Serie serie,final Listener listener){
		super();
		this.serie = serie;
		
		this.incrementEpisodeButton = new JButton("+");
		this.decrementEpisodeButton = new JButton("-");
		this.incrementSeasonButton = new JButton("+");
		this.decrementSeasonButton = new JButton("-");
		this.seriesNameLabel = new JLabel(serie.getName());
		
	}
	
}
