package cards;

//TODO save this object when CAH closes.
/**
 * A class of object that stores data about the history of different CAH cards.
 * @since CAH1.0
 * @version CAH1.0
 * @author Holt Maki
 *
 */
public class CardHistory
{
	/**
	 * The card whose history CardHistory stores.
	 */
	private Card card;
	
	//TODO: Find a way to store data on what happens to the card.
	
	/**
	 * Creates a new CardHistory.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	public CardHistory()
	{
		//TODO: fill
	}
	
	/**
	 * Creates a record of an event that happens to a card.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	public void createRecord()
	{
		//TODO: fill
	}
	
	/**
	 * If the card is played this will make a record of it
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	public void cardPlayed()
	{
		//TODO:fill
		//NOTE: If the player who plays it should be a non-rando player here
	}
	
	public void cardVotedFor()
	{
		//TODO: fill
	}
	
	public void cardWon()
	{
		//TODO:Fill
	}
	
	public void cardLost()
	{
		//TODO: Fill
	}
	
	/**
	 * Creates a record of when the card is held onto by the player who has it, if it is in a player's hand.
	 */
	public void cardHeld()
	{
		//TODO: Fill
	}
}
