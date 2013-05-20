package tvshow.controler;

import java.util.Collections;
import java.util.LinkedList;

import tvshow.gui.IDisplay;
import tvshow.model.Serie;

public class Controller {

	private final IDisplay display;
	private final LinkedList<Serie> seriesList;

	public Controller(final IDisplay display) {
		this.display = display;
		this.seriesList = new LinkedList<Serie>();
	}

	public void incrementEpisode(long id) {
		Serie s = this.getSerieByID(id);
		if (s != null) {
			s.setEpisode(s.getEpisode() + 1);
			display.updateList(seriesList);
			display.updateGui();
		}
	}

	public void decrementEpisode(long id) {
		Serie s = this.getSerieByID(id);
		if (s != null) {
			s.setEpisode(s.getEpisode() - 1);
			display.updateList(seriesList);
			display.updateGui();
		}
	}

	public void incrementSeason(long id) {
		Serie s = this.getSerieByID(id);
		if (s != null) {
			s.setSeason(s.getSeason() + 1);
			display.updateList(seriesList);
			display.updateGui();
		}

	}

	public void decrementSeason(long id) {
		Serie s = this.getSerieByID(id);
		if (s != null) {
			s.setSeason(s.getSeason() - 1);
			display.updateList(seriesList);
			display.updateGui();
		}
	}

	private Serie getSerieByID(final long id) {
		for (Serie s : seriesList) {
			if (s.getID() == id) {
				return s;
			}
		}
		return null;
	}

	public void addSeries() {
		Serie s = new Serie(display.getCurrentName());
		this.seriesList.add(s);
		Collections.sort(seriesList);
		display.updateList(seriesList);
		display.updateGui();
	}

	public void deleteSeries(final long id) {
		Serie s = this.getSerieByID(id);
		this.seriesList.remove(s);
		display.updateList(seriesList);
		display.updateGui();
	}
}
