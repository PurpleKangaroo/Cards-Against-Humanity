package ui;

import game.HouseRules;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ColorUIResource;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import cards.Decks;

/**
 * The panel that creates the menu for a new CAH game.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
@SuppressWarnings("serial")
public class CAH_NewGame extends JLayeredPane {
	
	private JComponent StartGameMenus;
	private boolean onList = false;
	
	/**
	 * The list of all the information about the players.
	 */
	@SuppressWarnings("rawtypes")
	private DefaultListModel players;
//TODO: Create examples applet in the left area.
	/**
	 * Create the panel.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	@SuppressWarnings("rawtypes")
	public CAH_NewGame() {
		final Expansion1Options expansion1 = new Expansion1Options();
		expansion1.setVisible(false);
		
		UIManager.put("TitledBorder.border", new LineBorder(new Color(250,250,250), 1, true));
		UIManager.put("ToolTip.background", new ColorUIResource(253, 255, 166));
		
		setBounds(new Rectangle(0, 0, 1450, 700));
		setMaximumSize(new Dimension(1450, 700));
		
		StartGameMenus = new JPanel();
		StartGameMenus.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		StartGameMenus.setOpaque(false);
		StartGameMenus.setBounds(240, 230, 695, 447);
		add(StartGameMenus);
		StartGameMenus.setLayout(null);
		
		final JPanel Rules = new JPanel();
		Rules.setBounds(13, 0, 672, 106);
		Rules.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rules", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		Rules.setOpaque(false);
		StartGameMenus.add(Rules);
		Rules.setLayout(null);
		
		final JPanel HouseRulesPanel = new JPanel();
		HouseRulesPanel.setBounds(10, 16, 561, 81);
		HouseRulesPanel.setBorder(new TitledBorder(null, "House Rules", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		HouseRulesPanel.setOpaque(false);
		Rules.add(HouseRulesPanel);
		
		final JCheckBox chckbxhappyEnding = new JCheckBox("<html><body style=\"color:WHITE\">Happy Ending</body></html>");
		chckbxhappyEnding.setFocusPainted(false);
		chckbxhappyEnding.setToolTipText(wrap(HouseRules.HAPPY_ENDING.getDescription()));
		chckbxhappyEnding.setOpaque(false);
		HouseRulesPanel.add(chckbxhappyEnding);
		
		final JCheckBox chckbxrebootingTheUniverse = new JCheckBox("<html><body style=\"color:WHITE\">Rebooting the Universe</body></html>");
		chckbxrebootingTheUniverse.setFocusPainted(false);
		chckbxrebootingTheUniverse.setOpaque(false);
		chckbxrebootingTheUniverse.setToolTipText(wrap(HouseRules.REBOOTING_THE_UNIVERSE.getDescription()));
		HouseRulesPanel.add(chckbxrebootingTheUniverse);
		
		final JCheckBox chckbxpackingHeat = new JCheckBox("<html><body style=\"color:WHITE\">Packing Heat</body></html>");
		chckbxpackingHeat.setFocusPainted(false);
		chckbxpackingHeat.setOpaque(false);
		chckbxpackingHeat.setToolTipText(wrap(HouseRules.PACKING_HEAT.getDescription()));
		HouseRulesPanel.add(chckbxpackingHeat);
		
		final JCheckBox chckbxrandoCardrissian = new JCheckBox("<html><body style=\"color:WHITE\">Rando Cardrissian</body></html>");
		chckbxrandoCardrissian.setFocusPainted(false);
		chckbxrandoCardrissian.setOpaque(false);
		chckbxrandoCardrissian.setToolTipText(wrap(HouseRules.RANDO_CARDRISSIAN.getDescription()));
		HouseRulesPanel.add(chckbxrandoCardrissian);
		
		final JCheckBox chckbxgodIsDead = new JCheckBox("<html><body style=\"color:WHITE\">God Is Dead</body></html>");
		chckbxgodIsDead.setFocusPainted(false);
		chckbxgodIsDead.setOpaque(false);
		chckbxgodIsDead.setToolTipText(wrap(HouseRules.GOD_IS_DEAD.getDescription()));
		HouseRulesPanel.add(chckbxgodIsDead);
		
		final JCheckBox chckbxsurvivalOfThe = new JCheckBox("<html><body style=\"color:WHITE\">Survival of the Fittest</body></html>");
		chckbxsurvivalOfThe.setFocusPainted(false);
		chckbxsurvivalOfThe.setOpaque(false);
		chckbxsurvivalOfThe.setToolTipText(wrap(HouseRules.SURVIVAL_OF_THE_FITTEST.getDescription()));
		HouseRulesPanel.add(chckbxsurvivalOfThe);
		
		final JCheckBox chckbxseriousBuisness = new JCheckBox("<html><body style=\"color:WHITE\">Serious Buisness</body></html>");
		chckbxseriousBuisness.setFocusPainted(false);
		chckbxseriousBuisness.setOpaque(false);
		chckbxseriousBuisness.setToolTipText(wrap(HouseRules.SERIOUS_BUSINESS.getDescription()));
		HouseRulesPanel.add(chckbxseriousBuisness);
		
		final JCheckBox chckbxneverHaveI = new JCheckBox("<html><body style=\"color:WHITE\">Never Have I Ever</body</html>");
		chckbxneverHaveI.setFocusPainted(false);
		chckbxneverHaveI.setOpaque(false);
		chckbxneverHaveI.setToolTipText(wrap(HouseRules.NEVER_HAVE_I_EVER.getDescription()));
		HouseRulesPanel.add(chckbxneverHaveI);
		
		CheckBoxGroup conflictingRules = new CheckBoxGroup();
		conflictingRules.add(chckbxgodIsDead);
		conflictingRules.add(chckbxsurvivalOfThe);
		conflictingRules.add(chckbxseriousBuisness);
		
		final JPanel gamblingPanel = new JPanel();
		gamblingPanel.setBorder(new TitledBorder(null, "Gambling", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		gamblingPanel.setOpaque(false);
		gamblingPanel.setBounds(581, 16, 81, 81);
		gamblingPanel.setToolTipText(wrap("If a Black Card is played and you have more than one White Card that you think could win, you can bet one of your Awesome Points to play an additional White Card. If you win, keep the point. If you lose, whoever won the round gets the point you wagered."));
		Rules.add(gamblingPanel);
		
		ButtonGroup gamblingButtons = new ButtonGroup();
		
		final JRadioButton rdbtnOn = new JRadioButton("<html><body style=\"color:WHITE\">On</body></html>");
		rdbtnOn.setFocusPainted(false);
		rdbtnOn.setOpaque(false);
		gamblingButtons.add(rdbtnOn);
		gamblingPanel.add(rdbtnOn);
		
		final JRadioButton rdbtnoff = new JRadioButton("<html><body style=\"color:WHITE\">Off</body></html>");
		rdbtnoff.setSelected(true);
		rdbtnoff.setFocusPainted(false);
		rdbtnoff.setOpaque(false);
		gamblingButtons.add(rdbtnoff);
		gamblingPanel.add(rdbtnoff);
		
		final JPanel DecksPanel = new JPanel();
		DecksPanel.setBorder(new TitledBorder(null, "Decks", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		DecksPanel.setOpaque(false);
		DecksPanel.setBounds(13, 117, 397, 82);
		StartGameMenus.add(DecksPanel);
		
		final JCheckBox chckbxOriginal = new JCheckBox("<html><body style=\"color:WHITE\">Original</body></html>");
		chckbxOriginal.setSelected(true);
		chckbxOriginal.setFocusPainted(false);
		chckbxOriginal.setOpaque(false);
		chckbxOriginal.setToolTipText(wrap(Decks.ORIGINAL.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		DecksPanel.add(chckbxOriginal);
		
		final JCheckBox chckbxExpansion1 = new JCheckBox("<html><body style=\"color:WHITE\">Expansion 1</body></html>");
		chckbxExpansion1.setFocusPainted(false);
		chckbxExpansion1.setOpaque(false);
		chckbxExpansion1.setToolTipText(wrap("The First Cards Against Humanity Expansion").replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		
		DecksPanel.add(chckbxExpansion1);
		
		final JCheckBox chckbxExpansion2 = new JCheckBox("<html><body style=\"color:WHITE\">Expansion 2</body></html>");
		chckbxExpansion2.setFocusPainted(false);
		chckbxExpansion2.setOpaque(false);
		chckbxExpansion2.setToolTipText(wrap(Decks.EXPANSION2.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		DecksPanel.add(chckbxExpansion2);
		
		final JCheckBox chckbxExpansion3 = new JCheckBox("<html><body style=\"color:WHITE\">Expansion 3</body></html>");
		chckbxExpansion3.setFocusPainted(false);
		chckbxExpansion3.setOpaque(false);
		chckbxExpansion3.setToolTipText(wrap(Decks.EXPANSION3.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		DecksPanel.add(chckbxExpansion3);
		
		final JCheckBox chckbxExpansion4 = new JCheckBox("<html><body style=\"color:WHITE\">Expansion 4</body></hmtl>");
		chckbxExpansion4.setFocusPainted(false);
		chckbxExpansion4.setOpaque(false);
		chckbxExpansion4.setToolTipText(wrap(Decks.EXPANSION4.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		DecksPanel.add(chckbxExpansion4);
		
		final JCheckBox chckbxHolidayExpansion = new JCheckBox("<html><body style=\"color:WHITE\">Holiday Expansion</body></html>");
		chckbxHolidayExpansion.setFocusPainted(false);
		chckbxHolidayExpansion.setOpaque(false);
		chckbxHolidayExpansion.setToolTipText(wrap(Decks.HOLIDAYEXPANSION.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		DecksPanel.add(chckbxHolidayExpansion);
		
		final JPanel AddPlayerPanel = new JPanel();
		AddPlayerPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		AddPlayerPanel.setOpaque(false);
		AddPlayerPanel.setBounds(13, 207, 672, 213);
		StartGameMenus.add(AddPlayerPanel);
		AddPlayerPanel.setLayout(null);
		
		JButton btnAddPlayer = new JButton("<html><h2 style=\"color:GREEN\">+</h2></html>");
		btnAddPlayer.setContentAreaFilled(false);
		btnAddPlayer.setOpaque(false);
		btnAddPlayer.setAlignmentY(Component.TOP_ALIGNMENT);
		btnAddPlayer.setBorder(new LineBorder(Color.WHITE, 1, true));
		btnAddPlayer.setMargin(new Insets(2, 1, 2, 1));
		btnAddPlayer.setFocusPainted(false);
		btnAddPlayer.setFocusTraversalKeysEnabled(false);
		btnAddPlayer.setToolTipText("Add Player");
		btnAddPlayer.setBounds(549, 7, 25, 25);
		AddPlayerPanel.add(btnAddPlayer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBounds(10, 45, 652, 157);
		AddPlayerPanel.add(scrollPane);
		
		players = new DefaultListModel();
		
		final PlayerColumnedList PlayerList = new PlayerColumnedList(players);
		scrollPane.setViewportView(PlayerList);
		scrollPane.setColumnHeaderView(new JLabel("Username" +
				"                                                    " + 
				"Name" + "                                                             " + 
				"Player Type"));
		
		GridBagLayout PlayerScrollLayout = new GridBagLayout();
		GridBagConstraints PlayerScrollConstraints = new ListScrConstraints();
		
		PlayerScrollLayout.setConstraints(scrollPane, PlayerScrollConstraints);
		
		JButton button = new JButton("<html><h2 style=\"color:RED\">-</h2></html>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{	
					String username = ((String[]) PlayerList.getSelectedValue())[0];
					final RemovePlayerDialog remove = new RemovePlayerDialog(username);
					remove.setLocation(getCenterOfMenu(new Dimension(remove.getWidth(), remove.getHeight())));
					remove.setAlwaysOnTop(true);
					remove.addNotify();
					remove.addPropertyChangeListener(new PropertyChangeListener() {

						@Override
						public void propertyChange(PropertyChangeEvent arg0)
						{
							if(arg0.getSource().equals(remove) && arg0.getPropertyName().equals("remove"))
							{
								//TODO Change add human player so that it doesnt close itsself, this closes it
								//TODO Then add if statement that will only close it if the username is unused, and neither username nore name are blank
								//TODO In the else statemment have a lable fade in then fade out that says that is not a valid username. Or "You must fill all fields".
								PlayerList.removePlayer(PlayerList.getSelectedIndex());
								PlayerList.validate();
							}
							
						}
						
					});
					
					
				}
				catch(Exception except)
				{
					
				}
				
			}
		});
		button.setBorder(new LineBorder(Color.WHITE, 1, true));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setAlignmentY(Component.TOP_ALIGNMENT);
		button.setMargin(new Insets(2, 1, 2, 1));
		button.setFocusPainted(false);
		button.setFocusTraversalKeysEnabled(false);
		button.setToolTipText("Remove Player");
		button.setBounds(578, 7, 25, 25);
		AddPlayerPanel.add(button);
		
		JButton btnAuto = new JButton("<html><body style =\"color:WHITE\">Auto</body></html>");
		btnAuto.setBorder(new LineBorder(Color.WHITE, 1, true));
		btnAuto.setContentAreaFilled(false);
		btnAuto.setOpaque(false);
		btnAuto.setToolTipText("Automatically add all netplay players connected to the game.");
		btnAuto.setMargin(new Insets(2, 1, 2, 1));
		btnAuto.setFocusTraversalKeysEnabled(false);
		btnAuto.setFocusPainted(false);
		btnAuto.setAlignmentY(0.0f);
		btnAuto.setBounds(607, 7, 42, 25);
		AddPlayerPanel.add(btnAuto);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel.setOpaque(false);
		panel.setBounds(0, 0, 672, 39);
		AddPlayerPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(10, 9, 75, 21);
		lblPlayers.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPlayers.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayers.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPlayers.setForeground(Color.WHITE);
		panel.add(lblPlayers);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setBorderPainted(false);
		btnStartGame.setFocusTraversalKeysEnabled(false);
		btnStartGame.setFocusPainted(false);
		btnStartGame.setOpaque(false);
		btnStartGame.setBounds(250, 422, 102, 17);
		StartGameMenus.add(btnStartGame);
		
		JPanel GameType = new JPanel();
		GameType.setOpaque(false);
		GameType.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Game Type", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GameType.setBounds(420, 117, 265, 82);
		StartGameMenus.add(GameType);
		
		final JRadioButton rdbtnSinglePlayer = new JRadioButton("<html><body style=\"color:WHITE\">Single Player</body></html>");
		rdbtnSinglePlayer.setSelected(true);
		rdbtnSinglePlayer.setFocusPainted(false);
		rdbtnSinglePlayer.setToolTipText(wrap("Play on your own against a computer player!"));
		rdbtnSinglePlayer.setOpaque(false);
		GameType.add(rdbtnSinglePlayer);
		
		final JRadioButton rdbtnmultiplayer = new JRadioButton("<html><body style=\"color:WHITE\">Multiplayer</body></html>");
		rdbtnmultiplayer.setFocusPainted(false);
		rdbtnmultiplayer.setToolTipText(wrap("Gather around one computer with your friends to play a multiplayer game!"));
		rdbtnmultiplayer.setOpaque(false);
		GameType.add(rdbtnmultiplayer);
		
		JRadioButton rdbtnNetplayMultiplayer = new JRadioButton("<html><body style=\"color:WHITE\">Netplay Multiplayer</body></html>");
		rdbtnNetplayMultiplayer.setFocusPainted(false);
		rdbtnNetplayMultiplayer.setToolTipText(wrap("Play over a local internet connection."));
		rdbtnNetplayMultiplayer.setOpaque(false);
		GameType.add(rdbtnNetplayMultiplayer);
		
		ButtonGroup gameTypeGroup = new ButtonGroup();
		gameTypeGroup.add(rdbtnSinglePlayer);
		gameTypeGroup.add(rdbtnmultiplayer);
		gameTypeGroup.add(rdbtnNetplayMultiplayer);
		
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnSinglePlayer.isSelected())
				{
					AddComputerPlayer add = new AddComputerPlayer();
					add.setVisible(true);
					add.setLocation(getCenterOfMenu(new Dimension(add.getWidth(), add.getHeight())));
					add.setAlwaysOnTop(true);
					add.addNotify();
				}
				else if(rdbtnmultiplayer.isSelected())
				{
					final AddPlayer add = new AddPlayer();
					add.setVisible(true);
					add.setLocation(getCenterOfMenu(new Dimension(add.getWidth(), add.getHeight())));
					add.setAlwaysOnTop(true);
					add.addNotify();
					add.addPropertyChangeListener(new PropertyChangeListener(){

						@Override
						public void propertyChange(PropertyChangeEvent arg0)
						{
							if(arg0.getSource().equals(add) && arg0.getPropertyName().equals("visible"))
							{
								if(add.getHuman())
								{
									final AddHumanPlayer add = new AddHumanPlayer();
									add.setVisible(true);
									add.setLocation(getCenterOfMenu(new Dimension(add.getWidth(), add.getHeight())));
									add.setAlwaysOnTop(true);
									add.addNotify();
									add.addPropertyChangeListener(new PropertyChangeListener() {

										@Override
										public void propertyChange(PropertyChangeEvent arg0)
										{
											if(arg0.getSource().equals(add) && arg0.getPropertyName().equals("done"))
											{
												//TODO Change add human player so that it doesnt close itsself, this closes it
												//TODO Then add if statement that will only close it if the username is unused, and neither username nore name are blank
												//TODO In the else statemment have a lable fade in then fade out that says that is not a valid username. Or "You must fill all fields".
												PlayerList.addPlayer(add.getUsername(), add.getPlayerName(), "Human");//TODO add this to the list of players
												PlayerList.validate();
											}
											
										}
										
									});
								}
								else
								{
									AddComputerPlayer add = new AddComputerPlayer();
									add.setVisible(true);
									add.setLocation(getCenterOfMenu(new Dimension(add.getWidth(), add.getHeight())));
									add.setAlwaysOnTop(true);
									add.addNotify();
								}
							}
							
						}
						
					});
				}
				else
				{
					
				}
			}
		});
		
		JLabel lblNewGame = new JLabel("New Game");
		lblNewGame.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewGame.setForeground(Color.WHITE);
		lblNewGame.setBounds(510, 183, 155, 33);
		add(lblNewGame);
		
		JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setBounds(84, 43, 1024, 139);
		add(lblCardsAgainstHumanity);
		lblCardsAgainstHumanity.setForeground(Color.WHITE);
		lblCardsAgainstHumanity.setFont(new Font("Arial Black", Font.BOLD, 70));
		
		final JLabel NewGameBackground = new JLabel("");
		NewGameBackground.setIcon(new ImageIcon(CAH_NewGame.class.getResource("/graphics/signupbackground.jpg")));
		NewGameBackground.setAlignmentX(Component.CENTER_ALIGNMENT);
		NewGameBackground.setBounds(0, 0, 1450, 722);
		add(NewGameBackground);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{HouseRulesPanel, Rules, StartGameMenus, NewGameBackground, chckbxhappyEnding, chckbxrebootingTheUniverse, chckbxpackingHeat, chckbxrandoCardrissian, chckbxsurvivalOfThe, chckbxseriousBuisness, chckbxneverHaveI, chckbxgodIsDead, gamblingPanel, rdbtnOn, rdbtnoff, DecksPanel, chckbxOriginal, chckbxExpansion1, chckbxExpansion2, chckbxExpansion3, chckbxExpansion4, chckbxHolidayExpansion, AddPlayerPanel}));
		
		chckbxExpansion1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if(chckbxExpansion1.isSelected())
				{
					expansion1.setVisible(true);
					expansion1.setLocation(getCenterOfMenu(new Dimension(expansion1.getWidth(), expansion1.getHeight())));//Centered in StartGameMenus
					add(expansion1);
					setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{expansion1, HouseRulesPanel, Rules, StartGameMenus, NewGameBackground, chckbxhappyEnding, chckbxrebootingTheUniverse, chckbxpackingHeat, chckbxrandoCardrissian, chckbxsurvivalOfThe, chckbxseriousBuisness, chckbxneverHaveI,chckbxgodIsDead, gamblingPanel, rdbtnOn, rdbtnoff, DecksPanel, chckbxOriginal, chckbxExpansion1, chckbxExpansion2, chckbxExpansion3, chckbxExpansion4, chckbxHolidayExpansion, AddPlayerPanel}));
				}	
			}
			
		});
		
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO fill.
			}
		});
		
		chckbxrandoCardrissian.addChangeListener(new ChangeListener(){
			
			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				if(chckbxrandoCardrissian.isSelected() && !onList)
				{
					PlayerList.addPlayer("Rando_cardrissian", "Rando Cardrissian", "Computer");
					onList = true;
				}
				else if(!chckbxrandoCardrissian.isSelected() && onList)
				{
					PlayerList.removeRandoCardrissian();
					onList = false;
				}
				
			}
			
		});
		
		PlayerList.addPropertyChangeListener("Rando", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent arg0)
			{
				chckbxrandoCardrissian.setSelected(false);
				onList = false;
			}
			
		});
		
	}
	
	/**
	 * Allows StartGameMenus to add a component. This is important for allowing the program to add the main menu button which will return the user to the main menu.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @param component the JComponent being added.
	 */
	protected void startGameMenuAdd(JComponent component)
	{
		StartGameMenus.add(component);
	}
	
	/**
	 * Wraps the string for the tool tips.
	 * The wrapping is done with HTML
	 * @param str the string that will be wrapped with HTML.
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
	
	/**
	 * Gets the point where a component should be placed in order to be at the center of the StartGameMenu.
	 * @param d The Dimension of the Component.
	 * @return p - The point where the component should be placed
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	private Point getCenterOfMenu(Dimension d)
	{
		int x = StartGameMenus.getX() + ((StartGameMenus.getWidth())/2) - ((d.width)/2);
		int y = StartGameMenus.getY() + ((StartGameMenus.getHeight())/2) - ((d.height)/2);
		
		Point p = new Point(x, y);
		
		return p;
	}
	
	/**
	 * A class of object that groups JCheckBoxes together.
	 * It allows a user to deselect the group
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	private class CheckBoxGroup extends ButtonGroup
	{
		@Override
		public void setSelected(ButtonModel model, boolean selected)
		{
			if(!selected)
			{
				clearSelection();
			}
			else
			{
				super.setSelected(model, selected);
			}
		}
	}
	
	/**
	 * A class of object that represents a columned list that contains information about players in a game of Cards Against Humanity.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	@SuppressWarnings("rawtypes")
	private class PlayerColumnedList extends JList {
		
		/**
		 * The model of the lists data.
		 */
		private DefaultListModel model;
		
		@SuppressWarnings("unchecked")
		private PlayerColumnedList(DefaultListModel players)
		{
			model = players;
			super.setModel(model);
			super.setCellRenderer(new PlayerListCellRenderer());
			super.setForeground(Color.WHITE);
			super.setSelectionBackground(new Color(0, 153, 255));
			super.setSelectionForeground(Color.WHITE);
			
			super.setOpaque(true);
			
			super.setBackground(Color.BLACK);
			super.setAutoscrolls(false);
			super.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			setFixedCellWidth(100);
			if(!model.isEmpty())
			{
				setSelectedIndex(0);
			}
			//TODO: finish.
		}
		
		/**
		 * Removes a player at a given index from the list of players in the game.
		 * @param index the given index that the player being removed is at on the list.
		 * @since CAH1.0
		 */
		@SuppressWarnings("unchecked")
		private void removePlayer(int index)
		{
			String username = ((String[]) model.get(index))[0];
			
			model.remove(index);
			this.setModel(model);
			try
			{
				this.setSelectedIndex(index - 1);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				try
				{
					this.setSelectedIndex(index + 1);
				}
				catch(Exception except)
				{
					
				}
			}
			if(username.replaceAll(" ", "").equals("Rando_cardrissian"))
			{
				firePropertyChange("Rando", true, false);
			}
		}
		
		/**
		 * Removes Rando Cardrissian from the list.
		 * @since CAH1.0
		 */ 
		private void removeRandoCardrissian()
		{
			int index = -1;
			if(model.size() > 0)
			{
				boolean found = false;
				for(int i = 0; i < model.size() && !found; i++)
				{
					String[] check = (String[]) model.get(i);
					if(check[0].equals("Rando_cardrissian"))
					{
						found = true;
						index = i;
					}
				}
				
			}
			if(index >= 0)
			{
				removePlayer(index);
			}
		}
		
		/**
		 * Adds a player to the list of players in a game.
		 * @param username the username of the player being added.
		 * @param name the name of the player being added.
		 * @param type the type of player being added.
		 * @since CAH1.0
		 */
		@SuppressWarnings("unchecked")
		private void addPlayer(String username, String name, String type)
		{
			String[] newData = new String[3];
			
			newData[0] = username;
			newData[1] = name;
			newData[2] = type;
			
			if(!checkValidity(username, name, type))
			{
				//TODO create dialog saying that there is already a player with that name
			}
			else
			{
				model.addElement(newData);
				this.setSelectedIndex(model.size() - 1);
			}
		}
		
		/**
		 * Checks to make sure the user being added is valid.
		 * @param username the username being checked.
		 * @return valid - whether or not the user being added is valid.
		 */
		private boolean checkValidity(String username, String name, String type)
		{
			String[] rando = {"Rando_cardrissian", "Rando Cardrissian", "Computer"};
			if(model.size() > 0)
			{
				boolean found = false;
				for(int i = 0; i < model.size() && !found; i++)
				{
					String[] check = (String[]) model.get(i);
					
					if(check[0].equalsIgnoreCase(username) || (rando[0].equalsIgnoreCase(username) && !rando[2].equals(type)) || (rando[1].equalsIgnoreCase(name) && !rando[2].equals(type)))
					{
						found = true;
						return false;
					}
				}
				return true;
				
			}
			else if((rando[0].equalsIgnoreCase(username) && !rando[2].equals(type)) || (rando[1].equalsIgnoreCase(name) && !rando[2].equals(type)))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	/**
	 * A class of object that represents the list cell renderer for the list of players involved in a game of Cards Against Humanity.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private class PlayerListCellRenderer extends JPanel implements ListCellRenderer {
		/**
		 * The player's username.
		 */
		private JLabel username;
		/**
		 * The player's name.
		 */
		private JLabel name;
		/**
		 * The type of player.
		 */
		private JLabel type;
		
		/**
		 * Creates an object that renders the list of players involved in a game of CAH.
		 * @since CAH1.0
		 * 
		 */
		private PlayerListCellRenderer()
		{
			setLayout(new GridLayout(1,3));
			
			username = new JLabel();
			name = new JLabel();
			type = new JLabel();
			
			username.setOpaque(true);
			name.setOpaque(true);
			type.setOpaque(true);
			
			add(username);
			add(name);
			add(type);
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean hasFocus)
		{
			String usernameData = ((String[])value)[0];
			String nameData = ((String[])value)[1];
			String typeData = ((String[])value)[2];
			
			username.setText(usernameData);
			name.setText(nameData);
			type.setText(typeData);
			
			if(isSelected)
			{
				username.setBackground(list.getSelectionBackground());
				username.setForeground(list.getSelectionForeground());
				
				name.setBackground(list.getSelectionBackground());
				name.setForeground(list.getSelectionForeground());
				
				type.setBackground(list.getSelectionBackground());
				type.setForeground(list.getSelectionForeground());
			}
			
			else
			{
				username.setBackground(list.getBackground());
				username.setForeground(list.getForeground());
				
				name.setBackground(list.getBackground());
				name.setForeground(list.getForeground());
				
				type.setBackground(list.getBackground());
				type.setForeground(list.getForeground());
			}
			
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			
			list.setFixedCellWidth(100);
			
			return this;
		}
		
	}
}

