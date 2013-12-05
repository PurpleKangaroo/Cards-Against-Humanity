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
	 */
	public HumanPlayer(int numberOfCards, String userName) {
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
	
	

}
