package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.Timer;

import cards.AnswerCard;


/**
 * A class of object that represents a white CAH card.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see BlackCard
 * @see cards.AnswerCard
 *
 */
public class WhiteCard extends UICard implements Movable
{
	
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -6324681620681730411L;

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
	 * The card represented by the WhiteCard.
	 */
	private AnswerCard answerCard;

	/**
	 * Create the panel.
	 * @since CAH1.0
	 * @author Holt Maki
	 * @param card - The {@linkplain AnswerCard} that the panel represents.
	 * @wbp.parser.constructor
	 */
	public WhiteCard(AnswerCard card)
	{
		setFocusTraversalPolicyProvider(true);
		setBackground(new Color(Color.TRANSLUCENT));
		setSize(new Dimension(188, 270));
		setLayout(null);
		
		String str = new String();
		str = card.getCardString();		
		
		JTextPane textArea = new JTextPane();
		textArea.setContentType("text/html");
		textArea.setText("<html><body style=\"font-family: Arial Black; font-size:15; font-color: BLACK\">" + str + "</body></html>");
		textArea.setDisabledTextColor(Color.BLACK);
		textArea.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textArea.setAutoscrolls(false);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setOpaque(false);
		textArea.setBounds(10, 11, 168, 192);
		add(textArea);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(91, 233, 87, 15);
		lblLogo.setIcon(new ImageIcon(WhiteCard.class.getResource("/graphics/icon_w.png")));
		add(lblLogo);
		
		JLabel lblCard = new JLabel("");
		lblCard.setBounds(0, 5, 188, 270);
		lblCard.setIcon(new ImageIcon(WhiteCard.class.getResource("/graphics/wc.png")));
		add(lblCard);
		
		answerCard = card;
		
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
