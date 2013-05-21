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
		String s = commandId[0];
		
		if (s.equals(INCREMENTEPISODE))
			controller.incrementEpisode(id);
		else if(s.equals( DECREMENTEPISODE))
			controller.decrementEpisode(id);	
		else if(s.equals( INCREMENTSEASON))
			controller.incrementSeason(id);
		else if(s.equals( DECREMENTSEASON))
			controller.decrementSeason(id);		
		else if(s.equals( ADDSERIES))
			controller.addSeries();	
		else if( s.equals(DELETESERIES))
			controller.deleteSeries(id);
		
		
		
	}

}
