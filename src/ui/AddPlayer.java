package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A class of object that represents a dialog that askes the user which type of player they would like to add to a game of Cards Against Humanity.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class AddPlayer extends JDialog
{

	/**
	 * The generated serialVersionUID.
	 */
	private static final long serialVersionUID = 3687045392398171342L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Tells weather or not the user chose a human player to be added.
	 */
	private boolean human;
	/**
	 * Tells weather or not the user chose a computer player to be added.
	 */
	private boolean computer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			AddPlayer dialog = new AddPlayer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPlayer()
	{
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 247, 162);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnDoYouWish = new JTextPane();
			txtpnDoYouWish.setBounds(10, 10, 211, 47);
			txtpnDoYouWish.setBackground(UIManager.getColor("Panel.background"));
			txtpnDoYouWish.setDisabledTextColor(Color.BLACK);
			txtpnDoYouWish.setEnabled(false);
			txtpnDoYouWish.setEditable(false);
			txtpnDoYouWish.setFocusable(false);
			txtpnDoYouWish.setFocusCycleRoot(false);
			txtpnDoYouWish.setFocusTraversalKeysEnabled(false);
			txtpnDoYouWish.setText("Do you wish to add a computer player or a human player?");
			contentPanel.add(txtpnDoYouWish);
		}
			JPanel panel = new JPanel();
			panel.setBounds(10, 49, 211, 66);
			contentPanel.add(panel);
			
			final JRadioButton rdbtnComputerPlayer = new JRadioButton("Computer Player");
			rdbtnComputerPlayer.setFocusTraversalKeysEnabled(false);
			rdbtnComputerPlayer.setFocusPainted(false);
			rdbtnComputerPlayer.setSelected(true);
			buttonGroup.add(rdbtnComputerPlayer);
			panel.add(rdbtnComputerPlayer);
			{
				JRadioButton rdbtnHumanPlayer = new JRadioButton("Human Player");
				rdbtnHumanPlayer.setFocusTraversalKeysEnabled(false);
				rdbtnHumanPlayer.setFocusPainted(false);
				buttonGroup.add(rdbtnHumanPlayer);
				panel.add(rdbtnHumanPlayer);
			}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(rdbtnComputerPlayer.isSelected())
						{
							computer = true;
							human = false;
						}
						else
						{
							human = true;
							computer = false;
						}
						setVisible(false);
						firePropertyChange("visible", true, false);
					}
				});
				okButton.setFocusPainted(false);
				okButton.setFocusTraversalKeysEnabled(false);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
					}
					
				});
				cancelButton.setFocusPainted(false);
				cancelButton.setFocusTraversalKeysEnabled(false);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	/**
	 * Gets the boolean telling weather or not the player being added is a human player.
	 * @return human - the boolean telling weather or not the player being added is a human player.
	 * @since CAH1.0
	 */
	protected boolean getHuman()
	{
		return human;
	}
	
	/**
	 * Gets the boolean telling weather or not the player being added is a computer player.
	 * @return computer - the boolean telling weather or not the player being added is a computer player.
	 * @since CAH1.0
	 */
	protected boolean getComputer()
	{
		return computer;
	}
}
