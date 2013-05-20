package tvshow.gui;

import java.util.LinkedList;

import tvshow.model.Serie;

public interface IDisplay{

	public void updateGui();
	public void updateList(final LinkedList<Serie> seriesList);
	public String getCurrentName();

}
