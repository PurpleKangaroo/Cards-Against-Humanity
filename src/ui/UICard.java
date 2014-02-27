package ui;

import javax.swing.JPanel;

/**
 * A superclass for BlackCard and WhiteCard.
 * Its only function is to group them together with them both being Movable and with them both extending JPanel.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see BlackCard
 * @see WhiteCard
 *
 */
public class UICard extends JPanel implements Movable
{

	/**
	 * The Serial Version UID;
	 */
	private static final long serialVersionUID = -1416977320158975626L;

	@Override
	public void move(int newX, int newY, double sec)
	{
		// TODO Auto-generated method stub

	}

}
