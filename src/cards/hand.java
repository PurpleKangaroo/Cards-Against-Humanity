package cards;

import java.util.ArrayList;

/**
 * An object that represents a hand of cards.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see {@linkplain Card}, {@linkplain answerCard}, {@linkplain questionCard}, {@linkplain deck}, {@linkplain user}
 */

public class hand {
	private ArrayList<answerCard> cards;
	/**The number of cards that will normaly be in the players hand */
	private int max;
	
	/**
	 * Creates a hand of cards
	 * @param limit - the number of cards that should be in the players hand at the end of their turn after drawing
	 * @since CAH1.0
	 */
	
	public hand(int limit)
	{
		max = limit;
	}
	
	/**
	 * Deals cards at the begining of a game and draws cards at the end of each turn.
	 * @since CAH1.0
	 * @param a - the deck that the cards are dealt from
	 * @return a - the deck that the cardes are dealt from after the cards have been removed from it
	 */
	
	public deck deal_draw(deck a)
	{
		while (cards.size() <= max)
		{
			cards.add(a.drawAnswerCard());
		}
		return a;
	}
	
	
	/**
	 * Draws more cards than the limit in the middle of a turn.
	 * @since CAH1.0
	 * @param a - the deck that the cards are dealt from
	 * @param numberOfCardsOverLimit - the number of cards over the limit that will be drawn
	 * @return a - the deck that the cardes are dealt from after the cards have been removed from it
	 */
	public deck exceedLimitDraw(deck a, int numberOfCardsOverLimit)
	{
		int newLimit = cards.size() + numberOfCardsOverLimit;
		while (cards.size() >= newLimit)
		{
			cards.add(a.drawAnswerCard());
		}
		return a;
	}
	
	/**
	 * Removes an answerCard from the hand and returns it so that it may be played
	 * @param a - The answerCard that will be removed and played.
	 * @return a - the answerCard that will be played.
	 * @since CAH1.0
	 */
	public answerCard playCard(answerCard a)
	{
		cards.remove(a);
		return a;
	}
	
	/**
	 * Gets an answer card at specified index
	 * @param index - the index of the card on the arrayList
	 * @return card - the answerCard at the specified index
	 * @since CAH1.0
	 */
	public answerCard get(int index)
	{
		return cards.get(index);
	}
}
