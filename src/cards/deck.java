package cards;

import java.util.ArrayList;
import java.util.Random;

/**
 * A type of object that represents a set of two decks.
 * The decks are made of the cards in the ArrayLists aDeck, which contains AnswerCards, and qDeck, which contains QuestionCards. 
 * @author Holt Maki
 * @version CAH1.0
 * @since CAH1.0
 * @see {@linkplain deckBuilder}, {@linkplain Card}
 *
 */

public class Deck {
	private ArrayList<QuestionCard> qDeck;
	private ArrayList<AnswerCard> aDeck;
	
	/**
	 * Creates a set of two decks in the form of arrayLists
	 * There is an arrayList of AnswerCards and an arrayList of QuestionCards.
	 * @param a - the contents of the answer card deck
	 * @param q - the contents of the question card deck
	 * @since CAH1.0
	 */
	public Deck(ArrayList<AnswerCard> a, ArrayList<QuestionCard> q)
	{
		aDeck = a;
		qDeck = q;
	}
	
	/**
	 * Draws an answer card
	 * Removes the card that is drawn from the deck
	 * @return card - The answer card that is drawn
	 * @since CAH1.0
	 * @see {@link #drawQuestionCard()}
	 */
	
	public AnswerCard drawAnswerCard()
	{
		Random randomNumbers = new Random();
		int index = randomNumbers.nextInt(aDeck.size());
		AnswerCard card = aDeck.get(index);
		aDeck.remove(index);
		return card;
	}
	
	/**
	 * Draws a question card
	 * Removes the card that is drawn from the deck
	 * @return card - The question card that is drawn
	 * @since CAH1.0
	 * @see {@link #drawAnswerCard()}
	 */

	public QuestionCard drawQuestionCard()
	{
		Random randomNumbers = new Random();
		int index = randomNumbers.nextInt(qDeck.size());
		QuestionCard card = qDeck.get(index);
		qDeck.remove(index);
		return card;
	}

}
