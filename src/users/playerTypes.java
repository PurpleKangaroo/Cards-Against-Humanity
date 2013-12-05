package users;

import game.HouseRules;
/**
 * A list of different types of players.
 * @author Holt Maki
 * @version CAH1.0
 * @since CAH1.0
 *
 */
public enum playerTypes {
	/**
	 * A computer player
	 * @since CAH1.0
	 * @see {@linkplain AIPlayer}
	 */
	AIPLAYER,
	
	/**
	 * A player that is controled by the computer and attempts to impersonate a specific real human.
	 * @since CAH1.0
	 * @see 
	 */
	IMPERSONATOR,
	
	/**
	 * An imaginary player that plays a random card from the deck.
	 * @since CAH1.0
	 * @see {@linkplain HouseRules} - RANDO_CARDRISSIAN, {@linkplain Rando_Cardrissian}
	 */
	RANDO_CARDRISSIAN,
	
	/**
	 * A player that is controled by a real human.
	 * @since CAH1.0
	 * @see {@linkplain humanPlayer}
	 */
	HUMAN_PLAYER;

}
