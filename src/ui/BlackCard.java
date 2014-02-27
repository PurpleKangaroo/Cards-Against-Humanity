package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.Timer;

import cards.QuestionCard;

/**
 * A class of object that represents a Black CAH card in the form of a panel.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see WhiteCard
 * @see cards.QuestionCard
 *
 */
public class BlackCard extends UICard implements Movable
{

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1241238135562778563L;

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
	 * @param card the {@linkplain cards.QuestionCard} represented by the panel.
	 */
	public BlackCard(QuestionCard card)
	{
		setFocusTraversalPolicyProvider(true);
		setBackground(new Color(Color.TRANSLUCENT));
		setSize(new Dimension(188, 270));
		setLayout(null);
		
		String str = new String();
		str = card.getCardString();
		
		JTextPane textArea = new JTextPane();
		textArea.setContentType("text/html");
		textArea.setDisabledTextColor(Color.WHITE);
		if(str.length() > 130)
		{
			textArea.setText("<html><body style=\"font-family: Arial Black; font-size:14; font-color: WHITE\">" + str + "</body></html>");
			textArea.setFont(new Font("Arial Black", Font.PLAIN, 14));
		}
		else
		{
			textArea.setText("<html><body style=\"font-family: Arial Black; font-size:15; font-color: WHITE\">" + str + "</body></html>");
			textArea.setFont(new Font("Arial Black", Font.PLAIN, 15));
		}
		textArea.setAutoscrolls(false);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setForeground(Color.WHITE);
		textArea.setOpaque(false);
		textArea.setBounds(10, 11, 168, 192);
		add(textArea);
		
		
		JLabel d2p3 = new JLabel("");
		d2p3.setBounds(new Rectangle(0, 0, 522, 37));
		d2p3.setIcon(new ImageIcon(BlackCard.class.getResource("/graphics/draw2pick3.png")));
		d2p3.setBounds(20, 206, 51, 40);
		add(d2p3);
		
		JLabel p2 = new JLabel("");
		p2.setBounds(new Rectangle(0, 0, 51, 21));
		p2.setSize(new Dimension(51, 21));
		p2.setIcon(new ImageIcon(BlackCard.class.getResource("/graphics/pick2.png")));
		p2.setBounds(20, 227, 51, 21);
		add(p2);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setSize(new Dimension(87, 15));
		lblLogo.setIcon(new ImageIcon(BlackCard.class.getResource("/graphics/icon_b.png")));
		lblLogo.setBounds(91, 233, 87, 15);
		add(lblLogo);
		
		JLabel lblCard = new JLabel("");
		lblCard.setBounds(0, 5, 188, 270);
		lblCard.setIcon(new ImageIcon(BlackCard.class.getResource("/graphics/bc.png")));
		add(lblCard);
		
		if(card.getDraw() != 2 || card.getPick() != 3)
		{
			d2p3.setVisible(false);
		}
		
		if(card.getPick() != 2)
		{
			p2.setVisible(false);
		}
		
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
		
		final Timer t = new Timer(Animated.DELAY, new MTimerListener(xInterval, yInterval) {

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
		
		t.start();
		
		//Checks for if the timer is over the limit.
		this.addPropertyChangeListener("movementTimerDone", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent arg0)
			{
				if( !((boolean) arg0.getOldValue()) && ((boolean) arg0.getNewValue()))
				{
					t.stop();
					firePropertyChange("cardStop", true, false);
				}
			}
			
		});
	}

}
