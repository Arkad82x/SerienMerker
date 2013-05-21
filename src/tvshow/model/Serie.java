package tvshow.model;

public class Serie implements Comparable<Serie>{

	private int season, episode;
	private String name;
	private final long id;
	static long seriesCount = 0;
	private boolean currentlyWatching;
	
	public Serie(int season, int episode, String name){
		this.setSeason(season);
		this.setEpisode(episode);
		this.setName(name);
		this.id = seriesCount;
		seriesCount++;
		this.currentlyWatching = false;
	}
	
	public Serie(final String name){
		this(0,0,name);
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
	
	public long getID(){
		return this.id;
	}
	
	public void setCurrentlyWatching(boolean currentlyWatching){
		this.currentlyWatching = currentlyWatching;
	}

	@Override
	public int compareTo(Serie s) {
		//currentlyWatching has higher preference
		if(this.currentlyWatching && s.currentlyWatching){
			return this.getName().compareTo(s.getName());
		}else if(!this.currentlyWatching && !s.currentlyWatching){
			return this.getName().compareTo(s.getName());
		}else if(this.currentlyWatching && !s.currentlyWatching){
			return -1;
		}else{
			return 1;
		}
	}
}
