package userInterface;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import game.*;

import javax.swing.JPanel;

import users.Player;
import cards.DeckBuilder;

/**
 * A class of object that represents the start screen for Cards Against Humanity.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class CAH_Panel_START extends JPanel 
{
	/**A list of the players playing in the game*/
	private ArrayList<Player> players;
	/**The list of house rules that the game is using.*/
	private ArrayList<HouseRules> houseRules;
	
	public CAH_Panel_START()
	{
		players = new ArrayList<Player>();
		houseRules = new ArrayList<HouseRules>();
	}
	
	public CAH_Game getGame() throws RuleConflictException, URISyntaxException, IOException
	{
		//Have the thing wait until the user clicks  start.
		//TODO Create each part of the game.
		//TODO deal with rule conflict exception by telling it that that is not a valid input.
		return new CAH_Game(new Rules(houseRules), new DeckBuilder(), players);
	}
	
}
