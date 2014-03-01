package game;

import java.util.ArrayList;
import java.util.Random;

import cards.Deck;
import cards.DeckBuilder;
import cards.QuestionCard;
import users.Card_Czar_Exception;
import users.Player;
import cards.AnswerCard;

/**
 * A class of object that represents a Cards Against Humanity game.
 * @since CAH1.0
 * @version CAH1.0
 * @author Holt Maki
 *
 */
public class CAH_Game {
	/**The set of rules that the game will use */
	private Rules ruleSet;
	/**The list of players playing the game */
	private ArrayList<Player> players;
	/** This is the deck that the game is played with */
	private Deck gameDeck;
	/**The Array of array lists of Cards played by each player that keeps track of who played what card 
	 * The 2D aspect of it is to make it work for pick 2's and pick 3's*/
	private AnswerCard[][] answers;
	/**Serves as a counter for which player is card czar */
	private int CzarCount;
	/**Serves as a counter for the number of rounds of CAH that have been played */
	private int roundCount;
	/**Says if its the first time through*/
	private boolean first;
	/**
	 * The current question card being used.
	 */
	private QuestionCard currentQCard;
	
	/**
	 * Creates an object that represents a Cards Against Humanity game.
	 * @param rules the set of rules that the game uses.
	 * @param a the deck builder used to build the deck
	 * right now the deck builder can't change, but eventually will be different
	 * depending on what expansion decks are used.
	 * @param players the players that are playing the game
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	public CAH_Game(Rules rules, DeckBuilder a, ArrayList<Player> players)
	{
		this.players = players;
		ruleSet = rules;
		gameDeck = a.getDeck();
		first = true;
		roundCount = 0;
		for(int i = 0; i < players.size(); i++)
		{
			gameDeck = players.get(i).deal_draw(gameDeck, 0);//Now every player has their hand of cards and these cards have been taken from the deck.
		}
		//TODO remove "make a haiku card" if happy ending rule in effect
	}
	
	/**
	 * Adds a player to the game.
	 * @param newPlayer - the player that will be added
	 * @since CAH1.0;
	 */
	public void addPlayer(Player newPlayer)
	{
		players.add(newPlayer);
	}
	
	/**
	 * Removes a player from the game.
	 * <ul>
	 * NOTE: The game needs to store the points of the player so that if the player wants to join again they get back their points
	 * </ul>
	 * @since CAH1.0(Incomplete method) - see coments
	 * @param leavingPlayer - The player that is leaving the game.
	 */
	public void removePlayer(Player leavingPlayer)
	{
		players.remove(leavingPlayer);
		//add playerSaving stuff.
	}
	
	/**
	 * Carries out the draw phase of a Cards Against Humanity game.
	 * @since CAH1.0
	 * @see CAH_Game#drawQCard()
	 * @see CAH_Game#deal_Draw()
	 */
	public void drawPhase()
	{
		roundCount++;
		drawQCard();
		deal_Draw();
	}
	
	/**
	 * Carries out the answer phase of a Cards Against Humanity game, where all players,
	 * except the card czar answer the {@linkplain CAH_Game#currentQCard}.
	 * @since CAH1.0
	 */
	public void answerPhase()
	{
		//TODO: fill
	}
	
	/**
	 * Carries out the choose phase of a Cards Against Humanity game, where the Card Czar chooses their favorite card, unless if
	 * {@linkplain HouseRules#GOD_IS_DEAD}, {@linkplain HouseRules#SERIOUS_BUSINESS}, or {@linkplain HouseRules#SURVIVAL_OF_THE_FITTEST} is in effect.
	 * <p>
	 * <ul>
	 * <li><em>If </em> {@linkplain HouseRules#GOD_IS_DEAD} is in effect: Each player picks his or her favorite card each round, and the card with the most votes will win the round.</li>
	 * <li><em>If </em> {@linkplain HouseRules#SERIOUS_BUSINESS} is in effect: The card Czar will rank the top three cards. The best one will receive the 3 Awesome Points, the second best will receive 2, and the third best will receive 1 Awesome Point.</li>
	 * <li><em>If </em> {@linkplain HouseRules#SURVIVAL_OF_THE_FITTEST} is in effect: After everyone has answered the question, players take turns eliminating one card each. The last remaining card is declared the funniest.</li>
	 * </ul>
	 * </p>
	 */
	public void choosePhase()
	{
		//TODO: fill
	}
	
