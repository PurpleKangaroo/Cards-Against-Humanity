package cards;

import java.io.IOException;
import java.net.URISyntaxException;

import users.Card_Czar_Exception;

/**
 * A type object that represents an answer card (The white cards in Cards Against Humanity).
 * <dl>
 * The classes {@linkplain QuestionCard} and {@linkplain AnswerCard} are different because QuestionCards 
 * allow the card to require the user to play or draw a certain number of cards.
 * @see {@linkplain QuestionCard}, {@linkplain Card}
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */

public class AnswerCard extends Card
{

	/**
	 * Creates an answer card
	 * @param card - the string that the card will have as its cardString.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @param {@link #card} - the writing that will be on the card
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @see {@link #Card(String card)}
	 */
	public AnswerCard(String card) throws URISyntaxException, IOException 
	{
		super(card);
		String card1 = card + "";
		card1 = card1.replaceAll("[LINE]", "\n\n"); //TODO encoder
		setCardString(card1);		
	}

}
