package sounds;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.print.attribute.standard.Media;

/**
 * A class of object that plays music.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * <dt>
 * <b>Implements:</b><dl> {@linkplain Runnable} </ul>
 */
public class MusicPlayer implements Runnable 
{
	//TODO use sliders for music and sound effects volume.
	/** All the songs that the user is playing*/
	private Map<String, SongInfo> allSongs;
	/**The songs that the user chooses to play*/
	private Map<String, SongInfo> selectedSongs;
	
	/**
	 * Creates a new object that plays music.
	 * This music constructor is blank because it simply initializes the TreeMap.
	 * Songs are added after the creation of the object if this constructor is used.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @see {@linkplain #MusicPlayer(TreeMap)} for a constructor that can have an already made map added to it.
	 */
	public MusicPlayer()
	{
		allSongs = new TreeMap<String, SongInfo>();
		//TODO: initialize Map with the songs file location 
	}
	
	/**
	 * Creates a new music player with an already existing map of songs.
	 * @param songmap - the TreeMap of the songs.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @see {@linkplain #MusicPlayer()} for a constructor that makes its own map.
	 */
	public MusicPlayer(TreeMap<String, SongInfo> songmap)
	{
		allSongs = songmap;
	}
	
	/**
	 * Adds a song to the MusicPlayer
	 * @param pathname - the path of the song. <b>This method does not have a PathFinder inside it so the path needs
	 * to be found outside of the method.</b> (Basically the path given here needs to be a full correct path).
	 * @param info - the songs {@linkplain SongInfo}: Contains the data for the songs artist, album, year, etc.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected void addSong(String pathname, SongInfo info)
	{
		allSongs.put(pathname, info);
	}
	
	//TODO: Maybe make a song selecter class
	
	/**
	 * Plays songs.
	 */
	private void playSongs(SongProperty a)
	{
		
	}
	
	/**
	 * Runs the MusicPlayer.
	 */
	@Override
	public void run() {
		boolean on = true;
		while(on = true)
		{
			//put the music playing in here
		}
		// TODO Auto-generated method stub
		
	}
	

}
