package users;

import cards.AnswerCard;
import cards.Deck;
import cards.Hand;

/**
 * A class of object that contains all players including Rando Cardrissian.
 * @since CAH1.0
 * @version CAH1.0
 * @see {@linkplain nonRandoPlayer}, {@linkplain Rando_Cardrissian}, {@linkplain humanPlayer}, {@linkplain AIPlayer}
 * @author Holt Maki
 *
 */

public class Player {
	protected boolean Card_Czar;
	protected int AwesomePoints = 0;
	private boolean RandoCard;
	protected boolean realPerson;
	protected Hand cardsInHand;
	protected String name;
	protected String userName;

	/**
	 * Creates an object that represents a player.
	 * This player could be Rando Cardrissian.
	 * @since CAH1.0
	 */
	public Player()
	{
		
	}
	
	/**
	 * Adds awesome points to the players awesome points score
	 * @param points - the number of awesome points to be added to the score.
	 * @since CAH1.0
	 */
	public void scoreAwesomePoints(int points)
	{
		AwesomePoints = AwesomePoints + points;
	}
	
	/**
	 * Gets a players awesome points.
	 * @return AwesomePoints - the number of AwesomePoints that the player has.
	 * @since CAH1.0
	 */
	public int getAwesomePoints()
	{
		return AwesomePoints;
	}
	
	/**
	 * Gets the boolean realPerson to tell if the player is a computer or real person.
	 * @return realPerson - true if the player is a real person.
	 * @since CAH1.0
	 */
	public boolean getRealPerson()
	{
		return realPerson;
	}
	
	/**
	 * Gets the boolean that says wether or not a player is Card Czar
	 * @return Card_Czar- the boolean that says wether or not the player is the Card Czar
	 * @since CAH1.0
	 */
	public boolean getCard_Czar()
	{
		return Card_Czar;
	}
	
	/**
	 * Plays a card and removes it from the hand.
	 * @param cardNumber - The index in the hand of card that will be played and removed from the hand.
	 * @return a - The card that is played.
	 * @since CAH1.0
	 */
	public AnswerCard playCard(int cardNumber)
	{
		AnswerCard a = cardsInHand.playCard(cardsInHand.get(cardNumber));
		return a;
	}
	
	/**
	 * Deals cards to the player and allows the player to draw cards.
	 * @param a - the deck.
	 * @return a - the deck after the user has drawn cards from it.
	 * @since CAH1.0
	 */
	public Deck deal_draw(Deck a)
	{
		a = cardsInHand.deal_draw(a);
		return a;
	}
	
	/**
	 * Deals cards to the player and allows the player to draw cards.
	 * @param a - the deck.
	 * @param noOfCardsOverLimit - the number of cards over the limit that will be drawn
	 * @return a - the deck after the user has drawn cards from it.
	 * @since CAH1.0
	 */
	public Deck draw_Extra(Deck a, int noOfCardsOverLimit)
	{
		a = cardsInHand.exceedLimitDraw(a, noOfCardsOverLimit);
		return a;
	}
	/**
	 * Makes the player the Card Czar. {@link #Card_Czar} becomes true.
	 * @throws Card_Czar_Exception When the new Card Czar is already Card Czar
	 * @since CAH1.0
	 */
	public void isCard_Czar() throws Card_Czar_Exception
	{
		if (Card_Czar = false)
		{
			Card_Czar = true;
		}
		else
		{
			Card_Czar_Exception a = new Card_Czar_Exception();
			throw a;
		}
	}
	
	/**
	 * The player is no longer the Card Czar. {@link #Card_Czar} becomes false.
	 * @throws Card_Czar_Exception This exception is thrown if the player is already not the Card Czar.
	 * @since CAH1.0
	 */
	public void notCard_Czar() throws Card_Czar_Exception
	{
		if (Card_Czar = true)
		{
			Card_Czar = false;
		}
		else
		{
			Card_Czar_Exception a = new Card_Czar_Exception();
			throw a;
		}
	}
	
	/**
	 * Sets the boolean that tells whether or not the player is Rando Cardrissian.
	 * @param a - the boolean that randoCard will be set to equal.
	 * @since CAH1.0
	 */
	protected void setRandoCard(boolean a)
	{
		RandoCard = a;
	}
	
	/**
	 * Gets the boolean that tells whether or not the player is Rando Cardrissian.
	 * @return RandoCard - the boolean that tells whether or not the player is Rando Cardrissian.
	 * @since CAH1.0;
	 */
	public boolean getRandoCard()
	{
		return RandoCard;
	}
}