	/*Add public void playerResume(player resumingPlayer){} a method that will allow players who have left to get
	their hand back and points back
	Add public void replacePlayerWithImpersonator(player leavingPlayer) that allows the player to be replaced by a computer impersonator*/
	
	/**
	 * Deals AnswerCards to all the players.
	 * @since CAH1.0
	 */
	private void deal_Draw()
	{
		int draw = ruleSet.PackingHeat() && currentQCard.getDraw() != 1 ? currentQCard.getDraw() + 1: currentQCard.getDraw();
		
		for (int i = 0; i<players.size(); i++)
		{
			gameDeck = players.get(i).deal_draw(gameDeck, draw);
		}
	}
	
	/**
	 * Draws the question card that the players will be playing answer cards for.
	 * @since CAH1.0
	 * @return currentQuestionCard - The question card that players will be answering.
	 */
	private void drawQCard()
	{
		if(ruleSet.HappyEnding())
		{
			currentQCard = gameDeck.drawQuestionCardHappyEnding();
		}
		else
		{
			currentQCard = gameDeck.drawQuestionCard();
		}
	}
	
	/**
	 * Gets the current question card.
	 * @return currentQCard - the current question card.
	 * @since CAH1.0
	 */
	public QuestionCard getCurrentQuestionCard()
	{
		return currentQCard;
	}
	
	/**
	 * Gets the players answer cards that they play.
	 * Scrambles the cards so that the Card Czar doesn't know who played what.
	 * Saves the cards in {@linkplain #answers} so that we know  who played what card.
	 * (Doesnt exist needs to be made)
	 * @param playerCards the array of arrays containing players card choices
	 * @return scrPlayerCards - the answer cards that are played by each player.
	 * @since CAH1.0
	 */
	public AnswerCard[][] getAnswerCards(int[][] playerCards)
	{
		AnswerCard[][] scrPlayerCards = new AnswerCard[players.size()][];
		AnswerCard[][] unscrPlayerCards = new AnswerCard[players.size()][];
		ArrayList<AnswerCard[]> Scramble = new ArrayList<AnswerCard[]>();
		for(int i = 0; i<players.size(); i++)
		{
			for (int n = 0; n<playerCards[i].length; n++)
			{
				answers[i][n] = players.get(i).playCard(playerCards[i][n]);
				unscrPlayerCards[i][n] = players.get(i).playCard(playerCards[i][n]);
			}
			Scramble.add(unscrPlayerCards[i]);
		}
		for(int i = 0; i<Scramble.size();)//There is no counter because Scramble.size-- automatically each time by having an element removed
		{
			Random b = new Random();
			int index = b.nextInt(Scramble.size());
			scrPlayerCards[i] = Scramble.get(index);
			Scramble.remove(index);
		}
		return scrPlayerCards;
	}
	
	/**
	 * Gives points to the player that played the winning answer card.
	 * @since CAH1.0
	 * @param winner - the winning AnswerCard.
	 * @throws CardNotFoundException thrown if the AnswerCard[] that is a paramater is not found in answers.
	 */
	public void scorePoints(AnswerCard[] winner) throws CardNotFoundException
	{
		boolean found = false;
		int number = -1;
		for (int i = 0; i<players.size() && !found; i++)
		{
			if (winner.equals(answers[i]));
			{
				found = true;
				number = i;
			}
		}
		if (!found)
		{
			CardNotFoundException cardNotFound = new CardNotFoundException();
			throw cardNotFound;
		}
		if (found == true && number>= 0)
		{
			players.get(number).scoreAwesomePoints(1);
		}
	}
	
