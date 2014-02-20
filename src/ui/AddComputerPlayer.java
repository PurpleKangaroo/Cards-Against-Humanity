package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddComputerPlayer extends JDialog
{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			AddComputerPlayer dialog = new AddComputerPlayer();
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
