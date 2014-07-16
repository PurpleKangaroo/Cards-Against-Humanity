package ui;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.Box;


public class HouseRulesBar extends JPanel
{
	/**
	 * The name of the house rule that the bar lists.
	 */
	private String name;

	/**
	 * Creates an object that lists the name of a house rule.
	 * @param name The name of the house rule
	 */
	public HouseRulesBar(String name)
	{
		setBorder(new LineBorder(Color.WHITE));
		setOpaque(false);
		this.name = name;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel nameLbl = new JLabel(name);
		springLayout.putConstraint(SpringLayout.NORTH, nameLbl, 2, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLbl, 18, SpringLayout.NORTH, this);
		nameLbl.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, nameLbl, 6, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, nameLbl, -30, SpringLayout.EAST, this);
		add(nameLbl);
		
		Component verticalStrut = Box.createVerticalStrut(2);
		springLayout.putConstraint(SpringLayout.NORTH, verticalStrut, 0, SpringLayout.SOUTH, nameLbl);
		add(verticalStrut);
		
		
	}
}
