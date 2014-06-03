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
		panel.setOpaque(false);
		panel.setBounds(225, 218, 696, 434);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnbasicRules = new JTextPane();
		txtpnbasicRules.setBounds(154, 5, 77, 25);
		txtpnbasicRules.setEnabled(false);
		txtpnbasicRules.setEditable(false);
		txtpnbasicRules.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnbasicRules.setContentType("text/html");
		txtpnbasicRules.setText("<html><b>Basic Rules</b>\r\n<p>\r\nTo start the game each player draws ten White Cards.\r\n</p>\r\n</html>");
		panel_1.add(txtpnbasicRules);
		
		JPanel panel_2 = new JPanel();
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