	/**
	 * Gives a different amount of points to the first(3 points), second(2 points), third (one point) in a {@linkplain HouseRules#SERIOUS_BUSINESS} game.
	 * @param first
	 * @since CAH1.0
	 * @param second
	 * @param third
	 * @throws CardNotFoundException
	 */
	public void seriousBuisnessPoints(AnswerCard[] first, AnswerCard[] second, AnswerCard[]third) throws CardNotFoundException
	{
		//First Player
		boolean found = false;
		int number = -1;
		for (int i = 0; i<players.size() && !found; i++)
		{
			if (first.equals(answers[i]));
			{
				found = true;
				number = i;
			}
		}
		if (!found)
		{
			CardNotFoundException cardNotFound = new CardNotFoundException();
			throw cardNotFound;
		}
		if (found == true && number>= 0)
		{
			players.get(number).scoreAwesomePoints(3);
		}
		
		//Second Player
		found = false;
		number = -1;
		for (int i = 0; i<players.size() && !found; i++)
		{
			if (second.equals(answers[i]));
			{
				found = true;
				number = i;
			}
		}
		if (!found)
		{
			CardNotFoundException cardNotFound = new CardNotFoundException();
			throw cardNotFound;
		}
		if (found == true && number>= 0)
		{
			players.get(number).scoreAwesomePoints(2);
		}
		
		//Third Player
		found = false;
		number = -1;
		for (int i = 0; i<players.size() && !found; i++)
		{
			if (first.equals(answers[i]));
			{
				found = true;
				number = i;
			}
		}
		if (!found)
		{
			CardNotFoundException cardNotFound = new CardNotFoundException();
			throw cardNotFound;
		}
		if (found == true && number>= 0)
		{
			players.get(number).scoreAwesomePoints(2);
		}
	}

	/**
	 * Makes the next player cardCzar.
	 * @since CAH1.0
	 * @return players.get(cardCzarIndex) - the player that is the cardCzar.
	 * @throws Card_Czar_Exception thrown if the player is already cardCzar or is not cardCzar and is made cardCzar or made not cardCzar
	 */
	public void nextCardCzar() throws Card_Czar_Exception
	{
		if (first)
		{
			Random a = new Random();
			int start = a.nextInt(players.size());
			if (!players.get(start).getRandoCard())
			{
				players.get(start).isCard_Czar();
			}
			else
			{
				start++;
				start = players.size() - (start%players.size());
				players.get(start).isCard_Czar();
			}
			CzarCount = start;
			first = false;
		}
		else
		{
			if (!players.get(CzarCount).getRandoCard())
			{
				players.get(CzarCount).isCard_Czar();
			}
			else
			{
				CzarCount++;
				CzarCount = players.size() - CzarCount%players.size();
				players.get(CzarCount).isCard_Czar();
			}
			CzarCount++;
			CzarCount = players.size() - (CzarCount%players.size());
		}
	}
	
	/**
	 * Gets the current cardCzar
	 * @return {@code currentQCard = gameDeck.drawQuestionCard()} - The player who is the current card czar.
	 * @throws PlayerNotFoundException If the player is not found.
	 */
	public Player getCurrentCardCzar() throws PlayerNotFoundException
	{
		int cardCzarIndex = -1;
		boolean found = false;
		for (int i = 0; !found && i<players.size(); i++)
		{
			if (players.get(i).getCard_Czar())
			{
				cardCzarIndex = i;
				found = true;
			}
		}
		if (!found)
		{
			PlayerNotFoundException PlayerNotFound = new PlayerNotFoundException();
			throw PlayerNotFound;
		}
		else
		{
			return players.get(cardCzarIndex);
		}
				
	}
	
	/**
	 * Gets the current round number.
	 * @return RoundCount - the round number of the game
	 * @since CAH1.0
	 */
	public int getRoundCount()
	{
		return roundCount;
	}
	
	/**
	 * Gets the players' awesome points.
	 * @return awesomePointArray - the players' awesome point tallies in the form of an array of integers ordered based on the players numbers.
	 * @since CAH1.0
	 */
	public int[] getAwesomePoints()
	{
		int[] awesomePointArray = new int[players.size()];
		for (int i = 0; i<players.size(); i++)
		{
			awesomePointArray[i] = players.get(i).getAwesomePoints();
		}
		return awesomePointArray;
	}
	
	/**
	 * Gets the list of players involved in a game of CAH.
	 * @return players - The list of players involved in a game of CAH.
	 * @since CAH1.0
	 */
	public ArrayList<Player> getPlayers()
	{
		return players;
	}	
	
}
