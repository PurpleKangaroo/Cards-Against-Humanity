package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import cards.AnswerCard;

/**
 * A UICard that shows a blank white card to represent the back of a white card.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public final class BlankWhiteCard extends UICard
{
	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -8930263492361175453L;

	/**
	 * Where the X would be during an animation if it were a double.
	 * In each step of the animation, the X value is set to a rounded version of trueX,
	 * but trueX is kept the same so that over time the animation gets the object to its intended target.
	 */
	private double trueX;
	
	/**
	 * Where the Y would be during an animation if it were a double.
	 * In each step of the animation, the Y value is set to a rounded version of trueY,
	 * but trueY is kept the same so that over time the animation gets the object to its intended target.
	 */
	private double trueY;

	/**
	 * Create the panel.
	 * @since CAH1.0
	 * @author Holt Maki
	 * @param card - The {@linkplain AnswerCard} that the panel represents.
	 * @wbp.parser.constructor
	 */
	public BlankWhiteCard()
	{
		setFocusTraversalPolicyProvider(true);
		setBackground(new Color(Color.TRANSLUCENT));
		setSize(new Dimension(188, 270));
		setLayout(null);
		setOpaque(false);
		
		JLabel lblCard = new JLabel("");
		lblCard.setBounds(0, 5, 188, 270);
		lblCard.setIcon(new ImageIcon(WhiteCard.class.getResource("/graphics/wc.png")));
		add(lblCard);
		
		trueX = this.getX();
		trueY = this.getY();
	}

	@Override
	public void move(final int newX, final int newY, double sec)
	{
		final double xInterval = (newX - this.getX()) / (((double) sec) / (((double) Animated.DELAY) / 1000.0));
		final double yInterval = (newY - this.getY()) / (((double) sec) / (((double) Animated.DELAY) / 1000.0));
		
		trueX = this.getX();
		trueY = this.getY();
		
		final int xDif = newX - this.getX();
		final int yDif = newY - this.getY();
		
		final ActionListener timerlistener =  (new MTimerListener(xInterval, yInterval) {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				trueX = trueX + xInterval;
				trueY = trueY + yInterval;
				
				setLocation((int) trueX, (int) trueY);
				
				repaint();
				
				boolean xDone = (((xDif > 0) && (trueX >= newX)) || ((xDif < 0) && (trueX <= newX)) || xDif == 0) ? true: false;
				boolean yDone = (((yDif > 0) && (trueY >= newY)) || ((yDif < 0) && (trueY <= newY)) || yDif == 0) ? true: false;
				if(xDone && yDone)
				{
					firePropertyChange("movementTimerDone", false, true);
				}
			}
			
		});
		
		final Timer t = new Timer(Animated.DELAY, timerlistener);
		
		t.start();
		
		//Checks for if the timer is over the limit.
		this.addPropertyChangeListener("movementTimerDone", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent arg0)
			{
				if( !((boolean) arg0.getOldValue()) && ((boolean) arg0.getNewValue()))
				{
					t.stop();
					t.removeActionListener(timerlistener);
					firePropertyChange("cardStop", true, false);
				}
			}
			
		});
	}
}
