package users;

import cards.deck;
import cards.hand;

/**
 * An object that represents Rando Cardrissian, a fake person who plays a random card every turn when the rules are set to "Rando Cardrissian".
 * Rando Cardrissian can still score points. If he wins, all of the players are supposed "go home in a state of everlasting shame"
 *  according to the directions that come with Cards Against Humanity.
 * @since CAH1.0
 * @version CAH1.0
 * @author Holt Maki
 *
 */

public class Rando_Cardrissian extends player{
	
	/**
	 * Creates an object that represents Rando Cardrissian, a fake person who plays a random card every turn when the rules are set to "Rando Cardrissian".
	 * Rando Cardrissian can still score points. If he wins, all of the players are supposed "go home in a state of everlasting shame"
     *  according to the directions that come with Cards Against Humanity.
     *  @since CAH1.0
	 */
	public Rando_Cardrissian() 
	{
		super();
		cardsInHand = new hand(1);
		Card_Czar = false;
		realPerson = false;
		setRandoCard(true);
		name = "Rando Cardrissian";
		userName = "Rando_Card";
	}

}
