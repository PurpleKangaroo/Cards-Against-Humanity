package userInterface;

import game.CAH_Game;
import game.HouseRules;
import game.RuleConflictException;
import game.Rules;
import graphics.ImageLoad;
import import_export.PathFinder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

import users.Player;
import cards.DeckBuilder;
import cards.Decks;

/**
 * A class of object that represents the start screen for Cards Against Humanity.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
@SuppressWarnings("serial")
public class CAH_Panel_STARTGAME_MENU extends JPanel 
{
	//TODO add tool tips for the tools, especially for when someone has an invalid set of rules.
	/**
	 * The slider that is used to choose how many players with each player chosen
	 *  a new bordered area with swing tools that allow player setup will be added.
	 *  This bordered area will include information such as if the player is a computer,
	 *  and maybe their username or IP. (maybe we can have them send that information automatically to the
	 *  computer which will display it when the user connects.
	 *  
	 */
	private JSlider numberOfPlayerSlider;
	/**
	 * A list of the players playing in the game
	 */
	private ArrayList<Player> players;
	/**
	 * The list of house rules that the game is using.
	 */
	private ArrayList<HouseRules> houseRulesList;
	/**
	 * A HashMap of all the check boxes and the house rules that they represent.
	 * */
	private HashMap<JCheckBox, HouseRules> ruleCheckBoxesMap;
	
	/**
	 * Creates an object that represents menu for the the start screen for Cards Against Humanity.
	 * @throws URISyntaxException 
	 * @since CAH1.0
	 */
	public CAH_Panel_STARTGAME_MENU() throws URISyntaxException
	{
		//TODO maybe have a picture of each deck instead of text?
		//FIXME add text at the top that says something like "New Game" or "Game Setup"
		//TODO sizing!!!
		//TODO idea allow people to make and add custom decks.
		//TODO idea alow people to save game settings.
		//TODO get the checkbox that is checked by having the program look at which checkboxes are clicked when the user hits the start button.
		//FIXME Fix the layout.
		//FIXME make it work when its both maximized and restored.
		//TODO add background, maybe in the sides have cards combonations like on the CAH website.
		//Idea: in a start menu have the background be one that shows good random (or maybe selected but in a ramdom order) combinations of cards.
		//TODO  nice moving background, it needs to look better
		super(new GridBagLayout());
		
		this.setBackground(new Color(Color.TRANSLUCENT));
		
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
		
		HashMap<JCheckBox, Decks> deckMaps = new HashMap<JCheckBox, Decks>();
		
		deckMaps.put(originalCAHDeck, Decks.ORIGINAL);
		deckMaps.put(expansion1, Decks.EXPANSION1);
		deckMaps.put(expansion2, Decks.EXPANSION2);
		deckMaps.put(expansion3, Decks.EXPANSION3);
		deckMaps.put(expansion4, Decks.EXPANSION4);
		deckMaps.put(holidayExpansion, Decks.HOLIDAYEXPANSION);
		
		JCheckBox[] deckBoxes = {originalCAHDeck, expansion1, expansion2, expansion3, expansion4, holidayExpansion};
		
		JPanel decks = new JPanel();
		decks.setBackground(new Color(Color.TRANSLUCENT));
		decks.setForeground(Color.WHITE);
		
		for (int i = 0; i<deckBoxes.length; i++)
		{
			
			deckBoxes[i].setToolTipText((wrap(deckMaps.get(deckBoxes[i]).getDescription())).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
			deckBoxes[i].setVisible(true);
			deckBoxes[i].setBackground(new Color(Color.TRANSLUCENT));
			deckBoxes[i].setForeground(Color.WHITE);
			
			if (i<3)//TODO have these boxes added to the upper part
			{
				decks.add(deckBoxes[i]);
			}
			
			else//TODO ... and these added to the lower part
			{
				decks.add(deckBoxes[i]);
			}
		}
		
		Border deckBorder = BorderFactory.createTitledBorder("Decks");
		
		decks.setBorder(deckBorder);
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
		
		JPanel houseRules = new JPanel(new GridLayout(2,1));//TODO initialize with a layout that allows two lines of checkboxes.
										//Maybe use group layout, but we dont have a GUI builder
		
		JPanel rules = new JPanel();
		rules.setLayout(new GridLayout(2,1));
		
		this.ruleCheckBoxesMap = ruleCheckBoxesMap;
		
		UIManager.put("ToolTip.background", new ColorUIResource(253, 255, 166));
		
		for(int i = 0; i<ruleBoxes.length; i++)
		{
			ruleBoxes[i].setToolTipText(wrap(ruleCheckBoxesMap.get(ruleBoxes[i]).getDescription()));
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
		
		rules.add(houseRules);
		
		JRadioButton gamblingOn = new JRadioButton("On");
		JRadioButton gamblingOff = new JRadioButton("Off");
		
		ButtonGroup gamblingGroup = new ButtonGroup();
		
		gamblingGroup.add(gamblingOn);
		gamblingGroup.add(gamblingOff);
		
		JPanel gambling = new JPanel();
		
		gambling.add(gamblingOn);
		gambling.add(gamblingOff);
		
		JPanel playerPanel = new JPanel();
		
		JList<String> playerList = new JList<String>(new DefaultListModel<String>());//FIXME get this list working
		//TODO list show different details like the way the details view does in windows
		//TODO to add players use a button with a "+" on it and to remove them use a "-" button.
		//TODO maybe use a dialogue box to enter the players information maybe.
		//TODO Or maybe automatically get a users information when they connect.
		
		//TODO add a tool tip for gambling.
		
		//FIXME we need a warning to come up whenever two incompatible rules are selected.
		//(i dont think radio buttons would work here because once one is selected there is no way to not click any of them (i think))
		
		playerPanel.add(playerList);
		
		rules.add(gambling);
		
		JButton startGameButton = new JButton("Start Game");//This needs to go at the very bottom.
		startGameButton.setBackground(Color.orange);
		startGameButton.addActionListener(new StartGameListener(this));
		
		rules.setBorder((BorderFactory.createTitledBorder("Rules")));
		houseRules.setBorder(BorderFactory.createTitledBorder("House Rules"));
		gambling.setBorder(BorderFactory.createTitledBorder("Gambling"));
		gambling.setLayout(new FlowLayout());
		
		//TODO make the gambling border smaller so that theres not a bunch of empty space in it.
		//TODO also make the gambling panel centered within the area
		//TODO Rules - LEFT, decks - RIGHT.
		
		this.add(rules);
		this.add(decks);
		this.add(playerPanel);
		this.add(startGameButton);
		
		
		players = new ArrayList<Player>();
		houseRulesList = new ArrayList<HouseRules>();
	}
	
	/**
	 * An ActionListener for when the start game button is clicked.
	 * It starts the game.
	 * @author Holt Maki
	 * @since CAH1.0
	 *
	 */
	private class StartGameListener implements ActionListener
	{
		private CAH_Panel_STARTGAME_MENU startPanel;
		
		/**
		 * Creates the a StartGameListener with the CAH_Panel_STARTGAME.
		 * @param startPanel - the CAH_Panel_STARTGAME.
		 * @since CAH1.0
		 */
		public StartGameListener(CAH_Panel_STARTGAME_MENU startPanel)
		{
			this.startPanel = startPanel;
		}

		/**
		 * From ActionListener.
		 * When an action is performed, this will start the game.
		 * @since CAH1.0
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//TODO we need to make it so that this will make the start panel give the game to the CAH_Frame, which will then start up the CAH_Game.
			
			
		}
		
	}
	
	/**
	 * A method that cheks the rules to get the rules for the game.
	 * @since CAH1.0
	 */
	private void checkRules()
	{
		//TODO fill
		//Make this method get which check boxes are checked in rules to create the rules.
	}
	
	/**
	 * Creates a new CAH game based on the user's settings.
	 * @return A new Cards Against Humanity Game with the settings selected by the user.
	 * @throws RuleConflictException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @since CAH1.0
	 */
	
	public CAH_Game getGame() throws RuleConflictException, URISyntaxException, IOException
	{
		//Have the thing wait until the user clicks  start.
		//TODO Create each part of the game.
		//TODO deal with rule conflict exception by telling it that that is not a valid input.
		checkRules();
		return new CAH_Game(new Rules(houseRulesList), new DeckBuilder(), players);
	}
	
	/**
	 * Wraps the string for the tool tips.
	 * The wrapping is done with HTML
	 * @param str - the string that will be wrapped with HTML.
	 * @return str + "<</html>/html>" - the String wrapped in HTML plus the closing "<</html>/html>".
	 * <html>
	 * @since CAH1.0
	 * @author Holt Maki
	 * 
	 */
	
	private String wrap(String str)
	{
		str = "<html>" + str;
		for(int i = 50; i<str.length(); i+=50)
		{
		
			try
			{
				while(str.charAt(i) != ' ' && i <str.length())
				{
					i++;
				}
				
				if (i<str.length())
				{
					str = str.substring(0,i) +"<br>" + str.substring(i);
				}
			}
			
			catch(Exception e)
			{
				
			}
						
		}
		
		return str + "</html>";
	}

}
