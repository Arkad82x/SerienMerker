package tvshow.model;

public class Serie {

	private int season, episode;
	private String name;
	
	public Serie(int season, int episode, String name){
		this.setSeason(season);
		this.setEpisode(episode);
		this.setName(name);
	}
	
	public Serie(){
		this.setSeason(0);
		this.setEpisode(0);
		this.setName("");
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
