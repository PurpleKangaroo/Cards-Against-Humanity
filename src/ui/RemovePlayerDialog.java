package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemovePlayerDialog extends JDialog
{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public RemovePlayerDialog(String username)
	{
		setAlwaysOnTop(true);
		//TODO: "are you sure you want to remove ___player?" (Options Yes, No)
		setBounds(100, 100, 160, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		setVisible(true);
		setOpacity(0.95f);
		{
			JTextPane txtpnAreYouSure = new JTextPane();
			txtpnAreYouSure.setEnabled(false);
			txtpnAreYouSure.setEditable(false);
			txtpnAreYouSure.setContentType("text/html");
			txtpnAreYouSure.setOpaque(false);
			txtpnAreYouSure.setBounds(10, 11, 140, 67);
			txtpnAreYouSure.setText("<html style=\"color:black\">Are you sure you want to remove <span style=\"color:red\">" + username + "</span> from the game?</html>");
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
