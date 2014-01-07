package sounds;

import java.util.Map;
import java.util.TreeMap;

public class MusicPlayer implements Runnable 
{
	//TODO use sliders for music and sound effects volume.
	private Map<String, SongInfo> songs;
	
	public MusicPlayer()
	{
		songs = new TreeMap<String, SongInfo>();
		//TODO: initialize Map with the songs file location 
	}
	
	public MusicPlayer(TreeMap<String, SongInfo> songmap)
	{
		songs = songmap;
	}
	
	protected void addSong(String pathname, SongInfo info)
	{
		songs.put(pathname, info);
	}	
	
	@Override
	public void run() {
		while(true)
		{
			
		}
		// TODO Auto-generated method stub
		
	}
	

}
