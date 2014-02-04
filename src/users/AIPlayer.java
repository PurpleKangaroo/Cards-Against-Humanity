package users;

/**
 * A class of object that represents AI players.
 * @author Holt Maki
 * @version incomplete
 * @since incomplete
 */
public class AIPlayer extends NonRandoPlayer{
	/**
	 * The name that we have given to the AI player.
	 */
	private String name;
	
	/**
	 * The username assigned to the AI player.
	 */
	private String userName;
	
	/**
	 * Creates a new AI player.
	 * @since CAH1.0
	 * @author Holt Maki
	 * @param numberOfCards - the number of cards that the ai player can hold
	 */
	public AIPlayer(int numberOfCards) {
		super(numberOfCards);
		/*
		 * fill with
		 * username
		 * name
		 * (And other stuff?)
		 */
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the player's name.
	 * @author Holt Maki
	 * @return name - the players name.
	 * @since CAH1.0
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the player's username.
	 * @author Holt Maki
	 * @return userName - the AI player's username.
	 * @since CAH1.0
	 */
	public String getUserName()
	{
		return userName;
	}

}
