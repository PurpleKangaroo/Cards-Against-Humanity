package cards;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * A type object that represents a question card (The black cards in Cards Against Humanity).
 * <dl>
 * The classes {@linkplain questionCard} and {@linkplain answerCard} are different because questionCards allow the card to require the user to play or draw a certain number of cards.
 * @see {@linkplain answerCard}, {@linkplain Card}
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public class QuestionCard extends Card{
	private int draw;
	private int pick;
	/**
	 * Creates a question card.
	 * @since CAH1.0
	 * @param {@link #card} - the writing that will be on the card
	 * @throws IOException 
	 * @throws URISyntaxException 
	 * @see {@link #Card(String card)}
	 */
	public QuestionCard(String card, String folder, String filePrefix) throws URISyntaxException, IOException 
	{
		super(card, folder, filePrefix);
		draw = 0;
		pick = 1;
		String card1 = card + "";
		if (card.contains("{p"))
		{
			String cardSub = card.substring(card.indexOf("{p"));
			cardSub = cardSub.substring(2, cardSub.indexOf("}"));
			pick = Integer.parseInt(cardSub);
			card1 = card.substring(0,card.indexOf("{") -1);
		}
		if (card.contains("{d"))
		{
			String cardSub = card.substring(card.indexOf("{d"));
			cardSub = cardSub.substring(2, cardSub.indexOf("}"));
			draw = Integer.parseInt(cardSub);
			card1 = card.substring(0,card.indexOf("{") -1);
		}
		cardString = card1;
		cardString = cardString.replaceAll("[LINE]", "\n\n");
	}
	/**
	 * Gets the number of cards that will be drawn by each player at the begining of the turn.
	 * @return draw - the number of cards that each player will draw
	 * @since CAH1.0
	 */
	public int getDraw()
	{
		return draw;
	}
	/**
	 * Gets the number of cards that will be picked by each player.
	 * @return pick - the number of cards that each player will pick.
	 * @since CAH1.0
	 */
	public int getPick()
	{
		return pick;
	}
	
}