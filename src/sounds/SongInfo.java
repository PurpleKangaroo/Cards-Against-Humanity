package sounds;

/**
 * A class of object that contains data about a song.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public class SongInfo {
	private String name;
	private String artist;
	private String album;
	private Genre genre;
	private int year;
	
	/**
	 * Creates an object that contains data about a song.
	 * @param name - the name of the song
	 * @param artist - the song's artist
	 * @param album - the song's album
	 * @param genre - The songs music genre
	 * @param year - The year that the song was released in
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	public SongInfo(String name, String artist, String album, Genre genre, int year)
	{
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.year = year;
	}
	
	/**
	 * Gets the name of the song.
	 * @return name - the name of the song.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the song's artist.
	 * @return artist - the song's artist
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	public String getArtist()
	{
		return artist;
	}
	
	/**
	 * Gets the name of the song's album.
	 * @return album - The album that the song is from
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	public String getAlbum()
	{
		return album;
	}
	
	/**
	 * Gets the song's genre.
	 * @return genre - The song's genre of music
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	public Genre getGenre()
	{
		return genre;
	}
	
	/**
	 * Gets the year that the song was released in.
	 * @return year - the year that the song was released in.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	public int getYear()
	{
		return year;
	}
}
