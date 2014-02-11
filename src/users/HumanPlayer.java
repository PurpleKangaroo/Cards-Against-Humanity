package users;

/**
 * A class of object that represents real human players.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class HumanPlayer extends NonRandoPlayer{
	private User person;
	
	/**
	 * Constructs a human player.
	 * @param numberOfCards - the number of cards allowed to each player in the game.
	 * @param userName - the userName of the user that is controlling the player.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public HumanPlayer(int numberOfCards, String userName) 
	{
		super(numberOfCards);
		realPerson = true;
		/*
		 * fill with
		 * username
		 * name
		 * (And other stuff?)
		 */
		//Find use userSave class to import userInfo and stuff right here.
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the User that controls the Player.
	 * @since CAH1.0
	 * @author Holt Maki
	 * @return person - the User that controls the Player.
	 */
	public User getUser()
	{
		return person;
	}
	
	/**
	 * Gets the players name
	 * @since CAH1.0
	 * @author Holt Maki
	 * @return The players first and last name.
	 */
	public String getName()
	{
		return person.getUserProfile().getFirstName() + person.getUserProfile().getLastName();
	}

	/**
	 * Gets the players username.
	 * @since CAH1.0
	 * @author Holt Maki
	 * @return The players username.
	 */
	public String getUserName() {
		return person.getUserProfile().getUserName();
	}
	

}