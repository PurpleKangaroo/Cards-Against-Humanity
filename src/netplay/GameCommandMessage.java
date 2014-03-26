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
	 * An interface used to place all of the GameCommands in one category, while allowing the ServerGameCommand and ClientGameCommand to remain seperate.
	 * @see ServerGameCommand
	 * @see ClientGameCommand
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 *
	 */
	protected abstract interface GameCommand
	{
		
	}
	
	/**
	 * A list of {@linkplain GameCommand}s that the server can send on its own.
	 * These game commands are sent after processing of game logic.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	protected enum ServerGameCommand implements GameCommand
	{
		//TODO fill
		/**
		 * The {@linkplain GameCommand} sent by the server that indicates that the server is sending the player their hand.
		 */
		HAND,
		/**
		 * The {@linkplain GameCommand} sent by the server 
		 */
		QUESTION_CARD,
		PLAYERS,
		CARD_CZAR,
		SELECTION_OPTIONS,
		VOTE_PROMPT,
		PLAYER_VOTED,
		VOTE_RESULT,
		CARDELIMINATION_PROMPT,
		CARD_ELIMINATED,
		CARDELIMINATION_RESULT,
		CARD_PLAYED,
		;
		
	}
	
	/**
	 * A list of {@linkplain GameCommand}s that the client can send to the server.
	 * These game commands are sent after the user interacts with the UI in a way that causes a GameCommandMessage to be sent.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	protected enum ClientGameCommand implements GameCommand
	{
		//TODO fill
	}

}
