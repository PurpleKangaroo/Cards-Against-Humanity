package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * A class of object that represents the dialog box that allows the user to add or remove a player.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class AddPlayerDialog extends JDialog
{

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -500231145721899456L;

	/**
	 * The JPanel that contains the content of the dialog.
	 */
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * The JPanel that contains the buttons that decide what type of player is being added to the game.
	 */
	private JPanel playerType;
	
	/**
	 * The Button group that contains the buttons that decide what type of player is being added to the game.
	 */
	private final ButtonGroup playerTypeButtonGroup = new ButtonGroup();
	
	/**
	 * The player's IP adress if the player is a human player.
	 */
	private JTextField txtPlayerIp;

	/**
	 * Create the dialog.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public AddPlayerDialog()
	{
		setTitle("Add Player");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JRadioButton rdbtnComputerPlayer = new JRadioButton("Computer Player");
		rdbtnComputerPlayer.setSelected(true);
		
		getContentPane().add(contentPanel);
		{
			playerType = new JPanel();
			playerType.setBounds(15, 16, 223, 56);
			playerType.setBorder(new TitledBorder(null, "Player Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			{
				playerTypeButtonGroup.add(rdbtnComputerPlayer);
				playerType.add(rdbtnComputerPlayer);
			}
			{
				JRadioButton rdbtnHumanPlayer = new JRadioButton("Human Player");
				playerTypeButtonGroup.add(rdbtnHumanPlayer);
				playerType.add(rdbtnHumanPlayer);
			}
		}
		
		JPanel playerUserName = new JPanel();
		playerUserName.setBounds(244, 16, 175, 56);
		playerUserName.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Player Username", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setBounds(15, 78, 404, 135);
		userInfoPanel.setLayout(null);
		
		JTextArea userInformation = new JTextArea();
		userInformation.setOpaque(false);
		userInformation.setBounds(10, 11, 384, 113);
		userInfoPanel.add(userInformation);
		playerUserName.setLayout(null);
		//TODO:Fill this area with the user who's ip was entered's information if they are connecting to the game.
		
		txtPlayerIp = new JTextField();
		txtPlayerIp.setBounds(10, 18, 155, 20);
		playerUserName.add(txtPlayerIp);
		txtPlayerIp.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(312, 5, 47, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						//TODO also add the player to the game
					}
				});
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(364, 5, 65, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JPanel aiInfoPanel = new JPanel();
		
		JTextArea aiInformation = new JTextArea();
		aiInformation.setOpaque(false);
		aiInformation.setBounds(10, 11, 384, 113);
		aiInfoPanel.add(aiInformation);
		playerUserName.setLayout(null);
		contentPanel.setLayout(null);
		contentPanel.add(userInfoPanel);
		contentPanel.add(playerType);
		contentPanel.add(playerUserName);
		

		aiInfoPanel.setLayout(null);
		
		if(rdbtnComputerPlayer.isSelected())
		{
			playerUserName.setVisible(false);
		}
		//TODO: Once netplay is finished work on this to allow the server user to add players.
	}
	
	public static void main(String[] args)
	{
		try
		{
			AddPlayerDialog dialog = new AddPlayerDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
