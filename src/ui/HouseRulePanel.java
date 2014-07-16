package ui;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import javax.swing.Timer;

/**
 * A class of object that makes a panel that displays the house rules on it that will, when click have the description of the house rules drop down.
 * @author Holt Maki
 * @see RulesPanel
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class HouseRulePanel extends JPanel implements Slidable
{
	/**
	 * Generated serialVersionUID.
	 */
	private static final long serialVersionUID = -3648577661849701067L;

	/**
	 * The String that represents the name of the house rule that the HouseRulePanel represents.
	 */
	private String rulename;
	
	/**
	 * The boolean that tells whether or not the HouseRulePanel is selected.
	 * True if the HouseRulePanel is selected, else false.
	 */
	private boolean selected;
	
	/**
	 * The JTextPane that contains the description of the House Rule that the HouseRulePanel represents.
	 */	
	private JTextPane description;
	
	private SpringLayout springLayout;
	
	private int height;
	
	private int currentHeight;
	
	private HouseRulesBar nameLabel;
	
	/**
	 * Creates a new HouseRulePanel
	 * @param rulename The name of the House Rule.
	 * @param description A description of the House Rule.
	 * @since CAH1.0
	 */
	public HouseRulePanel(String rulename, String description)
	{
		setOpaque(false);
		this.rulename = rulename;
		this.description = new JTextPane();
		this.add(this.description);
		height = 40;
		
		nameLabel = new HouseRulesBar(rulename);
		springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, this.description, 0, SpringLayout.SOUTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, this.description, 2, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, this.description, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, this.description, 2, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, 20, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, this);
		setLayout(springLayout);
		add(nameLabel);
		
		selected = false;
		currentHeight = 0;
		
		this.addPropertyChangeListener("height", new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				heightUpdate();
			}
			
		});
	}

	@Override
	public void slide(double sec, int dir) throws InvalidDirectionException
	{
		if(dir != Slidable.DOWN && dir != Slidable.UP)
		{
			throw new InvalidDirectionException();
		}
		
		final int yInterval = 2;
		final int xInterval = 0;
		
		if(dir == Slidable.DOWN)
		{
			final ActionListener timerlistener =  (new MTimerListener(xInterval, yInterval) {

				@Override
				public void actionPerformed(ActionEvent e)
				{
					currentHeight = currentHeight + yInterval;
					System.out.println(currentHeight);
					
					firePropertyChange("height", 0, currentHeight);
					
					repaint();
					
					boolean heightDone = currentHeight >= height;
					if(heightDone)
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
						firePropertyChange("ruleStop", true, false);
					}
				}
				
			});
		}
		
		if(dir == Slidable.UP)
		{
			//TODO fill
		}
		
		
	}
	
	private void heightUpdate()
	{
		springLayout.removeLayoutComponent(description);
		
		springLayout.putConstraint(SpringLayout.NORTH, description, currentHeight, SpringLayout.SOUTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, this.description, 2, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, this.description, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, this.description, 2, SpringLayout.EAST, this);
		
		this.setBounds(this.getX(), this.getY(), this.getWidth(), this.currentHeight);
	}
}
