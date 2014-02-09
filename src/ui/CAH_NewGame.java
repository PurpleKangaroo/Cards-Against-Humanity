package ui;

import game.HouseRules;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
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
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import cards.Decks;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPopupMenu;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

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
//TODO: Create examples applet in the left area.
	/**
	 * Create the panel.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	public CAH_NewGame() {
		final Expansion1Options expansion1 = new Expansion1Options();
		expansion1.setVisible(false);
		
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
		AddPlayerPanel.setBorder(new TitledBorder(null, "Players", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		AddPlayerPanel.setOpaque(false);
		AddPlayerPanel.setBounds(13, 207, 672, 213);
		StartGameMenus.add(AddPlayerPanel);
		AddPlayerPanel.setLayout(null);
		
		final JSeparator separator = new JSeparator();
		separator.setBounds(10, 32, 629, 2);
		AddPlayerPanel.add(separator);
		
		JButton btnAddPlayer = new JButton("<html><h2 style=\"color:GREEN\">+</h2></html>");
		btnAddPlayer.setAlignmentY(Component.TOP_ALIGNMENT);
		btnAddPlayer.setBorderPainted(false);
		btnAddPlayer.setBorder(UIManager.getBorder("Button.border"));
		btnAddPlayer.setMargin(new Insets(2, 1, 2, 1));
		btnAddPlayer.setFocusPainted(false);
		btnAddPlayer.setFocusTraversalKeysEnabled(false);
		btnAddPlayer.setToolTipText("Add Player");
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: fill
			}
		});
		btnAddPlayer.setOpaque(false);
		btnAddPlayer.setBounds(585, 11, 25, 23);
		AddPlayerPanel.add(btnAddPlayer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(20, 45, 619, 157);
		AddPlayerPanel.add(scrollPane);
		
		JList PlayerList = new JList();
		scrollPane.setViewportView(PlayerList);
		
		JButton button = new JButton("<html><h2 style=\"color:RED\">-</h2></html>");
		button.setAlignmentY(Component.TOP_ALIGNMENT);
		button.setMargin(new Insets(2, 1, 2, 1));
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setFocusTraversalKeysEnabled(false);
		button.setToolTipText("Remove Player");
		button.setOpaque(false);
		button.setBounds(614, 11, 25, 23);
		AddPlayerPanel.add(button);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setBorderPainted(false);
		btnStartGame.setFocusTraversalKeysEnabled(false);
		btnStartGame.setFocusPainted(false);
		btnStartGame.setOpaque(false);
		btnStartGame.setBounds(250, 419, 102, 17);
		StartGameMenus.add(btnStartGame);
		
		JPanel GameType = new JPanel();
		GameType.setOpaque(false);
		GameType.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Game Type", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		GameType.setBounds(420, 117, 265, 82);
		StartGameMenus.add(GameType);
		
		JRadioButton rdbtnSinglePlayer = new JRadioButton("<html><body style=\"color:WHITE\">Single Player</body></html>");
		rdbtnSinglePlayer.setSelected(true);
		rdbtnSinglePlayer.setFocusPainted(false);
		rdbtnSinglePlayer.setToolTipText(wrap("Play on your own against a computer player!"));
		rdbtnSinglePlayer.setOpaque(false);
		GameType.add(rdbtnSinglePlayer);
		
		JRadioButton rdbtnmultiplayer = new JRadioButton("<html><body style=\"color:WHITE\">Multiplayer</body></html>");
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
		
		JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setBounds(83, 43, 1024, 139);
		add(lblCardsAgainstHumanity);
		lblCardsAgainstHumanity.setForeground(Color.WHITE);
		lblCardsAgainstHumanity.setFont(new Font("Arial Black", Font.BOLD, 70));
		
		final JLabel NewGameBackground = new JLabel("");
		NewGameBackground.setIcon(new ImageIcon(CAH_NewGame.class.getResource("/graphics/signupbackground.jpg")));
		NewGameBackground.setAlignmentX(Component.CENTER_ALIGNMENT);
		NewGameBackground.setBounds(0, 0, 1450, 722);
		add(NewGameBackground);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{HouseRulesPanel, Rules, StartGameMenus, NewGameBackground, chckbxhappyEnding, chckbxrebootingTheUniverse, chckbxpackingHeat, chckbxrandoCardrissian, chckbxsurvivalOfThe, chckbxseriousBuisness, chckbxneverHaveI, chckbxgodIsDead, gamblingPanel, rdbtnOn, rdbtnoff, DecksPanel, chckbxOriginal, chckbxExpansion1, chckbxExpansion2, chckbxExpansion3, chckbxExpansion4, chckbxHolidayExpansion, AddPlayerPanel}));
		
		UIManager.put("ToolTip.background", new ColorUIResource(253, 255, 166));
		
		chckbxExpansion1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if(chckbxExpansion1.isSelected())
				{
					expansion1.setVisible(true);
					expansion1.setLocation(500,225);
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
		
	}
	
	/**
	 * Allows StartGameMenus to add a component. This is important for allowing the program to add the main menu button which will return the user to the main menu.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @param component - the JComponent being added.
	 */
	protected void startGameMenuAdd(JComponent component)
	{
		StartGameMenus.add(component);
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
}

