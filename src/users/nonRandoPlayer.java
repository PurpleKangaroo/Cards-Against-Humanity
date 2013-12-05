package users;

import cards.deck;
import cards.hand;

/**
 * A class of object that represents all players except for Rando Cardrissian- both humans and computers. Each of these will have their own subclass of player.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see {@linkplain user}
 *
 */
public class nonRandoPlayer extends player
{
	
	/**
	 * Creates a player that is not Rando Cardrissian
	 * @param numberOfCards - the number of cards that the player has.
	 * @since CAH1.0
	 */
	public nonRandoPlayer(int numberOfCards)
	{
		cardsInHand = new hand(numberOfCards);
		Card_Czar = false;
		setRandoCard(false);
	}
	
}
