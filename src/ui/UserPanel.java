package ui;

import import_export.UserData;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 * A JPanel that shows a user's information.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class UserPanel extends JPanel
{
	private UserData data;

	/**
	 * Create the panel.
	 * @since CAH1.0
	 */
	public UserPanel()
	{
		setOpaque(false);
		setBackground(Color.BLACK);
		setSize(new Dimension(336, 255));
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel label = new JLabel("Username:    ");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel usernameLabel = new JLabel("New label");//data.getUsername();
		usernameLabel.setForeground(Color.WHITE);
		sl_panel_1.putConstraint(SpringLayout.NORTH, usernameLabel, 5, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, usernameLabel, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, usernameLabel, -5, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, usernameLabel, 158, SpringLayout.WEST, panel_1);
		panel_1.add(usernameLabel);
		
		JLabel label_1 = new JLabel("First Name:    ");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setForeground(Color.WHITE);
		panel.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel FirstName = new JLabel("New label");//data.getFirstname();
		sl_panel_2.putConstraint(SpringLayout.NORTH, FirstName, 5, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, FirstName, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, FirstName, -5, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, FirstName, 158, SpringLayout.WEST, panel_2);
		FirstName.setForeground(Color.WHITE);
		panel_2.add(FirstName);
		
		JLabel label_2 = new JLabel("Last Name:    ");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setForeground(Color.WHITE);
		panel.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JLabel LastName = new JLabel("New label");//data.getLastname();
		sl_panel_3.putConstraint(SpringLayout.NORTH, LastName, 5, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, LastName, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, LastName, -5, SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, LastName, 158, SpringLayout.WEST, panel_3);
		LastName.setForeground(Color.WHITE);
		panel_3.add(LastName);
		
		JLabel label_3 = new JLabel("Gender:    ");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setForeground(Color.WHITE);
		panel.add(label_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JLabel genderLabel = new JLabel("New label");//data.getGender();
		sl_panel_4.putConstraint(SpringLayout.NORTH, genderLabel, 5, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, genderLabel, 10, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, genderLabel, -5, SpringLayout.SOUTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, genderLabel, 158, SpringLayout.WEST, panel_4);
		genderLabel.setForeground(Color.WHITE);
		panel_4.add(genderLabel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setLayout(null);
		add(panel_5);
		
		JLabel label_4 = new JLabel("Birthdate");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(146, 6, 44, 14);
		panel_5.add(label_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_6.setBounds(0, 27, 336, 100);
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel label_5 = new JLabel("Month:    ");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setForeground(Color.WHITE);
		panel_6.add(label_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_6.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);
		
		JLabel label_8 = new JLabel("New label");//data.getBirthdate().MONTH;
		sl_panel_7.putConstraint(SpringLayout.NORTH, label_8, 5, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, label_8, 10, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, label_8, -5, SpringLayout.SOUTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, label_8, 158, SpringLayout.WEST, panel_7);
		label_8.setForeground(Color.WHITE);
		panel_7.add(label_8);
		
		JLabel label_6 = new JLabel("Day:    ");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setForeground(Color.WHITE);
		panel_6.add(label_6);
		
		JPanel panel_8 = new JPanel();//data.getBirthdate().DAY;
		panel_8.setOpaque(false);
		panel_6.add(panel_8);
		SpringLayout sl_panel_8 = new SpringLayout();
		panel_8.setLayout(sl_panel_8);
		
		JLabel label_9 = new JLabel("New label");
		sl_panel_8.putConstraint(SpringLayout.NORTH, label_9, 5, SpringLayout.NORTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.WEST, label_9, 10, SpringLayout.WEST, panel_8);
		sl_panel_8.putConstraint(SpringLayout.SOUTH, label_9, -5, SpringLayout.SOUTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.EAST, label_9, 158, SpringLayout.WEST, panel_8);
		label_9.setForeground(Color.WHITE);
		panel_8.add(label_9);
		
		JLabel label_7 = new JLabel("Year:    ");
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setForeground(Color.WHITE);
		panel_6.add(label_7);
		
		JPanel panel_9 = new JPanel();//data.getBirthdate().YEAR;
		panel_9.setOpaque(false);
		panel_6.add(panel_9);
		SpringLayout sl_panel_9 = new SpringLayout();
		panel_9.setLayout(sl_panel_9);
		
		JLabel label_10 = new JLabel("New label");
		sl_panel_9.putConstraint(SpringLayout.NORTH, label_10, 5, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.WEST, label_10, 10, SpringLayout.WEST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, label_10, -5, SpringLayout.SOUTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, label_10, 158, SpringLayout.WEST, panel_9);
		label_10.setForeground(Color.WHITE);
		panel_9.add(label_10);

	}
}
