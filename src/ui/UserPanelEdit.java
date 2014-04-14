package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 * A panel that allows editing of user information.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class UserPanelEdit extends JPanel
{
	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 5867800601067696778L;
	
	/**
	 * The text field where the username is entered.
	 */
	private JTextField usernameField;
	
	/**
	 * The text field where the user's first name is entered.
	 */
	private JTextField firstNameTextField;
	
	/**
	 * The text field where the user's last name is entered.
	 */
	private JTextField lastNameTextField;
	
	/**
	 * The JComboBox where people enter their gender.
	 */
	private JComboBox genderComboBox;
	
	/**
	 * The JCombo box where the user enters their birthdate's month.
	 */
	private JComboBox monthComboBox;
	
	/**
	 * The JCombo box where the user enters their birthdate's year.
	 */
	private JComboBox yearComboBox;
	
	/**
	 * The JCombo box where the user enters their birthdate's day.
	 */
	private JComboBox dayComboBox;

	/**
	 * Create the panel with no old information.
	 */
	public UserPanelEdit()
	{
		setOpaque(false);
		setSize(new Dimension(336, 255));
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblUsername = new JLabel("Username:    ");
		lblUsername.setForeground(Color.WHITE);
		panel.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		usernameField = new JTextField();
		
		sl_panel_1.putConstraint(SpringLayout.NORTH, usernameField, 5, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, usernameField, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, usernameField, 158, SpringLayout.WEST, panel_1);
		panel_1.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:    ");
		lblFirstName.setForeground(Color.WHITE);
		panel.add(lblFirstName);
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		firstNameTextField = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, firstNameTextField, 5, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, firstNameTextField, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, firstNameTextField, 158, SpringLayout.WEST, panel_2);
		firstNameTextField.setColumns(10);
		panel_2.add(firstNameTextField);
		
		JLabel lblLastName = new JLabel("Last Name:    ");
		lblLastName.setForeground(Color.WHITE);
		panel.add(lblLastName);
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		lastNameTextField = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, lastNameTextField, 5, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lastNameTextField, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lastNameTextField, 158, SpringLayout.WEST, panel_3);
		panel_3.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:    ");
		lblGender.setForeground(Color.WHITE);
		panel.add(lblGender);
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		genderComboBox = new JComboBox();
		genderComboBox.setToolTipText("Select Your Gender");
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		sl_panel_4.putConstraint(SpringLayout.NORTH, genderComboBox, 5, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, genderComboBox, 10, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, genderComboBox, 158, SpringLayout.WEST, panel_4);
		panel_4.add(genderComboBox);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setForeground(Color.WHITE);
		lblBirthdate.setBounds(140, 6, 56, 14);
		panel_5.add(lblBirthdate);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_6.setBounds(0, 27, 336, 100);
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblMonth = new JLabel("Month:    ");
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_6.add(lblMonth);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_6.add(panel_10);
		SpringLayout sl_panel_10 = new SpringLayout();
		panel_10.setLayout(sl_panel_10);
		
		monthComboBox = new JComboBox();
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		sl_panel_10.putConstraint(SpringLayout.NORTH, monthComboBox, 5, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, monthComboBox, 10, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, monthComboBox, 158, SpringLayout.WEST, panel_10);
		panel_10.add(monthComboBox);
		
		JLabel lblDay = new JLabel("Day:    ");
		lblDay.setForeground(Color.WHITE);
		lblDay.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_6.add(lblDay);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_6.add(panel_9);
		SpringLayout sl_panel_9 = new SpringLayout();
		panel_9.setLayout(sl_panel_9);
		
		JLabel lblYear = new JLabel("Year:    ");
		lblYear.setForeground(Color.WHITE);
		lblYear.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_6.add(lblYear);
		
		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_6.add(panel_12);
		SpringLayout sl_panel_12 = new SpringLayout();
		panel_12.setLayout(sl_panel_12);
		
		yearComboBox = new JComboBox();
		String[] years = new String[120];
		GregorianCalendar cal = new GregorianCalendar();
		
		for(int i = 0; i < 110; i++)
		{
			years[i] = ((cal.get(cal.YEAR)) - i) + "";
		}
		yearComboBox.setModel(new DefaultComboBoxModel(years));
		sl_panel_12.putConstraint(SpringLayout.NORTH, yearComboBox, 5, SpringLayout.NORTH, panel_12);
		sl_panel_12.putConstraint(SpringLayout.WEST, yearComboBox, 10, SpringLayout.WEST, panel_12);
		sl_panel_12.putConstraint(SpringLayout.EAST, yearComboBox, 158, SpringLayout.WEST, panel_12);
		panel_12.add(yearComboBox);
		
		dayComboBox = new JComboBox();
		setDayComboBoxModel();
		sl_panel_9.putConstraint(SpringLayout.NORTH, dayComboBox, 5, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.WEST, dayComboBox, 10, SpringLayout.WEST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, dayComboBox, 158, SpringLayout.WEST, panel_9);
		panel_9.add(dayComboBox);
		
		yearComboBox.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent arg0)
			{
				setDayComboBoxModel();
				
			}
			
		});
		
		monthComboBox.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent arg0)
			{
				setDayComboBoxModel();
				
			}
			
		});
		//TODO make day combo box depend on year and month selected
		
	}
	
	/**
	 * Sets the day combo box's model to have the number of days of the currently selected month and year.
	 * @since CAH1.0
	 */
	private void setDayComboBoxModel()
	{
		int oldDay = 1;
		try
		{
			oldDay = Integer.parseInt((String) dayComboBox.getModel().getSelectedItem());
		}
		catch(Exception e)
		{
			
		}
		
		int Year = Integer.parseInt((String) yearComboBox.getModel().getSelectedItem());
		GregorianCalendar leapYearTest = new GregorianCalendar();
		
		int days = 0;
		switch((String) monthComboBox.getModel().getSelectedItem())
		{
			case "January":
				days = 31;
				break;
			case "February":
				days = leapYearTest.isLeapYear(Year) ? 29 : 28;
				break;
			case "March":
				days = 31;
				break;
			case "April":
				days = 30;
				break;
			case "May":
				days = 31;
				break;
			case "June":
				days = 30;
				break;
			case "July":
				days = 31;
				break;
			case "August":
				days = 31;
				break;
			case "September":
				days = 30;
				break;
			case "October":
				days = 31;
				break;
			case "November":
				days = 30;
				break;
			case "December":
				days = 31;
				break;
		}
		
		String[] dayArr = new String[days];
		
		for(int i = 1; i <= days; i++)
		{
			dayArr[i - 1] = i + "";
		}
		
		oldDay = oldDay > days ? days : oldDay;
		
		dayComboBox.setModel(new DefaultComboBoxModel(dayArr));
		dayComboBox.setSelectedIndex(oldDay - 1);
	}
}
