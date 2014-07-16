package ui;

import game.HouseRules;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;

import ui.Slidable.InvalidDirectionException;

/**
 * A class of object that represents the panel that contains information about Cards Against Humanity's rules.
 * @since CAH1.0
 * @version CAH1.0
 * @author Holt Maki
 *
 */
public class RulesPanel extends JPanel
{

	/**
	 * Create the panel.
	 * @since CAH1.0
	 */
	public RulesPanel()
	{
		setBounds(new Rectangle(0, 0, 1450, 700));
		setMaximumSize(new Dimension(1450, 700));
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel.setOpaque(false);
		panel.setBounds(225, 218, 696, 471);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnbasicRules = new JTextPane();
		txtpnbasicRules.setOpaque(false);
		txtpnbasicRules.setDisabledTextColor(Color.WHITE);
		txtpnbasicRules.setBounds(6, 6, 323, 458);
		txtpnbasicRules.setEnabled(false);
		txtpnbasicRules.setEditable(false);
		txtpnbasicRules.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnbasicRules.setContentType("text/html");
		txtpnbasicRules.setText("<html><body style=\"font-family: Arial; font-size:12; font-color: WHITE\"><b>Basic Rules</b>\r\n<p>\r\nTo start the game each player draws ten White Cards.</p><p>A player will be chosen at random to be the first Card Czar, and a black card is automatically drawn.</p>\r\n<p>Everyone else answers the question or fills in the blank by selecting one White Card.</p>\r\n<p>The cards are placed in a random order and each combination is displayed to everyone. The Card Czar then picks the funniest play, and whoever submitted it gets one Awesome Point.\r\n</p>\r\n<p><b>PICK </b><span style=\"font-color: BLACK\">\u2777</span></p>\r\n<p>Some Black Cards say PICK <span style=\"font-color: BLACK\">\u2777 </span> on the bottom.</p>\r\n<p>To answer these cards each player plays two White Cards in a combination. Select them in the order that you want them displayed - the order matters.</p>\r\n<p><b>Gambling</b></p>\r\n<p>You may choose to play a game with the gambling rule if you wish to. If a Black Card is played and you have more than one White Card that you think it went, you can bet one of your awesome points to plan additional White Card.</p>\r\n<p>If you won, you keep your point. If you lose, whoever won the round gets the point you wagered.</p>\r\n</body>\r\n</html>");
		//TODO add lines between sections (see CAH's rules).
		panel_1.add(txtpnbasicRules);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane txtpnhouseRules = new JTextPane();
		txtpnhouseRules.setOpaque(false);
		txtpnhouseRules.setDisabledTextColor(Color.WHITE);
		txtpnhouseRules.setBounds(10, 6, 323, 66);
		txtpnhouseRules.setEnabled(false);
		txtpnhouseRules.setEditable(false);
		txtpnhouseRules.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnhouseRules.setContentType("text/html");
		txtpnhouseRules.setText("<html><body style=\"font-family: Arial; font-size:12; font-color: WHITE\"><b>House Rules</b>\r\n<p>\r\nCards Against Humanity is meant to be remixed. Here are some awesome ways to pimp out the rules.</p>\r\n</body></html>");
		//TODO add lines between sections (see CAH's rules).
		panel_2.add(txtpnhouseRules);
		
		final JPanel houseRulesArea = new JPanel();
		houseRulesArea.setOpaque(false);
		houseRulesArea.setBounds(10, 88, 323, 370);
		panel_2.add(houseRulesArea);
		final SpringLayout sl_houseRulesArea = new SpringLayout();
		houseRulesArea.setLayout(sl_houseRulesArea);
		
		final HouseRulePanel happyEnding = new HouseRulePanel("Happy Ending", HouseRules.HAPPY_ENDING.getDescription());
		sl_houseRulesArea.putConstraint(SpringLayout.NORTH, happyEnding, 0, SpringLayout.NORTH, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.WEST, happyEnding, 0, SpringLayout.WEST, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.SOUTH, happyEnding, 20, SpringLayout.NORTH, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.EAST, happyEnding, 323, SpringLayout.WEST, houseRulesArea);
		houseRulesArea.add(happyEnding);
		
		happyEnding.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					sl_houseRulesArea.removeLayoutComponent(happyEnding);
					sl_houseRulesArea.putConstraint(SpringLayout.NORTH, happyEnding, 0, SpringLayout.NORTH, houseRulesArea);
					sl_houseRulesArea.putConstraint(SpringLayout.WEST, happyEnding, 0, SpringLayout.WEST, houseRulesArea);
					sl_houseRulesArea.putConstraint(SpringLayout.SOUTH, happyEnding, 10, SpringLayout.NORTH, houseRulesArea);
					sl_houseRulesArea.putConstraint(SpringLayout.EAST, happyEnding, 323, SpringLayout.WEST, houseRulesArea);
					happyEnding.slide(10, Slidable.DOWN);
					

				} catch (InvalidDirectionException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		});
		/*
		HouseRulePanel rebooting = new HouseRulePanel("Rebooting the Universe", HouseRules.REBOOTING_THE_UNIVERSE.getDescription());
		sl_houseRulesArea.putConstraint(SpringLayout.NORTH, rebooting, 0, SpringLayout.SOUTH, happyEnding);
		sl_houseRulesArea.putConstraint(SpringLayout.WEST, rebooting, 0, SpringLayout.WEST, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.SOUTH, rebooting, 20, SpringLayout.SOUTH, happyEnding);
		sl_houseRulesArea.putConstraint(SpringLayout.EAST, rebooting, 323, SpringLayout.WEST, houseRulesArea);
		houseRulesArea.add(rebooting);
		
		HouseRulePanel packing = new HouseRulePanel("Packing Heat", HouseRules.PACKING_HEAT.getDescription());
		sl_houseRulesArea.putConstraint(SpringLayout.NORTH, packing, 0, SpringLayout.SOUTH, rebooting);
		sl_houseRulesArea.putConstraint(SpringLayout.WEST, packing, 0, SpringLayout.WEST, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.SOUTH, packing, 20, SpringLayout.SOUTH, rebooting);
		sl_houseRulesArea.putConstraint(SpringLayout.EAST, packing, 323, SpringLayout.WEST, houseRulesArea);
		houseRulesArea.add(packing);
		
		HouseRulePanel rando = new HouseRulePanel("Rando Cardrissian", HouseRules.RANDO_CARDRISSIAN.getDescription());
		sl_houseRulesArea.putConstraint(SpringLayout.NORTH, rando, 0, SpringLayout.SOUTH, packing);
		sl_houseRulesArea.putConstraint(SpringLayout.WEST, rando, 0, SpringLayout.WEST, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.SOUTH, rando, 20, SpringLayout.SOUTH, packing);
		sl_houseRulesArea.putConstraint(SpringLayout.EAST, rando, 323, SpringLayout.WEST, houseRulesArea);
		houseRulesArea.add(rando);
		
		HouseRulePanel god = new HouseRulePanel("God Is Dead", HouseRules.GOD_IS_DEAD.getDescription());
		sl_houseRulesArea.putConstraint(SpringLayout.NORTH, god, 0, SpringLayout.SOUTH, rando);
		sl_houseRulesArea.putConstraint(SpringLayout.WEST, god, 0, SpringLayout.WEST, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.SOUTH, god, 20, SpringLayout.SOUTH, rando);
		sl_houseRulesArea.putConstraint(SpringLayout.EAST, god, 323, SpringLayout.WEST, houseRulesArea);
		houseRulesArea.add(god);
		
		HouseRulePanel survival = new HouseRulePanel("Survival of the Fittest", HouseRules.SURVIVAL_OF_THE_FITTEST.getDescription());
		sl_houseRulesArea.putConstraint(SpringLayout.NORTH, survival, 0, SpringLayout.SOUTH, god);
		sl_houseRulesArea.putConstraint(SpringLayout.WEST, survival, 0, SpringLayout.WEST, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.SOUTH, survival, 20, SpringLayout.SOUTH, god);
		sl_houseRulesArea.putConstraint(SpringLayout.EAST, survival, 323, SpringLayout.WEST, houseRulesArea);
		houseRulesArea.add(survival);
		
		HouseRulePanel serious = new HouseRulePanel("Serious Buisiness", HouseRules.SERIOUS_BUSINESS.getDescription());
		sl_houseRulesArea.putConstraint(SpringLayout.NORTH, serious, 0, SpringLayout.SOUTH, survival);
		sl_houseRulesArea.putConstraint(SpringLayout.WEST, serious, 0, SpringLayout.WEST, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.SOUTH, serious, 20, SpringLayout.SOUTH, survival);
		sl_houseRulesArea.putConstraint(SpringLayout.EAST, serious, 323, SpringLayout.WEST, houseRulesArea);
		houseRulesArea.add(serious);
		
		HouseRulePanel never = new HouseRulePanel("Never Have I Ever", HouseRules.NEVER_HAVE_I_EVER.getDescription());
		sl_houseRulesArea.putConstraint(SpringLayout.NORTH, never, 0, SpringLayout.SOUTH, serious);
		sl_houseRulesArea.putConstraint(SpringLayout.WEST, never, 0, SpringLayout.WEST, houseRulesArea);
		sl_houseRulesArea.putConstraint(SpringLayout.SOUTH, never, 20, SpringLayout.SOUTH, serious);
		sl_houseRulesArea.putConstraint(SpringLayout.EAST, never, 323, SpringLayout.WEST, houseRulesArea);
		houseRulesArea.add(never);*/
		
		//TODO make the HouseRulePanel class and put them inside panel_3.
		
		JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setBounds(84, 43, 1024, 139);
		add(lblCardsAgainstHumanity);
		lblCardsAgainstHumanity.setForeground(Color.WHITE);
		lblCardsAgainstHumanity.setFont(new Font("Arial Black", Font.BOLD, 70));
		
		JLabel lblRules = new JLabel("Rules");
		lblRules.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblRules.setForeground(Color.WHITE);
		lblRules.setBounds(531, 174, 83, 33);
		add(lblRules);
		
		final JLabel RulesBackground = new JLabel("");
		RulesBackground.setIcon(new ImageIcon(CAH_NewGame.class.getResource("/graphics/signupbackground.jpg")));
		RulesBackground.setAlignmentX(Component.CENTER_ALIGNMENT);
		RulesBackground.setBounds(0, 0, 1450, 722);
		add(RulesBackground);
	}
}
