package sounds;

public class SongInfo {
	private String name;
	private String artist;
	private String album;
	private Genre genre;
	private int year;
	private boolean explicit;
	
	public SongInfo(String name, String artist, String album, Genre genre, int year, boolean explicit)
	{
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.year = year;
		this.explicit = explicit;
	}

}
