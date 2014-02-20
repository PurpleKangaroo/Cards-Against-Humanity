package cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * An object that creates decks.
 * @version CAH1.0
 * @since CAH1.0
 * @author Holt Maki
 * @see {@linkplain Deck}, {@linkplain Card}
 *
 */

public class DeckBuilder {
	
	private Scanner answers;
	private Scanner questions;
	/**The deck that the DeckBuilder is building */
	private Deck deck;
	private ArrayList<AnswerCard> answerList;
	private ArrayList<QuestionCard> questionList;
	
	/**
	 * Creates an object that will import a file and convert it into a deck of cards
	 * @param decklist the list of subdecks that the deck that the deckbuilder is building will contain.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	
	public DeckBuilder(Decks[] decklist) throws URISyntaxException, IOException
	{
		answerList = new ArrayList<AnswerCard>();
		questionList = new ArrayList<QuestionCard>();
		
		for(int i = 0; i < decklist.length; i++)
		{
			String[] AnsPaths = decklist[i].getAnswerPaths();
			String[] QPaths = decklist[i].getQuestionPaths();
			for(int n = 0; n < AnsPaths.length; n++)
			{
				answers = new Scanner(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(AnsPaths[i]))));
				questions = new Scanner(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(QPaths[i]))));
				addToDeck();
			}
			
		}
		
		deck = new Deck(answerList, questionList);
	}
	
	/**
	 * Adds the cards to the deck.
	 * @throws URISyntaxException
	 * @throws IOException
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	private void addToDeck() throws URISyntaxException, IOException
	{
		while(answers.hasNextLine())
		{
			answerList.add(new AnswerCard(answers.nextLine()));
		}
		while(questions.hasNextLine())
		{
			questionList.add(new QuestionCard(questions.nextLine(), "CardInfo", "Q"));
		}
	}
	
	/**
	 * Gets the original card deck as it is at the start of the game.
	 * @return Deck - the {@linkplain Deck} at the start of the game.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	
	public Deck getDeck()
	{
		return deck;
	}

}
