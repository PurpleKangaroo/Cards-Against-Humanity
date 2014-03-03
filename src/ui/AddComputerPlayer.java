package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * A JDialog that allows users to add computer players to a game of Cards Against Humanity.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class AddComputerPlayer extends JDialog
{

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 1008090860627237990L;
	
	/**
	 * The panel that contains everything but the "OK" and "Cancel" buttons.
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AddComputerPlayer()
	{
		setUndecorated(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//TODO: left and right key move each way through the computer player list
			}
		});
		setTitle("Add Computer Player");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JPanel computerInfoPanel = new JPanel();
			contentPanel.add(computerInfoPanel);
			computerInfoPanel.setLayout(new BoxLayout(computerInfoPanel, BoxLayout.Y_AXIS));
			{
				JPanel infoPanel = new JPanel();
				computerInfoPanel.add(infoPanel);
				infoPanel.setLayout(null);
				{
					JLabel lblName = new JLabel("Name:");
					lblName.setBounds(10, 11, 192, 14);
					infoPanel.add(lblName);
				}
				{
					JLabel lblDifficulty = new JLabel("Difficulty:");
					lblDifficulty.setBounds(10, 27, 192, 14);
					infoPanel.add(lblDifficulty);
				}
			}
			{
				JPanel statsPanel = new JPanel();
				computerInfoPanel.add(statsPanel);
			}
		}
		{
			JPanel computerPicturePanel = new JPanel();
			contentPanel.add(computerPicturePanel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setRolloverEnabled(false);
				okButton.setFocusTraversalKeysEnabled(false);
				okButton.setFocusPainted(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setRolloverEnabled(false);
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

}
