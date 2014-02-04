package ui;

import javax.swing.JPanel;

import users.Player;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 * A class of object that represents the panel where a players information is displayed
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
@SuppressWarnings("serial")
public class PlayerPanel extends JPanel 
{
	/**
	 * The player whose information is in the panel.
	 */
	private Player player;

	/**
	 * Creates a panel that contains a players information.
	 * @since CAH1.0
	 * @author Holt Maki
	 * @param player - the Player that who's information is displayed in the panel.
	 */
	public PlayerPanel(Player player) 
	{
		setMaximumSize(new Dimension(136, 130));
		setBorder(new CompoundBorder(new MatteBorder(0, 3, 0, 3, (Color) new Color(0, 0, 0)), new MatteBorder(0, 1, 0, 1, (Color) new Color(255, 255, 255))));
		setBackground(Color.BLACK);
		setBounds(new Rectangle(0, 0, 136, 130));
		this.player = player;
		setLayout(null);
		
		JLabel UserName = new JLabel("<html><body style=\"color:WHITE\">" + player.getUserName() + "</body></html>");
		UserName.setBounds(10, 0, 116, 14);
		add(UserName);

	}
}
