package users;

import cards.Deck;
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

public class Rando_Cardrissian extends Player{
	
	/**
	 * Creates an object that represents Rando Cardrissian, a fake person who plays a random card every turn when the rules are set to "Rando Cardrissian".
	 * Rando Cardrissian can still score points. If he wins, all of the players are supposed "go home in a state of everlasting shame"
     *  according to the directions that come with Cards Against Humanity.
     *  @since CAH1.0
	 */
	public Rando_Cardrissian() 
	{
		super();
		cardsInHand = new Hand(1);
		Card_Czar = false;
		realPerson = false;
		setRandoCard(true);
		name = "Rando Cardrissian";
		userName = "Rando_Card";
	}
	
	/**
	 * Gets the players name.
	 * In this case it is always Rando Cardrissian.
	 * @return "Rando Cardrissian" the player's name.
	 * @since CAH1.0
	 */
	public String getName()
	{
		return "Rando Cardrissian";
	}
	
	/**
	 * Gets the player's user name.
	 * @return "RandoCardrissian" - the username.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public String getUserName()
	{
		return "RandoCardrissian";
	}

}
