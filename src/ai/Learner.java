package ai;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import cards.AnswerCard;
import cards.QuestionCard;
import users.HumanPlayer;
import users.User;
import java.util.ArrayList;

//TODO - Idea, create an email that gets these statistics emailed to it.
//TODO - IEDA: Create a twitter bot that tweets a random winning card combonaton every few minutes. EVENTALLY AFTER MANY UPDATES

/**
 * A class of object that learns what people find humerous and saves the data to a text file.
 * @version CAH1.0
 * @since CAH1.0
 * @author Holt Maki
 *
 */
public class Learner
{
	/**
	 * Creates a class of object that can learn.
	 * @since CAH1.0
	 */
	public Learner()
	{
		
	}
	
	/**
	 * Saves stats from a card being played into a text file.
	 * @param aUser - The user that played the card.
	 * @param aCard - The answer card played.
	 * @param qCard - The question card played.
	 * @since incomplete
	 */
	public void cardPlayed(HumanPlayer player, AnswerCard aCard, QuestionCard qCard)
	{
		//Get the player's hand to see what the player chose the card over.
		User aUser = player.getUser();
		//Get information from the user, get cards tag, etc. find a way to keep stats.
	}

	/**
	 * Saves stats from a card that is chosen by the card czar into a text file.
	 * @param cardCzar - The Card Czar who chose the card.
	 * @param aCard - The AnswerCard that the Card Czar chose.
	 * @param options - The cards that the Card Czar could have chosen from.
	 * @param qCard - The QuestionCard.
	 */
	public void cardWon(HumanPlayer cardCzar, AnswerCard aCard, ArrayList<AnswerCard> options, QuestionCard qCard)
	{
		User cardCzarUser = cardCzar.getUser();
		//Get information from the user, get cards tag, etc. find a way to keep stats.
	}
	
	//TODO make other card won methods and other methods that colect data on games that do not use the normal rules.
	
	/**
	 * Saves stats when a card is eliminated in a game with the rules "Survival of the Fittest"
	 * @param eliminator - The player who eliminated the card.
	 * @param aCard - The AnswerCard that was eliminated.
	 * @param options - The cards that could have been eliminated.
	 * @param qCard - The QuestionCard.
	 */
	public void cardEliminated(HumanPlayer eliminator, AnswerCard aCard, ArrayList<AnswerCard> options, QuestionCard qCard)
	{
		User elimUser = eliminator.getUser();
		
	}
	
	/**
	 * Saves stats when cards are voted on in a game with the rules "God Is Dead"
	 * @param voters - The HumanPlayers who voted on the card.
	 * @param aCard - The Answer Card that was voted on
	 * @param options - The cards that people had to pick from.
	 * @param qCard - The QuestionCard.
	 */
	public void cardVotedOn(ArrayList<HumanPlayer> voters, AnswerCard aCard, ArrayList<AnswerCard> options, QuestionCard qCard, int humanVotesFor, int humanVotesAgainst)
	{
		//Find a way to collectively get the voters profiles.
	}
	
}
