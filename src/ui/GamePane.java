package ui;

import java.awt.Rectangle;

import javax.swing.JLayeredPane;
import java.awt.Color;

/**
 * The layered pane that contains the game.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class GamePane extends JLayeredPane {

	/**
	 * Creates the panel.
	 * @author Holt Maki
	 * @since CAH1.0
	 */
	public GamePane() {
		setOpaque(true);
		setBackground(Color.BLACK);
		setBounds(new Rectangle(0, 0, 1450, 700));

	}

}
