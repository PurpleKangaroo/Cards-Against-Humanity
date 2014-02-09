package cards;

import java.util.ArrayList;

/**
 * A type object that represents a card.
 * The type of card is determined by which subclass({@linkplain QuestionCard} or {@linkplain AnswerCard}) is used.
 * The class card by its self is never intended to be used, but is meant to be used for its subclasses constructors and methods.
 * The classes {@linkplain QuestionCard} and {@linkplain AnswerCard} are different because questionCards allow the card to require
 *  the user to play or draw a certain number of cards.
 * @see {@linkplain Deck}, {@linkplain QuestionCard}, {@linkplain AnswerCard}
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public class Card {
	/**
	 * The String that will appear on the card.
	 */
	private String cardString;
	private ArrayList<Tag> tags;
	//TODO Make it so that each prefix & folder will have their own numbering so that multiple decks can be combined without problems.
	
	/**
	 * The cards history.
	 * This includes information about when it is played and when it wins.
	 */
	private CardHistory history;//TODO Make this when the card is created to help the AI understand the cards better
	
	/**
	 * Creates a card.
	 * The type of card is determined by which subclass({@linkplain QuestionCard} or {@linkplain AnswerCard}) is used.
	 * The class card by its self is never intended to be used, but is meant to be used for its subclasses constructors and methods.
	 * The classes {@linkplain QuestionCard} and {@linkplain AnswerCard} are different because questionCards allow the card to require the user to play or draw a certain number of cards.
	 * @param card - the writing that will be on the card. {@link #cardString} = card.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @see {@linkplain AnswerCard}, {@linkplain QuestionCard}
	 */
	public Card(String card)
	{
		cardString = card;
	}
	
	/**
	 * Adds a tag to the card. 
	 * This allows cards to be sorted by the computer so that it can better understand what people find funny.
	 * It is also used by impersonators to best imitate the the person that it is impersonating.
	 * @param {@link #aTag} - the {@linkplain Tag} that will be attached to the card.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 * @param aTag - The {@linkplain Tag} that will be added to the Card.
	 * @see {@linkplain Tag}
	 */
	public void addTag(Tag aTag)
	{
		tags.add(aTag);
	}
	
	/**
	 * Sets {@linkplain #cardString}.
	 * @param cardStr - The string that {@linkplain #cardString} is being set to.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	protected void setCardString(String cardStr)
	{
		cardString = cardStr;
	}
	
	/**
	 * Gets the writing on the card.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 * @return {@linkplain #cardString} - The String that is made up of the text that the card has written on it.
	 */
	public String getCardString()
	{
		return cardString;
	}

}
