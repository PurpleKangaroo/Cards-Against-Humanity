package cards;

import import_export.PathFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	private File answers;
	private File questions;
	/**The deck that the DeckBuilder is building */
	private Deck deck;
	private ArrayList<AnswerCard> answerList;
	private ArrayList<QuestionCard> questionList;
	
	/**
	 * Creates an object that will import a file and convert it into a deck of cards
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @since CAH1.0
	 */
	
	@SuppressWarnings("resource")
	public DeckBuilder(Decks[] decklist) throws URISyntaxException, IOException
	{
		PathFinder a = new PathFinder();
		answerList = new ArrayList<AnswerCard>();
		questionList = new ArrayList<QuestionCard>();
		
		for(int i = 0; i < decklist.length; i++)
		{
			String[] AnsPaths = decklist[i].getAnswerPaths();
			String[] QPaths = decklist[i].getQuestionPaths();
			for(int n = 0; n < AnsPaths.length; n++)
			{
				answers = new File(a.getCAH_Path(AnsPaths[n]));
				questions = new File(a.getCAH_Path(QPaths[n]));
				addToDeck();
			}
			
		}
		
		deck = new Deck(answerList, questionList);
	}
	
	private void addToDeck() throws URISyntaxException, IOException
	{
		@SuppressWarnings("resource")
		Scanner answerScanner = new Scanner(answers);
		while(answerScanner.hasNextLine())
		{
			answerList.add(new AnswerCard(answerScanner.nextLine()));
		}
		@SuppressWarnings("resource")
		Scanner questionScanner = new Scanner(questions);
		while(questionScanner.hasNextLine())
		{
			questionList.add(new QuestionCard(questionScanner.nextLine(), "CardInfo", "Q"));
		}
	}
	
	/**
	 * Gets the original card deck as it is at the start of the game.
	 * @return {@link #deck} - the deck at the start of the game.
	 * @since CAH1.0
	 */
	
	public Deck getDeck()
	{
		return deck;
	}

}
