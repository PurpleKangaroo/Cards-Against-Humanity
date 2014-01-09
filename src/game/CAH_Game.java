package game;

import java.util.ArrayList;
import java.util.Random;

import cards.Deck;
import cards.DeckBuilder;
import cards.QuestionCard;
import users.Card_Czar_Exception;
import users.Player;
import users.Rando_Cardrissian;
import cards.AnswerCard;

/**
 * A class of object that represents a Cards Against Humanity game.
 * @since CAH1.0(incomplete)
 * @version CAH1.0(Incomplete)
 * @author Holt Maki
 *
 */
public class CAH_Game implements Runnable {
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
	
	/*
	 * Add a draw extra method that allows the hand to contain an extra card during a draw 2 pick 3.
	 */
	
	/*
	 * Add a drawPackingHeat method that allows the players to draw an extra card if the Packing heat rule is in effect.
	 */

	
	/**
	 * Creates an object that represents a Cards Against Humanity game.
	 * @param rules - the set of rules that the game uses.
	 * @param a - the deck builder used to build the deck
	 * right now the deck builder can't change, but eventually will be different
	 *  depending on what expansion decks are used.
	 *  @param players - the players that are playing the game
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
			gameDeck = players.get(i).deal_draw(gameDeck);//Now every player has their hand of cards and these cards have beem taken from the deck.
		}
	}
	
	/**
	 * Adds Rando Cardrissian to the game if the game is being played with the Rule Rando Cardrissian.
	 * @since CAH1.0
	 * @version CAH1.0
	 * 
	 */
	public void addRando()
	{
		if(ruleSet.RandoCardrissianExists())
		{
			//Creats Rando
			Rando_Cardrissian Rando = new Rando_Cardrissian();
			
			//Add Rando Cardrissian to the list
			if (!players.contains(Rando))
			{
				players.add(Rando);
			}
		}
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
	
	/*Add public void playerResume(player resumingPlayer){} a method that will allow players who have left to get
	their hand back and points back
	Add public void replacePlayerWithImpersonator(player leavingPlayer) that allows the player to be replaced by a computer impersonator*/
	
	/**
	 * Deals AnswerCards to all the players.
	 * @since CAH1.0
	 */
	public void deal_Draw()
	{
		for (int i = 0; i<players.size(); i++)
		{
			gameDeck = players.get(i).deal_draw(gameDeck);//Not Sure if this will actually change the player?
		}
	}
	
	/**
	 * Deals AnswerCards to all the players. In this method the players are allowed to temporararily to have more cards in their hand than the limit.
	 * This method may be used in every round as it checks for draw to see if the number of cards to be drawn over the limit.
	 * @since CAH1.0
	 * @param qCard - The {@linkplain QuestionCard} that is being checked for the variable draw. This should be the current question card.
	 */
	public void draw_Extra(QuestionCard qCard)
	{
		int draw = qCard.getDraw();
		if (ruleSet.PackingHeat() && qCard.getDraw()>0)
		{
			draw++;
			for (int i = 0; i<players.size(); i++)
			{
				gameDeck = players.get(i).draw_Extra(gameDeck, draw);//Not Sure if this will actually change the player?
			}
		}
		else if (qCard.getPick()>1)
		{
			for (int i = 0; i<players.size(); i++)
			{
				gameDeck = players.get(i).draw_Extra(gameDeck, draw);//Not Sure if this will actually change the player?
			}
		}
		else
		{
			
		}
			
	}
	
	/**
	 * Gets the question card that the players will be playing answer cards for.
	 * @since CAH1.0
	 * @return currentQuestionCard - The question card that players will be answering.
	 */
	public QuestionCard getQCard()
	{
		roundCount++;
		QuestionCard currentQuestionCard = gameDeck.drawQuestionCard();
		return currentQuestionCard;
	}
	
	/**
	 * Gets the players answer cards that they play.
	 * Scrambles the cards so that the Card Czar doesn't know who played what.
	 * Saves the cards in {@linkplain #answers} so that we know  who played what card.
	 * (Doesnt exist needs to be made)
	 * @param playerCards - the array of arrays containing players card choices
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
	 * @return
	 * @throws PlayerNotFoundException
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

	@Override
	public void run() 
	{
		
		
	}
	
	
	
	
	
}
