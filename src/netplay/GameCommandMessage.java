package netplay;

import java.util.ArrayList;

import game.CAH_Game;
import game.Rules;
import users.Player;
import users.User;
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
	private Card[][] cards;
	private User user;
	private Rules rules;
	private CAH_Game game;
	private ArrayList<Player> players;
	
	public GameCommandMessage(ArrayList<Player> players)
	{
		this.command = GameCommand.GET_PLAYERS;
		this.players = players;
	}
	
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
	
	public GameCommandMessage(GameCommand command, CAH_Game game)
	{
		this.game = game;
		this.command = command;
	}
	
	public GameCommandMessage(User user)
	{
		command = GameCommand.ADD_PLAYER;
		this.user = user;
	}
	
	public GameCommandMessage(Rules rules)
	{
		command = GameCommand.GET_GAME_RULES;
		this.rules = rules;
	}
	
	public Rules getRules()
	{
		return this.rules;
	}
	
	public CAH_Game getGame()
	{
		return game;
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
	public GameCommandMessage(boolean isPublic, GameCommand command, String sender, Card[][] cards)
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
	
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	/**
	 * Gets the User that is being added to the game.
	 * @return user - The User being added to the game.
	 */
	public User getUser()
	{
		return user;
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
	public Card[][] getCards() throws CardNumberException
	{
		if(cards == null) throw new CardNumberException();
		else return cards;
	}
	
	/**
	 * Gets the GameCommandMessage's GameCommand.
	 * @return command - The GameCommandMessage's GameCommand.
	 */
	public GameCommand getGameCommand()
	{
		return command;
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
		ADD_PLAYER,
		REMOVE_PLAYER,
		DRAW_PHASE,
		GET_ANSWER_CARDS,
		SCORE_POINTS,
		SERIOUS_BUISNESS_POINTS,
		NEXT_CARD_CZAR,
		GET_CURRENT_CARD_CZAR,
		GET_ROUND_COUNT,
		GET_AWESOME_POINTS,
		GET_PLAYERS,
		GET_GAME_RULES;
	}

	@Override
	public int getPriority()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
