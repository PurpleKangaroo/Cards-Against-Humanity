package netplay;

/**
 * A collection of methods that all belong to a Message sent over CAH netplay.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public interface Message
{
	/**
	 * Returns weather or not the message is public. This tells the server if it should send the message to everyone or not.
	 * @return The boolean that tells if the Message is public.
	 * @since CAH1.0
	 */
	public boolean isPublic();
	/**
	 * Gets the sender of the message.
	 * @return The sender of the message.
	 * @since CAH1.0
	 */
	public String getSender();
	
	/**
	 * Gets the priority of the message.
	 * @return priority - the priority of the message.
	 * @since CAH1.0
	 */
	public int getPriority();
}
