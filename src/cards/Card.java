package cards;

import java.util.ArrayList;

/**
 * A type object that represents a card.
 * The type of card is determined by which subclass({@linkplain questionCard} or {@linkplain answerCard}) is used.
 * The class card by its self is never intended to be used, but is meant to be used for its subclasses constructors and methods.
 * The classes {@linkplain questionCard} and {@linkplain answerCard} are different because questionCards allow the card to require the user to play or draw a certain number of cards.
 * @see {@linkplain deck}, {@linkplain questionCard}, {@linkplain answerCard}, {@linkplain tag}
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public class Card {
	protected String cardString;
	private ArrayList<tag> tags;
	
	/**
	 * Creates a card.
	 * The type of card is determined by which subclass({@linkplain questionCard} or {@linkplain answerCard}) is used.
	 * The class card by its self is never intended to be used, but is meant to be used for its subclasses constructors and methods.
	 * The classes {@linkplain questionCard} and {@linkplain answerCard} are different because questionCards allow the card to require the user to play or draw a certain number of cards.
	 * @param card - the writing that will be on the card. {@link #cardString} = card.
	 * @since CAH1.0
	 * @see {@linkplain answerCard}, {@linkplain questionCard}
	 */
	public Card(String card)
	{
		cardString = card;
	}
	
	/**
	 * Adds a tag to the card. 
	 * This allows cards to be sorted by the computer so that it can better understand what people find funny.
	 * It is also used by impersonators to best imitate the the person that it is impersonating.
	 * @param {@link #aTag} - the {@linkplain tag} that will be attached to the card.
	 * @since CAH1.0
	 * @see {@linkplain tag}
	 */
	
	public void addTag(tag aTag)
	{
		tags.add(aTag);
	}
	
	/**
	 * Gets the writing on the card.
	 * @since CAH1.0
	 * @return {@link #cardString} - The String that is made up of the text that the card has written on it.
	 */
	public String getCardString()
	{
		return cardString;
	}

}
