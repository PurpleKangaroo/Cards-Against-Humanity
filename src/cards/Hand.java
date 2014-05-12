package cards;

import java.util.ArrayList;

/**
 * An object that represents a hand of cards.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see Card
 * @see AnswerCard
 * @see QuestionCard
 * @see Deck
 * @see User
 */

public class Hand {
	private ArrayList<AnswerCard> cards;
	/**The number of cards that will normally be in the players hand */
	private int max;
	
	/**
	 * Creates a hand of cards
	 * @param limit the number of cards that should be in the players hand at the end of their turn after drawing
	 * @since CAH1.0
	 */
	
	public Hand(int limit)
	{
		max = limit;
	}
	
	/**
	 * Draws cards, allowing for more cards than the defult number of cards to be drawn.
	 * @since CAH1.0
	 * @param a the Deck that the cards are dealt from
	 * @param numberOfCardsOverLimit the number of cards over the limit that will be drawn
	 * @return a - the Deck that the cardes are dealt from after the cards have been removed from it
	 */
	public Deck deal_draw(Deck a, int numberOfCardsOverLimit)
	{
		int newLimit = cards.size() + numberOfCardsOverLimit;
		while (cards.size() < newLimit)
		{
			cards.add(a.drawAnswerCard());
		}
		return a;
	}
	
	/**
	 * Removes an AnswerCard from the hand and returns it so that it may be played
	 * @param a The AnswerCard that will be removed and played.
	 * @return a - the AnswerCard that will be played.
	 * @since CAH1.0
	 */
	public AnswerCard playCard(AnswerCard a)
	{
		cards.remove(a);
		return a;
	}
	
	/**
	 * Gets an answer card at specified index
	 * @param index the index of the card on the arrayList
	 * @return card - the AnswerCard at the specified index
	 * @since CAH1.0
	 */
	public AnswerCard get(int index)
	{
		return cards.get(index);
	}
	
	public int getSize()
	{
		return cards.size();
	}
}
