package sounds;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.print.attribute.standard.Media;

public class MusicPlayer implements Runnable 
{
	//TODO use sliders for music and sound effects volume.
	private Map<String, SongInfo> allSongs;
	private Map<String, SongInfo> selectedSongs;
	
	public MusicPlayer()
	{
		allSongs = new TreeMap<String, SongInfo>();
		//TODO: initialize Map with the songs file location 
	}
	
	public MusicPlayer(TreeMap<String, SongInfo> songmap)
	{
		allSongs = songmap;
	}
	
	protected void addSong(String pathname, SongInfo info)
	{
		allSongs.put(pathname, info);
	}
	
	private void playSongs()
	{
		
	}
	
	@Override
	public void run() {
		while(true)
		{
			
		}
		// TODO Auto-generated method stub
		
	}
	

}
