package cards;

import import_export.pathFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * An object that creates decks.
 * @version CAH1.0
 * @since CAH1.0
 * @author Holt Maki
 * @see {@linkplain deck}, {@linkplain Card}, {@linkplain expansionDeckBuilder}
 *
 */

public class deckBuilder {
	private File answers;
	private File questions;
	private deck originalDeck;
	private ArrayList<answerCard> answerList;
	private ArrayList<questionCard> questionList;
	
	/**
	 * Creates an object that will import a file and convert it into a deck of cards
	 * @throws FileNotFoundException
	 * @throws URISyntaxException 
	 * @since CAH1.0
	 */
	
	@SuppressWarnings("resource")
	public deckBuilder() throws FileNotFoundException, URISyntaxException
	{
		pathFinder a = new pathFinder();
		answerList = new ArrayList<answerCard>();
		questionList = new ArrayList<questionCard>();
		answers = new File(a.getCAH_Path("E:/Programs/Program Files/Eclipse Workspaces/Eclipse Files/Cards Against Humanity/src/cards/Answers"));
		questions = new File(a.getCAH_Path("E:/Programs/Program Files/Eclipse Workspaces/Eclipse Files/Cards Against Humanity/src/cards/Answers"));
		Scanner answerScanner = new Scanner(answers);
		while(answerScanner.hasNextLine())
		{
			answerList.add(new answerCard(answerScanner.nextLine()));
		}
		Scanner questionScanner = new Scanner(questions);
		while(questionScanner.hasNextLine())
		{
			questionList.add(new questionCard(questionScanner.nextLine()));
		}
		originalDeck = new deck(answerList, questionList);
	}
	
	/**
	 * Gets the original card deck as it is at the start of the game.
	 * @return {@link #originalDeck} - the deck at the start of the game.
	 * @since CAH1.0
	 */
	
	public deck getOriginalDeck()
	{
		return originalDeck;
	}

}
