package ui;

import javax.swing.JPanel;
import javax.swing.Timer;

import users.Player;

import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;

/**
 * A class of object that represents the panel where a players information is displayed
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
@SuppressWarnings("serial")
public class PlayerPanel extends JPanel implements Movable
{
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
	
	//TODO set tooltip with html.
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
		setSize(new Dimension(136, 130));
		setMaximumSize(new Dimension(136, 130));
		setBorder(new CompoundBorder(new MatteBorder(0, 3, 0, 3, (Color) new Color(0, 0, 0)), new MatteBorder(0, 1, 0, 1, (Color) new Color(255, 255, 255))));
		setBackground(Color.BLACK);
		setBounds(new Rectangle(0, 0, 136, 130));
		this.player = player;
		setLayout(null);
		
		JLabel UserName = new JLabel("<html><body style=\"color:WHITE\">" + player.getUserName() + "</body></html>");
		UserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UserName.setBounds(10, 0, 116, 20);
		add(UserName);
		
		JLabel Name = new JLabel("<html><body style=\"color:WHITE\">" + player.getName() + "</body></html>");
		Name.setBounds(10, 22, 116, 14);
		add(Name);
		
		JPanel awesomePtsPanel = new JPanel();
		awesomePtsPanel.setBounds(68, 47, 58, 72);
		add(awesomePtsPanel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 47, 58, 72);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		addPropertyChangeListener("Card_Czar", new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent arg0)
			{
				cardCzar();
			}
			
		});

	}
	
	/**
	 * Sets the background to white if the player is the cardCzar.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	private void cardCzar()
	{
		//TODO: Change this
		if(player.getCard_Czar() == true)
		{
			setBackground(Color.WHITE);
		}
		else
		{
			setBackground(Color.BLACK);
		}
	}
	
	/**
	 * Sets the background to be white for the player using the gamepane.
	 * @since CAH1.0
	 */
	public void mainPlayerBackground()
	{
		setBackground(Color.WHITE);
	}
	
	/**
	 * Sets the image that represents the player.
	 * @since incomplete
	 */
	private void setImage()
	{
		//TODO fill
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
