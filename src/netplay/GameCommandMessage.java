package netplay;

import cards.Card;

/**
 * 
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class GameCommandMessage implements Message
{
	private boolean isPublic;
	private GameCommand command;
	private String sender;
	private Card card;
	private Card[] cards;
	
	/**
	 * Creates a game command that does not contain a card.
	 * @param isPublic The boolean that tells weather or not the message is intended for everyone.
	 * @param command The GameCommand that represents the command being used.
	 * @param sender The person who sent the GameCommandMessage.
	 * @author Holt Maki
	 * @since CAH1.0
	 */
	public GameCommandMessage(boolean isPublic, GameCommand command, String sender)
	{
		this.isPublic = isPublic;
		this.command = command;
		this.sender = sender;
	}
	
	/**
	 * Creates a game command that contains a single card.
	 * @param isPublic The boolean that tells weather or not the message is intended for everyone.
	 * @param command The byte that represents the command being used.
	 * @param sender The person who sent the GameCommandMessage.
	 * @author Holt Maki
	 * @param card The {@linkplain Card} that is being sent in the GameCommandMessage.
	 * @since CAH1.0
	 */
	public GameCommandMessage(boolean isPublic, GameCommand command, String sender, Card card)
	{
		this.isPublic = isPublic;
		this.command = command;
		this.sender = sender;
		this.card = card;
	}
	/**
	 * Creates a game command that contains a single card.
	 * @param isPublic The boolean that tells weather or not the message is intended for everyone.
	 * @param command The byte that represents the command being used.
	 * @param sender The person who sent the GameCommandMessage.
	 * @author Holt Maki
	 * @param cards The {@linkplain Card}s that are being sent in the GameCommandMessage.
	 * @since CAH1.0
	 */
	public GameCommandMessage(boolean isPublic, GameCommand command, String sender, Card[] cards)
	{
		this.isPublic = isPublic;
		this.command = command;
		this.sender = sender;
		this.cards = cards;
	}
	
	@Override
	public boolean isPublic()
	{
		return isPublic;
	}
	
	public String getSender()
	{
		return sender;
	}
	
	/**
	 * Gets the card sent over netplay.
	 * @return card - The card sent over netplay.
	 * @throws CardNumberException 
	 * @since CAH1.0
	 */
	public Card getCard() throws CardNumberException
	{
		if(card == null) throw new CardNumberException();
		else return card;
	}
	
	/**
	 * Gets the cards that were sent over netplay.
	 * @return cards - the cards that were sent over netplay.
	 * @throws CardNumberException 
	 * @since CAH1.0
	 */
	public Card[] getCards() throws CardNumberException
	{
		if(cards == null) throw new CardNumberException();
		else return cards;
	}
	
	/**
	 * An exception thrown when the number of cards asked for is incorrect.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public class CardNumberException extends Exception {

		/**
		 * The generated serialVersionUID.
		 */
		private static final long serialVersionUID = -51325150804823914L;
		
	}
	
	/**
	 * A list of all the different types of game commands.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public enum GameCommand
	{
		DRAW;
	}

	@Override
	public int getPriority()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
