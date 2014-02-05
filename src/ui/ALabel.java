package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * A class that represents a label.
 * This label can be animated.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
@SuppressWarnings("serial")
public class ALabel extends JLabel implements Animated 
{
	
	/**
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	@Override
	public void grow(int newX, int newY, int sec) 
	{
		Timer timer = new Timer(20, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}

	/**
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	@Override
	public void grow(int pct, int sec) {
		// TODO Auto-generated method stub

	}

}
