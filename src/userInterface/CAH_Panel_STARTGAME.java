package userInterface;

import game.CAH_Game;
import game.HouseRules;
import game.RuleConflictException;
import game.Rules;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
public class CAH_Panel_STARTGAME extends JPanel 
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
	private ArrayList<HouseRules> houseRulesList;
	/**A HashMap of all the check boxes and the house rules that they represent.*/
	private HashMap<JCheckBox, HouseRules> ruleCheckBoxesMap;
	
	/**
	 * Creates an object that represents the start screen for Cards Against Humanity.
	 */
	public CAH_Panel_STARTGAME()
	{
		//TODO idea allow people to make and add custom decks.
		//TODO idea alow people to save game settings.
		//TODO get the checkbox that is checked by having the program look at which checkboxes are clicked when the user hits the start button.
		//TODO get tooltips to work
		//FIXME Fix the layout.
		//FIXME make it work when its both maximized and restored.
		//TODO add background
		//Idea in a start menu have the background be one that shows good random (or maybe selected but in a ramdom order) combinations of cards.
		//TODO  nice moving background, it needs to look better
		super();
		
		JCheckBox happyEnding = new JCheckBox("Happy Ending");
		JCheckBox rebootingTheUniverse = new JCheckBox("Rebooting the Universe");
		JCheckBox packingHeat = new JCheckBox("Packing Heat");
		JCheckBox randoCardrissian = new JCheckBox("Rando Cardrissian");
		JCheckBox godIsDead = new JCheckBox("God Is Dead");
		JCheckBox survivalOfTheFittest = new JCheckBox("Survival of the Fittest");
		JCheckBox seriousBuisness = new JCheckBox("Serious Buisness");
		JCheckBox neverHaveIEver = new JCheckBox("Never Have I Ever");
		
		JCheckBox[] ruleBoxes = {happyEnding, rebootingTheUniverse, packingHeat, randoCardrissian, godIsDead, survivalOfTheFittest, seriousBuisness, neverHaveIEver};
		
		JCheckBox originalCAHDeck = new JCheckBox("Original");//TODO add tool tips to these
		//TODO set the default setting as checked for the original CAH deck
		JCheckBox expansion1 = new JCheckBox("Expansion 1");//TODO have an option for just 1.0, just 1.2, or both.
		JCheckBox expansion2 = new JCheckBox("Expansion 2");
		JCheckBox expansion3 = new JCheckBox("Expansion 3");
		JCheckBox expansion4 = new JCheckBox("Expansion 4");
		JCheckBox holidayExpansion = new JCheckBox("Holiday Expansion");
		
		JCheckBox[] deckBoxes = {originalCAHDeck, expansion1, expansion2, expansion3, expansion4, holidayExpansion};
		
		JPanel decks = new JPanel();
		
		for (int i = 0; i<deckBoxes.length; i++)
		{
			if (i<3)//TODO have these boxes added to the upper part
			{
				decks.add(deckBoxes[i]);
			}
			
			else//TODO ... and these added to the lower part
			{
				decks.add(deckBoxes[i]);
			}
		}
		
		decks.setBorder(BorderFactory.createTitledBorder("Decks"));
		//TODO add a tool tip that comes up when the mouse is over the title that says "select the decks you want your game to use"
		
		HashMap<JCheckBox, HouseRules> ruleCheckBoxesMap = new HashMap<JCheckBox, HouseRules>();
		
		ruleCheckBoxesMap.put(happyEnding, HouseRules.HAPPY_ENDING);
		ruleCheckBoxesMap.put(rebootingTheUniverse, HouseRules.REBOOTING_THE_UNIVERSE);
		ruleCheckBoxesMap.put(packingHeat, HouseRules.PACKING_HEAT);
		ruleCheckBoxesMap.put(randoCardrissian, HouseRules.RANDO_CARDRISSIAN);
		ruleCheckBoxesMap.put(godIsDead, HouseRules.GOD_IS_DEAD);
		ruleCheckBoxesMap.put(survivalOfTheFittest, HouseRules.SURVIVAL_OF_THE_FITTEST);
		ruleCheckBoxesMap.put(seriousBuisness, HouseRules.SERIOUS_BUSINESS);
		ruleCheckBoxesMap.put(neverHaveIEver, HouseRules.NEVER_HAVE_I_EVER);
		
		JPanel houseRules = new JPanel();//TODO initialize with a layout that allows two lines of checkboxes.
										//Maybe use group layout, but we dont have a GUI builder
		
		JPanel rules = new JPanel();
		rules.setLayout(new BorderLayout());
		
		this.ruleCheckBoxesMap = ruleCheckBoxesMap;
		
		for(int i = 0; i<ruleBoxes.length; i++)
		{
			ruleBoxes[i].setToolTipText(ruleCheckBoxesMap.get(ruleBoxes[i]).getDescription());//TODO: Nick - do the wrapping in these.
			//FIXME - we need the tool tips to show up more reliably
			if(i<4)
			{
				houseRules.add(ruleBoxes[i]);//TODO make it so that if its below four it has an upper line of boxes
			}
			else
			{
				houseRules.add(ruleBoxes[i]);//TODO ... and if its below four it is in the lower line of boxes
			}
			
		}
		
		rules.add(houseRules,BorderLayout.NORTH);
		
		JRadioButton gamblingOn = new JRadioButton("On");
		JRadioButton gamblingOff = new JRadioButton("Off");
		
		ButtonGroup gamblingGroup = new ButtonGroup();
		
		gamblingGroup.add(gamblingOn);
		gamblingGroup.add(gamblingOff);
		
		JPanel gambling = new JPanel();
		
		gambling.add(gamblingOn);
		gambling.add(gamblingOff);
		
		//TODO add a tool tip for gambling.
		
		//FIXME we need a warning to come up whenever two incompatible rules are selected.
		//(i dont think radio buttons would work here because once one is selected there is no way to not click any of them (i think))
		
		rules.add(gambling, BorderLayout.SOUTH);
		
		rules.setBorder(BorderFactory.createTitledBorder("Rules"));
		houseRules.setBorder(BorderFactory.createTitledBorder("House Rules"));
		gambling.setBorder(BorderFactory.createTitledBorder("Gambling"));
		//TODO make the gambling border smaller so that theres not a bunch of empty space in it.
		//TODO also make the gambling panel centered within the area
		//TODO Rules - LEFT, decks - RIGHT.
		this.add(rules);
		this.add(decks);
		
		players = new ArrayList<Player>();
		houseRulesList = new ArrayList<HouseRules>();
	}
	
	private void checkRules()
	{
		//TODO fill
		//Make this method get which check boxes are checked in rules to create the rules.
	}
	
	public CAH_Game getGame() throws RuleConflictException, URISyntaxException, IOException
	{
		//Have the thing wait until the user clicks  start.
		//TODO Create each part of the game.
		//TODO deal with rule conflict exception by telling it that that is not a valid input.
		checkRules();
		return new CAH_Game(new Rules(houseRulesList), new DeckBuilder(), players);
	}

}
