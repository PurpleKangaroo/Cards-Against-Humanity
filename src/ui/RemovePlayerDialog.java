package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

/**
 * A dialog that warns people when they remove a player and asks them to confirm the players removal.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class RemovePlayerDialog extends JDialog
{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public RemovePlayerDialog(String username)
	{
		setUndecorated(true);
		setAlwaysOnTop(true);
		//TODO: "are you sure you want to remove ___player?" (Options Yes, No)
		setBounds(100, 100, 203, 121);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setVisible(true);
		setOpacity(0.95f);
		{
			JTextPane txtpnAreYouSure = new JTextPane();
			txtpnAreYouSure.setAutoscrolls(false);
			txtpnAreYouSure.setRequestFocusEnabled(false);
			txtpnAreYouSure.setEditable(false);
			txtpnAreYouSure.setContentType("text/html");
			txtpnAreYouSure.setOpaque(false);
			txtpnAreYouSure.setBounds(10, 11, 183, 67);
			txtpnAreYouSure.setText("<html><body style =\"font-size:12; font-family: Dialog; font-style:bold\"><span style=\"font-color: black\"><strong>Are you sure you want to remove <span style=\"color:red\">" + username + "</span><span style=\" font-color: black\"> from the game?</strong></body></html>");
			txtpnAreYouSure.setFont(new Font("Arial Black", Font.PLAIN, 11));
			contentPanel.add(txtpnAreYouSure);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Yes");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						firePropertyChange("remove", false, true);
						setVisible(false);
					}
				});
				okButton.setFocusPainted(false);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton noButton = new JButton("No");
				noButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				noButton.setFocusPainted(false);
				buttonPane.add(noButton);
			}
		}
		
	}

}
