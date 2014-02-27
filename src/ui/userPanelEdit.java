package ui;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class userPanelEdit extends JPanel
{
	private JTextField textField;

	/**
	 * Create the panel with no old information.
	 */
	public userPanelEdit()
	{
		setSize(new Dimension(336, 255));
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblUsername = new JLabel("Username:    ");
		panel.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		textField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField, 5, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField, 158, SpringLayout.WEST, panel_1);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:    ");
		panel.add(lblFirstName);
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new SpringLayout());
		
		JLabel lblLastName = new JLabel("Last Name:    ");
		panel.add(lblLastName);
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblGender = new JLabel("Gender:    ");
		panel.add(lblGender);
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		
	}
}
