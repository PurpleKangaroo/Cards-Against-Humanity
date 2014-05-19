package netplay;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * A Message that contains information about something that someone wrote in chat.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class ChatMessage implements Message
{
	private GregorianCalendar date;
	private String username;
	private String message;
	
	/**
	 * A ChatMessage object containing a message supplied by a particular user.
	 * @param username the username of the user making a chat message.
	 * @param message the text of the user's message.
	 */
	public ChatMessage(String username, String message)
	{
		this.date = new GregorianCalendar();
		this.username = username;
		this.message = message;
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

	@Override
	public boolean isPublic()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSender()
	{
		return username;
	}

	@Override
	public int getPriority()
	{
		int priority = -1;
		return priority;
	}
}
