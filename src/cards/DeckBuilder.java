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
	public DeckBuilder() throws URISyntaxException, IOException
	{
		PathFinder a = new PathFinder();
		answerList = new ArrayList<AnswerCard>();
		questionList = new ArrayList<QuestionCard>();
		answers = new File(a.getCAH_Path("/Cards Against Humanity/src/cards/Answers"));
		questions = new File(a.getCAH_Path("/Cards Against Humanity/src/cards/Questions"));
		Scanner answerScanner = new Scanner(answers);
		while(answerScanner.hasNextLine())
		{
			answerList.add(new AnswerCard(answerScanner.nextLine()));
		}
		Scanner questionScanner = new Scanner(questions);
		while(questionScanner.hasNextLine())
		{
			questionList.add(new QuestionCard(questionScanner.nextLine(), "CardInfo", "Q"));
		}
		deck = new Deck(answerList, questionList);
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
