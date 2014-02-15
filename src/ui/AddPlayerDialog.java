package ui;

import java.awt.FlowLayout;

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
		playerUserName.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Player Username", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanel userInfoPanel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(userInfoPanel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(playerType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(playerUserName, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(playerUserName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(playerType, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userInfoPanel, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
					.addContainerGap())
		);
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
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
		

		aiInfoPanel.setLayout(null);
		
		if(rdbtnComputerPlayer.isSelected())
		{
			playerUserName.setVisible(false);
			
			
			gl_contentPanel.setHorizontalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(aiInfoPanel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(playerType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(playerUserName, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
							.addContainerGap())
				);
				gl_contentPanel.setVerticalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(playerUserName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(playerType, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(aiInfoPanel, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addContainerGap())
				);
		}
		//TODO: Once netplay is finished work on this to allow the server user to add players.
	}
}
