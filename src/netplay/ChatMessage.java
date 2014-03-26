package netplay;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class ChatMessage
{
	private GregorianCalendar date;
	private String username;
	private String message;
	
	public ChatMessage(String username, String message)
	{
		this.date = new GregorianCalendar();
	}
	
	/**
	 * A map that keeps track of all the mentions of different users in a Chat Message.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected class MentionMap
	{
		private HashMap<Pair<Integer>, MentionType> mentions;
		public MentionMap()
		{
			
		}
		
		public void put(int first, int second, MentionType type)
		{
			Pair<Integer> a = new Pair<Integer>();
			a.setFirst(first);
			a.setSecond(second);
			mentions.put(a, type);
		}
		
		public Map getMentionsMap()
		{
			return mentions;
		}
	}
	
	enum MentionType
	{
		USERNAME,
		USER,
		HASHTAG,
		CARD;
	}
}
