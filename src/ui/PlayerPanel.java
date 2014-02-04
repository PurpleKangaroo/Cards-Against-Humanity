package ui;

import javax.swing.JPanel;

import users.Player;

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
		this.player = player;

	}

}
