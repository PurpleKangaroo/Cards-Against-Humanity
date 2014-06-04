package ui;

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
import javax.swing.border.LineBorder;

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
		txtpnbasicRules.setBounds(10, 11, 323, 447);
		txtpnbasicRules.setEnabled(false);
		txtpnbasicRules.setEditable(false);
		txtpnbasicRules.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnbasicRules.setContentType("text/html");
		txtpnbasicRules.setText("<html><body style=\"font-family: Arial; font-size:13; font-color: WHITE\"><b>Basic Rules</b>\r\n<p>\r\nTo start the game each player draws ten White Cards.</p><p>A player will be chosen at random to be the first Card Czar, and a black card is automatically drawn.</p>\r\n<p>Everyone else answers the question or fills in the blank by selecting one White Card.</p>\r\n<p>The cards are placed in a random order and each combination is displayed to everyone. The Card Czar then picks the funniest play, and whoever submitted it gets one Awesome Point.\r\n</p>\r\n<p><b>PICK </b><span style=\"font-color: BLACK\">\u2777</span></p>\r\n<p>Some cards say PICK <span style=\"font-color: BLACK\">\u2777 </span> on the bottom.</p>\r\n<p>To answer these cards each player plays two white cards in a combination. Select them in the order that you want them displayed - the order matters.</p>\r\n<p><b>Gambling</b></p>\r\n</body>\r\n</html>");
		//TODO add lines between sections (see CAH's rules).
		panel_1.add(txtpnbasicRules);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);
		
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
