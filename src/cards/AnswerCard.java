package cards;

import import_export.Encoder;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * A type object that represents an answer card (The white cards in Cards Against Humanity).
 * <dl>
 * The classes {@linkplain QuestionCard} and {@linkplain AnswerCard} are different because QuestionCards 
 * allow the card to require the user to play or draw a certain number of cards.
 * @see  QuestionCard
 * @see Card
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */

public class AnswerCard extends Card
{
	private String username;

	/**
	 * Creates an answer card
	 * @param card - the string that the card will have as its cardString.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public AnswerCard(String card) throws URISyntaxException, IOException 
	{
		super(card);
		String card1 = card + "";
		card1 = card1.replaceAll("<LINE>", "\n\n"); //TODO encoder
		Encoder encode = new Encoder();
		setCardString(encode.encode(card1));
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String a)
	{
		username = a;
	}

}
