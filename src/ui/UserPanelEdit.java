package ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;

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
 * @sicne CAH1.0
 * @version CAH1.0
 *
 */
public class UserPanelEdit extends JPanel
{
	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 5867800601067696778L;
	
	private JTextField usernameField;
	private JTextField firstNameTextField;
	private JTextField textField;

	/**
	 * Create the panel with no old information.
	 */
	public UserPanelEdit()
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
		
		usernameField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, usernameField, 5, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, usernameField, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, usernameField, 158, SpringLayout.WEST, panel_1);
		panel_1.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:    ");
		panel.add(lblFirstName);
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panel_2 = new JPanel();
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
		panel.add(lblLastName);
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		textField = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, textField, 5, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, textField, 158, SpringLayout.WEST, panel_3);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:    ");
		panel.add(lblGender);
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Select Your Gender");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		sl_panel_4.putConstraint(SpringLayout.NORTH, comboBox, 5, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, comboBox, 10, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, comboBox, 158, SpringLayout.WEST, panel_4);
		panel_4.add(comboBox);
		
		Panel panel_5 = new Panel();
		add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setBounds(146, 6, 44, 14);
		panel_5.add(lblBirthdate);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 27, 336, 100);
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblMonth = new JLabel("Month:    ");
		lblMonth.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_6.add(lblMonth);
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);
		SpringLayout sl_panel_10 = new SpringLayout();
		panel_10.setLayout(sl_panel_10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		sl_panel_10.putConstraint(SpringLayout.NORTH, comboBox_1, 5, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, comboBox_1, 10, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, comboBox_1, -3, SpringLayout.SOUTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, comboBox_1, 158, SpringLayout.WEST, panel_10);
		panel_10.add(comboBox_1);
		
		JLabel lblDay = new JLabel("Day:    ");
		lblDay.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_6.add(lblDay);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);
		panel_9.setLayout(new SpringLayout());
		
		JLabel lblYear = new JLabel("Year:    ");
		lblYear.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_6.add(lblYear);
		
		JPanel panel_12 = new JPanel();
		panel_6.add(panel_12);
		SpringLayout sl_panel_12 = new SpringLayout();
		panel_12.setLayout(sl_panel_12);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912"}));
		sl_panel_12.putConstraint(SpringLayout.NORTH, comboBox_2, 5, SpringLayout.NORTH, panel_12);
		sl_panel_12.putConstraint(SpringLayout.WEST, comboBox_2, 10, SpringLayout.WEST, panel_12);
		sl_panel_12.putConstraint(SpringLayout.SOUTH, comboBox_2, -3, SpringLayout.SOUTH, panel_12);
		sl_panel_12.putConstraint(SpringLayout.EAST, comboBox_2, 158, SpringLayout.WEST, panel_12);
		panel_12.add(comboBox_2);
		//TODO make day combo box depend on year and month selected
		
	}
}
