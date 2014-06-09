package ui;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
	
	/**
	 * Creates a new HouseRulePanel
	 * @param rulename The name of the House Rule.
	 * @param description A description of the House Rule.
	 * @since CAH1.0
	 */
	public HouseRulePanel(String rulename, JTextPane description)
	{
		setBackground(Color.BLACK);
		this.rulename = rulename;
		this.description = description;
		setLayout(null);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(0, 0, 0, 0);
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameLabel);
		
		selected = false;
	}
	
	/**
	 * Calls {@code super.setBounds(r)} as well as setting the width of description to the same width as the HouseRulePanel.
	 * @param r The rectangle that the bounds are being set to.
	 * @since CAH1.0
	 */
	public void setBounds(Rectangle r)
	{
		super.setBounds(r);
		description.setBounds(description.getX(), description.getY(), (int) r.getWidth(), description.getHeight());
	}
	
	/**
	 * Calls {@code super.setBounds(int x, int y, int width, int height)} as well as setting the width of description to the same width as the HouseRulePanel.
	 * @param x The new x location of the panel.
	 * @param y The new y location of the panel.
	 * @param width The new width of the panel.
	 * @param height The new height of the panel.
	 * @since CAH1.0
	 */
	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);
		description.setBounds(description.getX(), description.getY(), width, description.getHeight());
	}
	
	/**
	 * Call this method when the HouseRulesPanel is clicked.
	 * It should cause the description of the HouseRule to drop down in a sliding motion.
	 * Sets selected as false.
	 * Calls {@linkplain #slide(double)} with a parameter of 1.2 to have {@linkplain #description} slide down.
	 * @since CAH1.0
	 */
	public void clicked()
	{
		selected = false;
		this.setBounds(this.getX(), this.getY(), (int) this.getWidth(), (int) (this.getHeight() + description.getHeight()));
		
		try
		{
			slide(1.2, Slidable.DOWN);
		}
		catch (InvalidDirectionException e)
		{
			
		}
	}

	@Override
	public void slide(double sec, int dir) throws InvalidDirectionException
	{
		if(dir != Slidable.DOWN && dir != Slidable.UP)
		{
			throw new InvalidDirectionException();
		}
		
		if(dir == Slidable.DOWN)
		{
			//TODO fill
		}
		
		if(dir == Slidable.UP)
		{
			//TODO fill
		}
	}
}
