package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A class of object that represents a JDialog that adds a human player to a game of cards against humanity.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class AddHumanPlayer extends JDialog
{
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -6452759447783707265L;
	
	/**
	 * The name of the player being added.
	 */
	private String name;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField usernameTextField;
	private String username;

	/**
	 * Create the dialog.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public AddHumanPlayer()
	{
		setUndecorated(true);
		setBounds(100, 150, 220, 127);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel namePanel = new JPanel();
			namePanel.setBounds(32, 11, 178, 30);
			contentPanel.add(namePanel);
			{
				JLabel lblName = new JLabel("Name:");
				namePanel.add(lblName);
			}
			{
				textField = new JTextField();
				namePanel.add(textField);
				textField.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 45, 200, 30);
			contentPanel.add(panel);
			{
				JLabel labelUsername = new JLabel("Username:");
				panel.add(labelUsername);
			}
			{
				usernameTextField = new JTextField();
				usernameTextField.setColumns(10);
				panel.add(usernameTextField);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setRolloverEnabled(false);
				okButton.setFocusable(false);
				okButton.setFocusTraversalKeysEnabled(false);
				okButton.setFocusPainted(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						name = textField.getText();
						username = usernameTextField.getText();
						firePropertyChange("done", false, true);
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setRolloverEnabled(false);
				cancelButton.setFocusable(false);
				cancelButton.setFocusTraversalKeysEnabled(false);
				cancelButton.setFocusPainted(false);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setOpacity(0.95f);
	}
	
	/**
	 * Gets the user that is being added's name.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	protected String getPlayerName()
	{
		return name;
	}
	
	/**
	 * Gets the user that is being added's username.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	protected String getUsername()
	{
		return username;
	}
	
}
