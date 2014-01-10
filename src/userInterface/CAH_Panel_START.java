package userInterface;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import game.*;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;

import users.Player;
import cards.DeckBuilder;

/**
 * A class of object that represents the start screen for Cards Against Humanity.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
@SuppressWarnings("serial")
public class CAH_Panel_START extends JPanel 
{
	//TODO add tool tips for the tools, especially for when someone has an invalid set of rules.
	/**The slider that is used to choose how many players with each player chosen
	 *  a new bordered area with swing tools that allow player setup will be added.
	 *  This bordered area will include information such as if the player is a computer,
	 *  and maybe their username or IP. (maybe we can have them send that information automatically to the
	 *  computer which will display it when the user connects.*/
	private JSlider numberOfPlayerSlider;
	/**A list of the players playing in the game*/
	private ArrayList<Player> players;
	/**The list of house rules that the game is using.*/
	private ArrayList<HouseRules> houseRules;
	
	/**
	 * Creates an object that represents the start screen for Cards Against Humanity.
	 */
	public CAH_Panel_START()
	{
		super();
		
		JCheckBox happyEnding = new JCheckBox("Happy Ending");
		JCheckBox rebootingTheUniverse = new JCheckBox("Rebooting the Universe");
		JCheckBox packingHeat = new JCheckBox("Packing Heat");
		JCheckBox randoCardrissian = new JCheckBox("Rando Cardrissian");
		JCheckBox godIsDead = new JCheckBox("God Is Dead");
		JCheckBox survivalOfTheFittest = new JCheckBox("Survival of the Fittest");
		JCheckBox seriousBuisness = new JCheckBox("Serious Buisness");
		JCheckBox neverHaveIEver = new JCheckBox("Never Have I Ever");
		
		HashMap<JCheckBox, HouseRules> ruleCheckBoxes = new HashMap<JCheckBox, HouseRules>();
		ruleCheckBoxes.put(happyEnding, HouseRules.HAPPY_ENDING);
		ruleCheckBoxes.put(rebootingTheUniverse, HouseRules.REBOOTING_THE_UNIVERSE);
		ruleCheckBoxes.put(packingHeat, HouseRules.PACKING_HEAT);
		ruleCheckBoxes.put(randoCardrissian, HouseRules.RANDO_CARDRISSIAN);
		ruleCheckBoxes.put(godIsDead, HouseRules.GOD_IS_DEAD);
		ruleCheckBoxes.put(survivalOfTheFittest, HouseRules.SURVIVAL_OF_THE_FITTEST);
		ruleCheckBoxes.put(seriousBuisness, HouseRules.SERIOUS_BUSINESS);
		ruleCheckBoxes.put(neverHaveIEver, HouseRules.NEVER_HAVE_I_EVER);
		
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
