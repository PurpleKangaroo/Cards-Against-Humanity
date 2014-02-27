package users;

import cards.Hand;

/**
 * An object that represents Rando Cardrissian, a fake person who plays a random card every turn when the rules are set to "Rando Cardrissian".
 * Rando Cardrissian can still score points. If he wins, all of the players are supposed "go home in a state of everlasting shame"
 *  according to the directions that come with Cards Against Humanity.
 * @since CAH1.0
 * @version CAH1.0
 * @author Holt Maki
 *
 */

public final class Rando_Cardrissian extends Player{
	
	/**
	 * Rando Cardrissian's name.
	 */
	private final String NAME = "Rando Cardrissian";
	
	/**
	 * Rando Cardrissian's username.
	 */
	private final String USERNAME = "Rando_cardrissian";
	/**
	 * Creates an object that represents Rando Cardrissian, a fake person who plays a random card every turn when the rules are set to "Rando Cardrissian".
	 * Rando Cardrissian can still score points. If he wins, all of the players are supposed "go home in a state of everlasting shame"
     *  according to the directions that come with Cards Against Humanity.
     *  @since CAH1.0
	 */
	public Rando_Cardrissian() 
	{
		super();
		super.setHand(new Hand(1));
		super.setRealPerson(false);
		super.setCardCzar(false);
		super.setRandoCard(true);
	}
	
	/**
	 * Gets the players name.
	 * In this case it is always "Rando Cardrissian".
	 * @return NAME - Rando Cardrissian's name the player's name.
	 * @since CAH1.0
	 */
	public String getName()
	{
		return NAME;
	}
	
	/**
	 * Gets the player's user name.
	 * @return USERNAME - the Rando Cardrissian's username.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public String getUserName()
	{
		return USERNAME;
	}

}
