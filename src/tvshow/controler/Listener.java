package tvshow.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

	public static final String INCREMENTEPISODE = "INCREMENTEPISODE";
	public static final String DECREMENTEPISODE = "DECREMENTEPISODE";
	public static final String INCREMENTSEASON  = "INCREMENTSEASON";
	public static final String DECREMENTSEASON  = "DECREMENTSEASON";
	public static final String ADDSERIES 		= "ADDSERIES";
	public static final String DELETESERIES     = "DELETESERIES";

	private final Controller controller;

	public Listener(final Controller controller) {
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent ae) {
		final String[] commandId = ae.getActionCommand().split(",");
		final long id = (commandId.length > 1) ? Long.parseLong(commandId[1]) : -1;
		switch (commandId[0]) {
		case INCREMENTEPISODE:
			controller.incrementEpisode(id);
			break;
		case DECREMENTEPISODE:
			controller.decrementEpisode(id);
			break;
		case INCREMENTSEASON:
			controller.incrementSeason(id);
			break;
		case DECREMENTSEASON:
			controller.decrementSeason(id);
			break;
		case ADDSERIES:
			controller.addSeries();
			break;
		case DELETESERIES:
			controller.deleteSeries(id);
		default:
			break;
		}
	}

}
